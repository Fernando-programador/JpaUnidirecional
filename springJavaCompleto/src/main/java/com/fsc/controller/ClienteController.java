package com.fsc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.model.Cliente;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@GetMapping("/cliente")
	public Cliente obterCliente() {
		return new Cliente(28,"Fernando", "315.125.125-89");
	}
	
	@GetMapping
	public Cliente obterClineteId(@RequestParam(name= "id",defaultValue = "1") int id) {
		return new Cliente (id, "fulano", "123-456-789-58");
	}
	
}
