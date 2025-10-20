package com.zosh.zosh.pos.system.payload.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String sku;
    private String description;
    private Double mrp;
    private Double sellingPrice;
    private String brand;
    private String image;
    // private Category category;
    private Long categoryId;
    private Long storeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
