package com.example.demo.service;

import com.example.demo.dto.ItemDto;
import com.example.demo.ui.ItemResponseModel;

public interface ItemService {

	public ItemResponseModel createItem(ItemDto itemDto);
}
