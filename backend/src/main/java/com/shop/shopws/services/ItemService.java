package com.shop.shopws.services;

import com.shop.shopws.dto.ItemDTO;
import com.shop.shopws.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {
    ItemDTO add(Item item);
    Page<ItemDTO> findAll(Pageable pageable);
    ItemDTO findById(Long id);
    ItemDTO edit(Long id, Item itemUpdated);
}
