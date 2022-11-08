package com.fsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.execption.ResourceNotFoundException;
import com.fsc.model.Familia;
import com.fsc.model.FamiliaDetails;
import com.fsc.repository.FamiliaDetailsRepository;
import com.fsc.repository.FamiliaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FamiliaDetailsController {

	@Autowired
	FamiliaDetailsRepository familiaDetailsRepository;
	
	@Autowired
	FamiliaRepository familiaRepository;
	
	@GetMapping({"/details/{id}", "familia/{id}/details"})
	public ResponseEntity<FamiliaDetails> getDetailsById(@PathVariable(value = "id")Long id){
		FamiliaDetails details = familiaDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não à registros com esse o numero do id: " + id));
	return new ResponseEntity<>(details, HttpStatus.OK);
	}
	
	@PostMapping("/familia/{familia_Id}/details")
	  public ResponseEntity<FamiliaDetails> createDetails(@PathVariable(value = "familia_Id") Long familia_Id,
	      FamiliaDetails detailsRequest) {
	    Familia familia = familiaRepository.findById(familia_Id)
	        .orElseThrow(() -> new ResourceNotFoundException("Não a registro com esse Id: = " + familia_Id));

	    detailsRequest.setCarro(detailsRequest.getCarro());
	    detailsRequest.setProfissao(detailsRequest.getProfissao());
	    detailsRequest.setFamilia(familia);
	    FamiliaDetails details = familiaDetailsRepository.save(detailsRequest);

	    return new ResponseEntity<>(details, HttpStatus.CREATED);
	  }

	  @PutMapping({"/details/{id}", "/familia/{id}/details"})
	  public ResponseEntity<FamiliaDetails> updateDetails(@PathVariable("id") long id,
	       FamiliaDetails detailsRequest) {
	    FamiliaDetails details = familiaDetailsRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não existe"));

	    details.setCarro(detailsRequest.getCarro());
	    details.setProfissao(detailsRequest.getProfissao());

	    return new ResponseEntity<>(familiaDetailsRepository.save(details), HttpStatus.OK);
	  }
	  

	  @DeleteMapping("/details/{id}")
	  public ResponseEntity<HttpStatus> deleteDetails(@PathVariable("id") long id) {
	    familiaDetailsRepository.deleteById(id);

	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  

	  @DeleteMapping("/familias/{familia_Id}/details")
	  public ResponseEntity<FamiliaDetails> deleteDetailsOfFamilia(@PathVariable(value = "familia_Id") Long familia_Id) {
	    if (!familiaRepository.existsById(familia_Id)) {
	      throw new ResourceNotFoundException("Não exite esse id = " + familia_Id);
	    }

	    familiaDetailsRepository.deleteByFamiliaId(familia_Id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	
	
	
	
	
}
