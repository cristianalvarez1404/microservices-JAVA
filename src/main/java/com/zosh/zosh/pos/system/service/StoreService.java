package com.zosh.zosh.pos.system.service;

import com.zosh.zosh.pos.system.domain.StoreStatus;
import com.zosh.zosh.pos.system.exceptions.UserException;
import com.zosh.zosh.pos.system.models.User;
import com.zosh.zosh.pos.system.payload.dto.StoreDto;
import java.util.List;

public interface StoreService {
    public StoreDto createStore(StoreDto storeDto, User user);
    public StoreDto getStoreById(Long id) throws Exception;
    public List<StoreDto> getAllStores();
    public StoreDto getStoreByAdmin() throws UserException;
    public StoreDto updateStore(Long id, StoreDto storeDto) throws Exception;
    public void deleteStore(Long id) throws UserException;
    public StoreDto getStoreByEmployee() throws UserException;
    public StoreDto moderateStore(Long id, StoreStatus status) throws Exception;

}
