package gestaofinanceira.api.service;

import java.math.BigDecimal;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;

public interface ContaBancariaService {
	
	// senha, dono, transferir, consultar saldo, buscar por numero da conta, buscar por nome do dono 
	
	boolean senha(ContaBancaria senha);
	
	boolean dono(ContaBancaria nomeDono);
	
	void transferir(BigDecimal transferir);
	
	void consultarSaldo(BigDecimal consultarSaldo);
	
	void buscarPorNumeroDaConta(ContaBancaria buscarPorNumeroDaConta);
	
	void buscarPorNomeDoDono(ContaBancaria buscarPorNomeDoDono);


}
