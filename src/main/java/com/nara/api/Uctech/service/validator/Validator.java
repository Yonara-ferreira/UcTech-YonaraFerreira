package com.nara.api.Uctech.service.validator;

import com.nara.api.Uctech.model.Empresa;

public class Validator {
	
	public static void verify(Empresa empresa) {
		if (empresa.getNome_fantasia().isEmpty()) {
			throw new RuntimeException("Nome fantasia não pode ser nulo.");
		}
		
		if (empresa.getRazao_social().isEmpty()) {
			throw new RuntimeException("Razão social não pode ser nulo.");
		}
	}

}
