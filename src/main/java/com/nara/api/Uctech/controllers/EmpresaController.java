package com.nara.api.Uctech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nara.api.Uctech.model.EmpresaDB;
import com.nara.api.Uctech.repository.EmpresaRepository;
import com.nara.api.Uctech.service.EmpresaService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService service;
	
	
	@GetMapping(value = "listarEmpresa")
	@ResponseBody
	public ResponseEntity<List<EmpresaDB>> listarEmpresas(){
		return ResponseEntity.ok().body(empresaRepository.findAll());
	}
	
	@GetMapping(value = "buscarUserId/{id}")
	@ResponseBody
	public ResponseEntity<EmpresaDB> buscarId(@PathVariable(name = "id") Long Id){
		return new ResponseEntity<EmpresaDB>(this.service.findById(Id), HttpStatus.OK);	
	}
	
	@PostMapping(value = "salvar/{cnpj}")
	@ResponseBody
	public ResponseEntity<?> salvar(@PathVariable(name = "cnpj") String cnpj, HttpServletResponse response){
		return new ResponseEntity<EmpresaDB>(this.service.save(cnpj), HttpStatus.CREATED);
	}
	
}
