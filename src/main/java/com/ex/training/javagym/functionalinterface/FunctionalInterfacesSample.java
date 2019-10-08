package com.ex.training.javagym.functionalinterface;

import java.util.List;
import java.util.function.Function;

import com.ex.training.javagym.Book;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FunctionalInterfacesSample {
	
	
	public String calculateIdentification(String type, Function<String, String> iterate) {
		return iterate.apply(type);
	}
	
	@FunctionalInterface
	public interface BookProcessorFn {
		
		List<Book> process(final List<Book> books); 
		
	}

	
}
