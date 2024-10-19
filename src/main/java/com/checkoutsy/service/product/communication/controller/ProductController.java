package com.checkoutsy.service.product.communication.controller;

import com.checkoutsy.service.product.communication.dto.ProductDto;
import com.checkoutsy.service.product.communication.mapper.ProductMapper;
import com.checkoutsy.service.product.domain.model.Product;
import com.checkoutsy.service.product.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product = productService.create(product);

        ProductDto createdProductDto = productMapper.toDto(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductDto);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findById(@PathVariable final Long productId) {
        Product product = productService.findById(productId).orElse(null);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ProductDto productDto = productMapper.toDto(product);

        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }
}
