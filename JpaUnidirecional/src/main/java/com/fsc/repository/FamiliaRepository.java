package com.fsc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsc.model.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

	// List<Familia> findbyIdade(Integer idade);

	public List<Familia> findByNome(String nome);
}
