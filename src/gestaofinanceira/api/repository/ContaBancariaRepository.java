package gestaofinanceira.api.repository;

import java.math.BigDecimal;
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

	public static  ContaBancaria transferir (BigDecimal transferir, int contaBancariaParaTransferir, int contaBancariaParaReceber) {
		for(ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {
			if(contaBancaria.getNumero() == contaBancariaParaTransferir) {
				contaBancaria.setSaldo(contaBancaria.getSaldo().subtract(transferir));
				ContaBancariaRepository.salvar(contaBancaria);
				System.out.println("Seu saldo agora é: " + contaBancaria.getSaldo());
				break;
			}else {
				System.out.println("erro");
			}
		}for(ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {
			if(contaBancaria.getNumero() == contaBancariaParaReceber) {
				contaBancaria.setSaldo(contaBancaria.getSaldo().add(transferir));
				ContaBancariaRepository.salvar(contaBancaria);
			}
		}
		return null;
	}
	
	public static ContaBancaria buscarPorNumeroDaConta(int numeroConta) {
		for(ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {
			if(contaBancaria.getNumero() == numeroConta) {
				System.out.println(contaBancaria);
			}
		}
		return null;
	}
	
	public static ContaBancaria buscarPorNomeDoDono(String nome) {
		for(ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {  
			if(contaBancaria.getDono().getNome().equals(nome)) {
				System.out.println(contaBancaria); 
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
