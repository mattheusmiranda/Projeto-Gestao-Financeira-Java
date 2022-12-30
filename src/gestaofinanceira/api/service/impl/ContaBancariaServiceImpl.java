package gestaofinanceira.api.service.impl;

import java.math.BigDecimal;
import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;
import gestaofinanceira.api.repository.ContaBancariaRepository;
import gestaofinanceira.api.service.ContaBancariaService;

public class ContaBancariaServiceImpl implements ContaBancariaService {

	@Override
	public void criarConta(int numero, BigDecimal saldo, Pessoa dono) {
		ContaBancaria conta = new ContaBancaria();
		conta.setNumero(numero);
		conta.setSaldo(saldo);
		conta.setDono(dono);
		salvar(conta);
	}

	@Override
	public void salvar(ContaBancaria contaBancaria) {
		ContaBancariaRepository.salvar(contaBancaria);
	}

	@Override
	public boolean verificarDono(Pessoa pessoa, ContaBancaria conta) {
		return ContaBancariaRepository.verificarDono(pessoa, conta);
	}

	@Override
	public void transferir(BigDecimal transferir, int contaBancariaParaTransferir, int contaBancariaParaReceber) {
		ContaBancariaRepository.transferir(transferir, contaBancariaParaTransferir, contaBancariaParaReceber);
		
	}

	@Override
	public void buscarPorNumeroDaConta(int numeroConta) {
		ContaBancariaRepository.buscarPorNumeroDaConta(numeroConta);
	}

	@Override
	public void buscarPorNomeDoDono(String nome) {
		ContaBancariaRepository.buscarPorNomeDoDono(nome);
	}

	@Override
	public boolean contaJaExiste(ContaBancaria contaBancaria) {
		return ContaBancariaRepository.contaJaExiste(contaBancaria);
	}

}
