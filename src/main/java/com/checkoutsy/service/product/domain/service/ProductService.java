package com.checkoutsy.service.product.domain.service;

import com.checkoutsy.service.product.domain.dao.ProductDao;
import com.checkoutsy.service.product.domain.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public Product create(final Product product) {
        return productDao.save(product);
    }

    public Optional<Product> findById(final Long productId) {
        return productDao.findById(productId);
    }
}
