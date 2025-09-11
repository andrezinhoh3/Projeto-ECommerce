package br.com.ecommerce.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Api de E-commerce",
        version = "1.0",
        description = "API responsável por gerenciar os recursos de um sistema de e-commerce, como clientes, produtos e pedidos."
))
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);


	}

}
