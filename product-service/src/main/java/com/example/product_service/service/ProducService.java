package com.example.payment_service.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment_service.repository.ProductRepository;
import com.netflix.discovery.converters.Auto;
import com.example.payment_service.dto.ProductDTO;

@Service
public class ProducService {
    @Autowired
    private ProductRepository productRepository;


    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());  // Convert Product entities to ProductDTOs
    }

    public ProductDTO getById(Long id) {
        return toDTO(productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found")));
    }

    public ProductDTO save(ProductDTO dto) {
        Product saved = productRepository.save(fromDTO(dto));
        return toDTO(saved);
    }

    private ProductDTO toDTO(Product p) {
        return new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getStock());
    }

    private Product fromDTO(ProductDTO dto) {
        Product p = new Product();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());
        return p;
    }

}
