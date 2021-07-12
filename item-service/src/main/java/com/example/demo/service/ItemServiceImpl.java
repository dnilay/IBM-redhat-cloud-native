package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemDao;
import com.example.demo.dto.ItemDto;
import com.example.demo.model.Item;
import com.example.demo.ui.ItemResponseModel;

@Service
public class ItemServiceImpl implements ItemService {
	private ItemDao itemDao;
	private ModelMapper modelMapper;

	@Autowired
	public ItemServiceImpl(ItemDao itemDao, ModelMapper modelMapper) {
		this.itemDao = itemDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ItemResponseModel createItem(ItemDto itemDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Item item = modelMapper.map(itemDto, Item.class);
		Item item1 = itemDao.save(item);
		return modelMapper.map(item1, ItemResponseModel.class);
	}

}
