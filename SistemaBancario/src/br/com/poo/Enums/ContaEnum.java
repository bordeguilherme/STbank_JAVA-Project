package br.com.poo.Enums;

public enum ContaEnum {
	CORRENTE ("Corrente", 1), //1 é o identificador
	POUPANÇA ("Poupança", 2); //2 é o identificador
	
	private String tipoConta;
	private int id;
	
	ContaEnum(String tipoConta, int id){
		this.tipoConta = tipoConta;
		this.id = id;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public int getId() {
		return id;
	}
}
