package com.zosh.zosh.pos.system.service.impl;

import com.zosh.zosh.pos.system.configuration.JwtProvider;
import com.zosh.zosh.pos.system.domain.UserRole;
import com.zosh.zosh.pos.system.exceptions.UserException;
import com.zosh.zosh.pos.system.mapper.UserMapper;
import com.zosh.zosh.pos.system.models.User;
import com.zosh.zosh.pos.system.payload.dto.UserDto;
import com.zosh.zosh.pos.system.payload.response.AuthResponse;
import com.zosh.zosh.pos.system.repositories.UserRepository;
import com.zosh.zosh.pos.system.service.AuthService;
import jdk.jshell.spi.ExecutionControl;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@Getter
@Setter
@RequiredArgsConstructor
@Data
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtProvider jwtProvider;
    private CustomUserImplementation customUserImplementation;

    @Override
    public AuthResponse signup(UserDto userDto) throws UserException {
        User user = userRepository.findByEmail(userDto.getEmail());
        if(user != null){
            throw new UserException("email id already registered !");
        }

        if(userDto.getRole().equals(UserRole.ROLE_ADMIN)){
            throw new UserException("role admin is not allowed!");
        }

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(userDto.getRole());
        newUser.setFullName(userDto.getFullName());
        newUser.setPhone(userDto.getPhone());
        newUser.setLastLogin(LocalDateTime.now());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDto.getEmail(), userDto.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Registered Successfully");
        authResponse.setUser(UserMapper.toDTO(savedUser));

        return authResponse;
    }

    @Override
    public AuthResponse login(UserDto userDto) {
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        Authentication authentication = authenticate(email,password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String role = authorities.iterator().next().getAuthority();

        String jwt = jwtProvider.generateToken(authentication);

        User user = userRepository.findByEmail(email);

        user.setLastLogin(LocalDateTime.now());
        User savedUser = userRepository.save(user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Login Successfully");
        authResponse.setUser(UserMapper.toDTO(savedUser));

        return authResponse;
    }

    private Authentication authenticate(String email, String password) throws UserException {

        UserDetails userDetails = customUserImplementation.loadUserByUsername(email);

        if ( userDetails == null ){
            throw new UserException("email id doesn't exist "+ email);
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new UserException("password doesn't match");
        }

        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}



