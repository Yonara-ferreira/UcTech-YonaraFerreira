package com.nara.api.Uctech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nara.api.Uctech.model.Empresa;
import com.nara.api.Uctech.model.EmpresaDB;
import com.nara.api.Uctech.repository.EmpresaRepository;

@Service
public class EmpresaService  {
	
	 @Autowired
	    private RestTemplate template = new RestTemplate();
	
	@Autowired
	public EmpresaRepository empresaRepository;
	
	public EmpresaDB save (String cnpj) {
		
		Empresa empresa = template.getForObject("https://brasilapi.com.br/api/cnpj/v1/" + cnpj, Empresa.class);
//		if() {
//			
//		}
		
		return empresaRepository.save(new EmpresaDB(empresa.getNome_fantasia(), empresa.getNome_fantasia(), empresa.getCnpj(), empresa.getDdd_telefone_1(),empresa.getLogradouro(), empresa.getPorte()));
	}
	
	public EmpresaDB findById(Long id) {
		return empresaRepository.findById(id).orElse(null);
	}

}
