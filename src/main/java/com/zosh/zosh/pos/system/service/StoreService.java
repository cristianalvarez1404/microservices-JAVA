package com.zosh.zosh.pos.system.service;

import com.zosh.zosh.pos.system.models.User;
import com.zosh.zosh.pos.system.payload.dto.StoreDto;
import java.util.List;

public interface StoreService {
    public StoreDto createStore(StoreDto storeDto, User user);
    public StoreDto getStoreById(Long id) throws Exception;
    public List<StoreDto> getAllStores();
    public StoreDto getStoreByAdmin();
    public StoreDto updateStore(Long id, StoreDto storeDto);
    public void deleteStore(Long id);
    public StoreDto getStoreByEmployee();
}
