package com.checkoutsy.service.product.communication.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductDto {

    private Long id;

    @Size(min = 3, max = 50)
    private String title;

    @Size(max = 20)
    private String category;

    @Size(max = 500)
    private String description;

    @Past
    private LocalDateTime createdAt;

    @Future
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50) String getTitle() {
        return title;
    }

    public void setTitle(@Size(min = 3, max = 50) String title) {
        this.title = title;
    }

    public @Size(max = 20) String getCategory() {
        return category;
    }

    public void setCategory(@Size(max = 20) String category) {
        this.category = category;
    }

    public @Size(max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 500) String description) {
        this.description = description;
    }

    public @Past LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@Past LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public @Future LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(@Future LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(title, that.title)
                && Objects.equals(category, that.category)
                && Objects.equals(description, that.description)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, description, createdAt, updatedAt);
    }
}
