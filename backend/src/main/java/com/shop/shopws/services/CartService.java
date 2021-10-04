package com.shop.shopws.services;

import com.shop.shopws.dto.CartDTO;
import com.shop.shopws.entities.Cart;

public interface CartService {
    CartDTO add(Cart cart);
    CartDTO findById(Long id);
    CartDTO edit(Long id, Cart cartUpdated);
    CartDTO addItem(Long cartId, Long itemId);
}
