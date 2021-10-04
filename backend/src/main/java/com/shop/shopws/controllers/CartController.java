package com.shop.shopws.controllers;

import com.shop.shopws.dto.CartDTO;
import com.shop.shopws.entities.Cart;
import com.shop.shopws.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<CartDTO> add(@Valid @RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.add(cart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> findById(@Valid @PathVariable("id") Long id) {
        return ResponseEntity.ok(cartService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDTO> edit(@PathVariable("id") Long id, @RequestBody Cart cartUpdated) {
        return ResponseEntity.ok(cartService.edit(id, cartUpdated));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CartDTO> addItem(@PathVariable("id") Long id, @RequestParam Long itemId) {
        return ResponseEntity.ok(cartService.addItem(id, itemId));
    }
}
