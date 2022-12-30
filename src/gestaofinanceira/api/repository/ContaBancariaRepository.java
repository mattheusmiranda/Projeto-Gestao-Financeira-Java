package gestaofinanceira.api.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;

public class ContaBancariaRepository {

	private static List<ContaBancaria> INFORMACOES_DA_CONTA = new ArrayList<>();

	static {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("maske");
		pessoa.setCpf("123");
		pessoa.setDataNascimento(LocalDate.now());

		ContaBancaria contaBancaria = new ContaBancaria();
		contaBancaria.setDono(pessoa);
		contaBancaria.setNumero(1);
		contaBancaria.setSaldo(new BigDecimal(5000));
		INFORMACOES_DA_CONTA.add(contaBancaria);
	}

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
		if (conta.getDono().equals(pessoa)) {
			return true;
		}
		return false;
	}

	public static ContaBancaria transferir(BigDecimal transferir, int contaBancariaParaTransferir,
			int contaBancariaParaReceber) {
		for (ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {
			if (contaBancaria.getNumero() == contaBancariaParaTransferir) {
				contaBancaria.setSaldo(contaBancaria.getSaldo().subtract(transferir));
				ContaBancariaRepository.salvar(contaBancaria);
				System.out.println("Seu saldo agora é: " + contaBancaria.getSaldo());
				for (ContaBancaria contaBancaria2 : INFORMACOES_DA_CONTA) {
					if (contaBancaria2.getNumero() == contaBancariaParaReceber) {
						contaBancaria2.setSaldo(contaBancaria2.getSaldo().add(transferir));
						ContaBancariaRepository.salvar(contaBancaria);
					} else {
						break;
					}
				}
				break;
			} else {
				System.out.println("Conta nao encontrada");
			}
		}

		return null;
	}

	public static ContaBancaria buscarPorNumeroDaConta(int numeroConta) {
		for (ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {
			if (contaBancaria.getNumero() == numeroConta) {
				System.out.println(contaBancaria);
			}
		}
		System.out.println("Conta não encontrada");
		return null;
	}

	public static ContaBancaria buscarPorNomeDoDono(String nome) {
		for (ContaBancaria contaBancaria : INFORMACOES_DA_CONTA) {
			if (contaBancaria.getDono().getNome().equals(nome)) {
				System.out.println(contaBancaria);
			}
		}
		System.out.println("Conta não encontrada");
		return null;
	}

	public static boolean contaJaExiste(ContaBancaria contaBancaria) {
		for (ContaBancaria conta : ContaBancariaRepository.buscarTodos()) {
			if (contaBancaria.equals(conta)) {
				return true;
			}
			System.out.println("Conta não encontrada");
		}
		return false;
	}

}
