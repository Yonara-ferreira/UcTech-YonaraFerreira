package com.nara.api.Uctech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class EmpresaDB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	
	@Column(name = "razao_social")
	private String razaoSocial;
	

	private String cnpj;
	
	@Column(name = "telefone_empresa")
	private String telefone;
	
	private String endereco;
	
	@Column(name = "porte_da_empresa")
	private String porte;
	
	
	public EmpresaDB() {
		super();
	}

	public EmpresaDB(
			String nomeFantasia,
			String razaoSocial, 
			String cnpj,
			String telefone, 
			String endereco, 
			String porte) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.endereco = endereco;
		this.porte = porte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}
	
	
	public EmpresaDB from(Empresa empresa) {
		return new EmpresaDB(empresa.getNome_fantasia(), 
				empresa.getRazao_social(), 
				empresa.getCnpj(), 
				empresa.getDdd_telefone_1(), 
				empresa.getLogradouro(), 
				empresa.getPorte());
	}
	
	
	
	
	

}
