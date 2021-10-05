package com.shop.shopws.services.impl;

import com.shop.shopws.dto.ItemDTO;
import com.shop.shopws.entities.Item;
import com.shop.shopws.repositories.CartRepository;
import com.shop.shopws.repositories.ItemRepository;
import com.shop.shopws.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public ItemDTO add(Item item) {
        return new ItemDTO(itemRepository.save(item));
    }

    @Override
    public Page<ItemDTO> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable).map(ItemDTO::new);
    }

    @Override
    public ItemDTO findById(Long id) {
        return new ItemDTO(itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public ItemDTO edit(Long id, Item itemUpdated) {
        return itemRepository.findById(id).map(item -> {
            itemUpdated.setCreatedAt(item.getCreatedAt());
            itemUpdated.setId(item.getId());
            return new ItemDTO(itemRepository.save(itemUpdated));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
