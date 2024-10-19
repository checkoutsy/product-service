package com.checkoutsy.service.product.communication.mapper;

import com.checkoutsy.service.product.communication.dto.ProductDto;
import com.checkoutsy.service.product.domain.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductMapper {

    public ProductDto toDto(final Product product) {
        final ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setUpdatedAt(product.getUpdatedAt());

        return dto;
    }

    public Product toEntity(final ProductDto dto) {
        final Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setCreatedAt(LocalDateTime.now());

        return product;
    }
}
