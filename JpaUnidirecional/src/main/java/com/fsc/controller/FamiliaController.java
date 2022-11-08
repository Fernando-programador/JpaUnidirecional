package com.fsc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.fsc.execption.ResourceNotFoundException;
import com.fsc.model.Familia;
import com.fsc.repository.FamiliaDetailsRepository;
import com.fsc.repository.FamiliaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FamiliaController {

	@Autowired
	FamiliaRepository familiaRepository;

	@Autowired
	FamiliaDetailsRepository detailsRepository;

	@GetMapping("/familia")
	public ResponseEntity<List<Familia>> getAllFamilia(@RequestParam(required = false) String nome) {
		List<Familia> familias = new ArrayList<Familia>();

		if (nome == null)
			familiaRepository.findAll().forEach(familias::add);
		else
			familiaRepository.findByNome(nome).forEach(familias::add);

		if (familias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(familias, HttpStatus.OK);

	}

	@GetMapping("/familia/{id}")
	public ResponseEntity<Familia> getFamiliaId(@PathVariable("id") long id) {
		Familia familia = familiaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não pessoa da família com cadastr do id = " + id));
		return new ResponseEntity<>(familia, HttpStatus.OK);
	}

	@PostMapping("/familia")
	public ResponseEntity<Familia> criarPessoa(Familia familia) {
		Familia addFamilia = familiaRepository
				.save(new Familia(familia.getNome(), familia.getIdade(), familia.getCpf()));

		return new ResponseEntity<>(addFamilia, HttpStatus.CREATED);
	}

	@PutMapping("/familia/{id}")
	public ResponseEntity<Familia> updateFamilia(@PathVariable("id") long id, Familia familia) {
		Familia upFamilia = familiaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa cadastrada com o id: " + id));
		upFamilia.setNome(familia.getNome());
		upFamilia.setIdade(familia.getIdade());
		upFamilia.setCpf(familia.getCpf());

		return new ResponseEntity<>(familiaRepository.save(upFamilia), HttpStatus.OK);
	}

	@DeleteMapping("/familia/{id}")
	public ResponseEntity<HttpStatus> deleteFamiila(@PathVariable("id") long id) {
		if (detailsRepository.existsById(id)) {
			detailsRepository.deleteById(id);
		}

		familiaRepository.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/familia")
	public ResponseEntity<HttpStatus> deleteAllFamilia() {
		familiaRepository.deleteAll();

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
