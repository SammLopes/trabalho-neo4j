package br.trabalho.trab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TrabApplication {

	@GetMapping(value = "/", produces = "application/json")
	public String index(){
		return "{\"mensagem\":\"ok\"}";
	}

	public static void main(String[] args) {
		SpringApplication.run(TrabApplication.class, args);
	}

}
