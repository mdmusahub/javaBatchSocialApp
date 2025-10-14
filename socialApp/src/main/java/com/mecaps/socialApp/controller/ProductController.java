package com.mecaps.socialApp.controller;


import com.mecaps.socialApp.entity.Product;
import com.mecaps.socialApp.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    public ProductController(ProductRepository productRepository, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }


    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        return ResponseEntity.ok(product);
    }


    //  filter name, price

    @GetMapping("/filter")
    public List<Product> getProductByNameAndPrice(@RequestParam String name,
                                                  @RequestParam String price){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> criteriaQuery = criteriaBuilder
                .createQuery(Product.class);

        Root<Product> root = criteriaQuery.from(Product.class);
        List<Predicate> condition = new ArrayList<>();

        if (name != null){
            condition.add(criteriaBuilder.equal(root.get("name"), name));
        }
        if (price !=null){
            condition.add(criteriaBuilder.equal(root.get("price"),price));
        }

        criteriaQuery.select(root).where(condition.toArray(new Predicate[0]));

//        criteriaQuery.select(root)
//                .where(criteriaBuilder.or(condition.toArray((new Predicate[0]))));
//
        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);

        return  query.getResultList();


    }
}

