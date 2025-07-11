package com.example.demo.ui.model;

import java.time.LocalDate;

import org.checkerframework.common.value.qual.MinLen;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product{

	private Long id;
	
	@NotBlank
	@Length(min = 3, message = "Minimo de 3 caracters")
	private String name;
	
	@NotBlank
	@Length(min = 2, message = "Minimo de 3 caracters")
	private String code;
	
	@NotNull(message = "Data de validade é Obrigatoria")
	private Purveyor purveyor;
	
	@NotNull(message = "Data de validade é Obrigatoria")
	@FutureOrPresent(message = "Data de validade tem que ser superior ao dia atual")
	private LocalDate validate;

	private boolean avaliable;
	
}
