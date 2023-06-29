package com.nara.api.Uctech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nara.api.Uctech.model.Empresa;
import com.nara.api.Uctech.model.EmpresaDB;
import com.nara.api.Uctech.repository.EmpresaRepository;
import com.nara.api.Uctech.service.validator.Validator;

@Service
public class EmpresaService extends RuntimeException {
	
	 
	private static final long serialVersionUID = 1L;

	@Autowired
	    private RestTemplate template = new RestTemplate();
	
	@Autowired
	public EmpresaRepository empresaRepository;
	
	public EmpresaDB save (String cnpj) {
		
		Empresa empresa = template.getForObject("https://brasilapi.com.br/api/cnpj/v1/" + cnpj, Empresa.class);
		
		/*
		 * Classe estática para verificar campos obrigatórios definidos no 
		 * banco de dados, usada no método Save.
		 */
		Validator.verify(empresa);
		
		if (empresaRepository.findByCnpj(empresa.getCnpj()) != null) {
			throw new RuntimeException("CNPJ já cadastrado. Não é possível cadastrar novamente.");
		}
		
		return empresaRepository.save(new EmpresaDB().from(empresa));
		
		/*
		 * Melhorei o código ao máximo, movendo-o para a classe Entidade 
		 * EmpresaDB para melhorar a legibilidade. Recebi dicas do meu irmão, 
		 * mas ainda estou aprendendo a fazer isso sem orientação.
		 */
		
		//return empresaRepository.save(new EmpresaDB(empresa.getNome_fantasia(), empresa.getNome_fantasia(), empresa.getCnpj(), empresa.getDdd_telefone_1(),empresa.getLogradouro(), empresa.getPorte()));
	}
	
	public EmpresaDB findById(Long id) {
		return empresaRepository.findById(id).orElse(null);
	}
	
	public EmpresaDB findByNomeFantasia(String NomeFantasia) {
		return empresaRepository.findByNomeFantasia(NomeFantasia).orElse(null);
	}
	
	
	public List<EmpresaDB> findAllCnpj(String cnpj){
		List<EmpresaDB> todasEmpresas = empresaRepository.findAll();
		List<EmpresaDB> empresasPorCnpj = new ArrayList<>();
		
		for(EmpresaDB empresa : todasEmpresas) {
			String cnpjEmpresa = empresa.getCnpj();
			if(cnpjEmpresa.contains(cnpj)) {
				empresasPorCnpj.add(empresa);
			}
		}
		 return empresasPorCnpj;
	}

}
