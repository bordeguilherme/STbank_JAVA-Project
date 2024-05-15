package br.com.poo.banco.pessoas;

import java.util.Date;

public class Diretor extends Funcionario {

    //construtor
    public Diretor() {
        super();
    }

    public Diretor(String cargo, String nome, String cpf, String email, Double salario, String senha) {
        super(cargo, nome, cpf, email, senha, salario);
    }

//    public String getCargo() {
//        return cargo;
//    }
}
