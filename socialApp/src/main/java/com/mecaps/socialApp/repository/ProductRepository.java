package com.mecaps.socialApp.repository;

import com.mecaps.socialApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
