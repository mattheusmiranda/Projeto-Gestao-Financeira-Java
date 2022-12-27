package gestaofinanceira.api.repository;

import java.util.ArrayList;
import java.util.List;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;

public class ContaBancariaRepository {

	private static List<ContaBancaria> INFORMACOES_DA_CONTA = new ArrayList<>();
	
	public static void salvar(ContaBancaria contaBancaria) {
		for (ContaBancaria conta : INFORMACOES_DA_CONTA) {
			if (conta.equals(contaBancaria)) {
				conta = contaBancaria;
				return;
			}
		}
		INFORMACOES_DA_CONTA.add(contaBancaria);
	}
	
	public static List<ContaBancaria> buscarTodos() {
		return INFORMACOES_DA_CONTA;
	}
	
	public static boolean verificarDono(Pessoa pessoa, ContaBancaria conta) {
		if(conta.getDono().equals(pessoa)) {
			return true;
		}
		return false;
	}
	
	public static ContaBancaria buscarPorNumeroDaConta(int numeroConta) {
		for(ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {
			if(contaBancaria.getNumero() == numeroConta) {
				return contaBancaria;
			}
		}
		return null;
	}
	
	public static ContaBancaria buscarPorNomeDoDono(String nome) {
		for(ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {  
			if(contaBancaria.getDono().getNome().equals(nome)) {
				return contaBancaria;
			}
		}
		return null;
	}
	
	public static boolean contaJaExiste(ContaBancaria contaBancaria) {
		for (ContaBancaria conta : ContaBancariaRepository.buscarTodos()) {
			if (contaBancaria.equals(conta)) {
				return true;
			}
		}
		return false;
	}

}
