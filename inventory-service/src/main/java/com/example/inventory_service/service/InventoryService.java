package com.example.inventory_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository InventoryRepository;

       public synchronized void decreaseStock(Long productId, int quantity) {
        Inventory inv = InventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found in inventory"));
        if (inv.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        inv.setQuantity(inv.getQuantity() - quantity);
        InventoryRepository.save(inv);
    }
    


}
