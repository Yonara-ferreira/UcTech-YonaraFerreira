package com.nara.api.Uctech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nara.api.Uctech.model.EmpresaDB;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaDB, Long>{
	
	Optional<EmpresaDB> findById(Long id);
	
	

}
