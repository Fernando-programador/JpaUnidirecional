package com.fsc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsc.model.FamiliaDetails;

@Repository
public interface FamiliaDetailsRepository extends JpaRepository<FamiliaDetails, Long>{

	@Transactional
	void deleteById(Long id);
	
	@Transactional
	void deleteByFamiliaId(Long familia_id);
	
}
