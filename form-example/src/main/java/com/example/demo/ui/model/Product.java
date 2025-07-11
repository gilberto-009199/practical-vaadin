package com.example.demo.ui.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product{
	
	private Long id;
	private String name;
	private String code;
	private boolean avaliable;
	private Purveyor purveyor;
	private LocalDate validate;
	
	
}
