package com.ex.training.javagym;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ex.training.javagym.functionalinterface.FunctionalInterfacesSample;
import com.ex.training.javagym.functionalinterface.FunctionalInterfacesSample.BookProcessorFn;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JavagymApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavagymApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Running ....");
		
		// functions
		FunctionalInterfacesSample functionalInterfacesSample = new FunctionalInterfacesSample();
		String documentDesc = functionalInterfacesSample.calculateIdentification("CC", type -> {
			return type.equalsIgnoreCase("CC") ? "Cedula" : "Tarjeta Identidad";
		});
		
		List<Book> books = Arrays.asList(buildBook("Java", "12"), buildBook("C++", "34"));
		//functional interfaces
		BookProcessorFn bookProcessorAddingFn = allBooks -> {
			
			 List<Book> collect = allBooks.stream().filter(book -> book.getName().equalsIgnoreCase("java")).collect(Collectors.toList());
			 collect.add(buildBook("EA", "98"));
			 
			 return collect;
		};
		
		BookProcessorFn bookProcessorStdFn = allBooks -> {
		
			 return allBooks.stream().filter(book -> book.getName().equalsIgnoreCase("java")).collect(Collectors.toList());			 
		};
			
		log.info("Filtered books Adding");
		bookProcessorAddingFn.process(books).forEach(System.out::println);
		log.info("Filtered books STD");
		bookProcessorStdFn.process(books).forEach(System.out::println);
		log.info("Result {}", documentDesc);
		
	}

	private Book buildBook(String name, String esbn) {
		return Book.builder().name(name).esbn(esbn).build();
	}

}
