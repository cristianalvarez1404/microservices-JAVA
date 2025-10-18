package com.zosh.zosh.pos.system.repositories;

import com.zosh.zosh.pos.system.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
    Store findByStoreAdminId(Long adminId);
}
