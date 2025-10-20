package com.zosh.zosh.pos.system.service.impl;

import com.zosh.zosh.pos.system.models.User;
import com.zosh.zosh.pos.system.payload.dto.ProductDto;
import com.zosh.zosh.pos.system.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDto createProduct(ProductDto productDto, User user) {
        return null;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto, User user) {
        return null;
    }

    @Override
    public void deleteProduct(Long id, User user) {

    }

    @Override
    public List<ProductDto> getProductsByStoreId(Long storeId) {
        return List.of();
    }

    @Override
    public List<ProductDto> searchByKeyword(Long storeId, String keyword) {
        return List.of();
    }
}
