package com.zosh.zosh.pos.system.repositories;

import com.zosh.zosh.pos.system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
    public User findByEmail(String email);
}
