package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemDto;
import com.example.demo.service.ItemService;
import com.example.demo.ui.ItemRequestModel;
import com.example.demo.ui.ItemResponseModel;
@RestController
@RequestMapping("/items")
public class ItemController {
	
	private ItemService itemService;
	private ModelMapper modelMapper;
	private Environment environment;
	@Autowired
	public ItemController(ItemService itemService, ModelMapper modelMapper,Environment environment) {
		this.itemService = itemService;
		this.modelMapper = modelMapper;
		this.environment=environment;
	}
	@GetMapping("/status")
	public ResponseEntity<String> getStatuc()
	{
		return ResponseEntity.ok("application running port:"+environment.getProperty("local.server.port"));
	}
	
	@PostMapping
	public ResponseEntity<ItemResponseModel> createItem(ItemRequestModel itemDetails)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ItemDto dto=modelMapper.map(itemDetails, ItemDto.class);
		ItemResponseModel model=itemService.createItem(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
		
	}

	
}
