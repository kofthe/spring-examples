package dev.kofthe.jakartauuid;

import dev.kofthe.jakartauuid.model.Product;
import dev.kofthe.jakartauuid.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JakartauuidApplication {

	public static void main(String[] args) {
		SpringApplication.run(JakartauuidApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			List<Product> products = List.of(new Product("Product1"), new Product("Product 2"), new Product("Product3"));
			productRepository.saveAll(products);

			productRepository.findAll().stream().forEach(System.out::println);
		};

	}



}
