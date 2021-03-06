package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Item {
	private Integer id;
	private String itemNumber;
	private String itemName;
	private Double itemPrice;
	private Boolean isAvailable;


}
