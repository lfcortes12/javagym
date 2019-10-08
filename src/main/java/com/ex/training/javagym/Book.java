package com.ex.training.javagym;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@ToString(of = {"name"})
@Getter
@Builder
@AllArgsConstructor
public class Book {
	
	private final String name;
	private final String esbn;

}
