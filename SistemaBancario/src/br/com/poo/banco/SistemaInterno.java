package br.com.poo.banco;

import java.io.IOException;
import java.text.DecimalFormat;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.views.JLogin;

public class SistemaInterno {

	public static void main(String[] args) throws IOException {
		
		// lendo o banco.txt
		LeituraEscrita.leitor("banco");
		
		// chamada da tela inicial
		JLogin jLogin = new JLogin();
		jLogin.setLocationRelativeTo(jLogin);
		jLogin.setVisible(true);
		
		DecimalFormat df = new DecimalFormat("##,###.00");
		
		Conta con = new ContaCorrente();
		LeituraEscrita.comprovanteSaque(con, 50.00);
		
	}

}