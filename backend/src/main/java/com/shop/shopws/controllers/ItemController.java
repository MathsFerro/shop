package com.shop.shopws.controllers;

import com.shop.shopws.dto.ItemDTO;
import com.shop.shopws.entities.Cart;
import com.shop.shopws.entities.Item;
import com.shop.shopws.services.CartService;
import com.shop.shopws.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> add(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemService.add(item));
    }

    @GetMapping
    public ResponseEntity<Page<ItemDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(itemService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> findById(@Valid @PathVariable("id") Long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }
}
