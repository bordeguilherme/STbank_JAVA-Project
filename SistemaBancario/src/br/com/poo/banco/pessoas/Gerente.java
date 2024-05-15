package br.com.poo.banco.pessoas;

import java.util.Date;

public class Gerente extends Funcionario {

    String agencia;

    public Gerente() {
        super();

    }

    public Gerente(String cargo, String nome, String cpf, String email, String senha, Double salario,String agencia) {
        super(cargo, nome, cpf, email, senha, salario);
        this.agencia = agencia;
    }
    
	// método confere agencia
	public Boolean confereAgc(String cpf, String agencia) {

		if (this.getCpf().equals(cpf) && this.agencia.equals(agencia)) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Você não pertence a esta agência!");
			return false;
		}
	}

}

//gets sets
