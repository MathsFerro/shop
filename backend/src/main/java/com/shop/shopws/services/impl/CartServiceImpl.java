package com.shop.shopws.services.impl;

import com.shop.shopws.dto.CartDTO;
import com.shop.shopws.entities.Cart;
import com.shop.shopws.entities.Item;
import com.shop.shopws.repositories.CartRepository;
import com.shop.shopws.repositories.ItemRepository;
import com.shop.shopws.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public CartDTO add(Cart cart) {
        return new CartDTO(cartRepository.save(cart));
    }

    @Override
    public CartDTO findById(Long id) {
        return new CartDTO(cartRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public CartDTO edit(Long id, Cart cartUpdated) {
        return cartRepository.findById(id).map(cart -> {
            cartUpdated.setCreatedAt(cart.getCreatedAt());
            cartUpdated.setId(cart.getId());
            return new CartDTO(cartRepository.save(cartUpdated));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CartDTO addItem(Long cartId, Long itemId) {
        Cart cart = new Cart(findById(cartId));
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        cart.getItems().add(item);

        return edit(cartId, cart);
    }
}
