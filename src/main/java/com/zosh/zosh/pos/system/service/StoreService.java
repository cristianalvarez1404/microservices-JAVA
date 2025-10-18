package com.zosh.zosh.pos.system.service;

import com.zosh.zosh.pos.system.models.User;
import com.zosh.zosh.pos.system.payload.dto.StoreDto;
import java.util.List;

public interface StoreService {
    public StoreDto createStore(StoreDto storeDto, User user);
    public StoreDto getStoreById(Long id);
    public List<StoreDto> getAllStores();
    public StoreDto getStoreByAdmin(String name);
    public StoreDto updateStore(Long id, StoreDto storeDto);
    public StoreDto deleteStore(Long id);
    public StoreDto getStoreByEmployee();
}
