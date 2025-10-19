package com.zosh.zosh.pos.system.payload.dto;

import com.zosh.zosh.pos.system.domain.StoreStatus;
import com.zosh.zosh.pos.system.models.StoreContact;
import com.zosh.zosh.pos.system.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StoreDto {
    private Long id;
    private String brand;
    private UserDto storeAdmin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
    private String storeType;
    private StoreStatus status;
    private StoreContact contact;
}
