package com.zosh.zosh.pos.system.service;

import com.zosh.zosh.pos.system.models.User;
import com.zosh.zosh.pos.system.payload.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto, User user);
    ProductDto updateProduct(Long id, ProductDto productDto, User user);
    void deleteProduct(Long id, User user);
    List<ProductDto> getProductsByStoreId(Long storeId);
    List<ProductDto> searchByKeyword(Long storeId, String keyword);
}
