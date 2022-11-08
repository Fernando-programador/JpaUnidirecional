package com.fsc.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.fsc.model.Produto;
import com.fsc.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping("/produto")
	public Produto novoProduto(@Valid Produto produto) {
		Produto addProduto = produtoRepository
				.save(new Produto(produto.getNome(), produto.getPreco(), produto.getDesconto()));
		return addProduto;
	}

	@GetMapping("/produto/{id}")
	public Optional<Produto> obterPorId(@PathVariable Long id) {
		return produtoRepository.findById(id);
	}

	@GetMapping("/produto/pagina/{nPagina}/{qntPagina}")
	public Iterable<Produto> obterPorPagina(@PathVariable int nPagina, @PathVariable int qntPagina) {
		if (qntPagina >= 5)
			qntPagina = 5;
		Pageable page = PageRequest.of(nPagina, qntPagina);
		return produtoRepository.findAll(page);
	}

	@GetMapping("/nome/{nomeProduto}")
	public Iterable<Produto> obterPorNome(@PathVariable String nomeProduto) {
		return produtoRepository.findByNomeContainingIgnoreCase(nomeProduto);
		/*
		 * Outros tipos de consultas
		 * 
		 * findByNomeContaining
		 * findByNomeIsContaining
		 * findByNomeContains
		 * 
		 * findByNomeStartsWith
		 * findByNomeEndsWith
		 * 
		 * findByNomeNotContaining
		 * 
		 */
	}

	// @PutMapping("/produto/{id}")
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = ("/produto/{id}"))
	public Produto alterarProdutoId(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	@DeleteMapping("/produto/{id}")
	public void ecluirProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);

	}

}
