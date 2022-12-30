package gestaofinanceira.api.service;

import java.math.BigDecimal;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;

public interface ContaBancariaService {

	void criarConta(int numero, BigDecimal saldo, Pessoa dono);

	void salvar(ContaBancaria contaBancaria);

	boolean contaJaExiste(ContaBancaria contaBancaria);

	boolean verificarDono(Pessoa pessoa, ContaBancaria conta);

	void transferir(BigDecimal transferir, int contaBancariaParaTransferir, int contaBancariaParaReceber);

	void buscarPorNumeroDaConta(int numeroConta);

	void buscarPorNomeDoDono(String nome);

}
