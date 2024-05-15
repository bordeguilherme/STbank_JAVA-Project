package br.com.poo.Enums;

public enum PessoaEnum {
	CLIENTE ("Cliente", 1), 
	GERENTE ("Gerente", 2), 
	DIRETOR ("Diretor", 3), 
	PRESIDENTE ("Presidente", 4);
	
	private String tipoPessoa;
	private int id;
	
	private PessoaEnum(String tipoPessoa, int id) {
		this.tipoPessoa = tipoPessoa;
		this.id = id;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}
