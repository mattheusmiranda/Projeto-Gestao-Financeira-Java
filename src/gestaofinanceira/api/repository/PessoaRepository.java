package gestaofinanceira.api.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestaofinanceira.api.domain.Pessoa;

public class PessoaRepository {

	private static List<Pessoa> LISTA_DE_PESSOAS = new ArrayList<>();

	public static void salvar(Pessoa pessoa) {
		for (Pessoa pessoaBancoDeDados : LISTA_DE_PESSOAS) {
			if (pessoa.equals(pessoaBancoDeDados)) {
				pessoaBancoDeDados = pessoa;
				return;
			}
		}
		LISTA_DE_PESSOAS.add(pessoa);
	}

	public static List<Pessoa> buscarTodos() {
		return LISTA_DE_PESSOAS;
	}

	public static void cadastrar(String nome, String cpf, LocalDate dataNascimento) {

		if (cpfJaCadastrado(cpf)) {
			System.out.println("Esse CPF já existe no banco de dados!");
			return;
		}

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		pessoa.setDataNascimento(dataNascimento);
		PessoaRepository.salvar(pessoa);
	}

	public static Pessoa buscarPorCpf(String cpf) {
		for (Pessoa pessoa : LISTA_DE_PESSOAS) {
			if (pessoa.getCpf().equals(cpf)) {
				return pessoa;
			}
		}
		return null;
	}

	public static List<Pessoa> buscarPorNome(String nome) {
		List<Pessoa> pessoasEncontradas = new ArrayList<>();
		for (Pessoa pessoa : LISTA_DE_PESSOAS) {
			if (pessoa.getNome().startsWith(nome)) {
				pessoasEncontradas.add(pessoa);
			}
		}
		return pessoasEncontradas;
	}

	public static void excluir(Pessoa pessoaParaExcluir) {
		for (Pessoa pessoa : LISTA_DE_PESSOAS) {
			if (pessoaParaExcluir.equals(pessoa)) {
				LISTA_DE_PESSOAS.remove(pessoaParaExcluir);
			}
		}
	}

	public static void excluir(String cpf) {
		excluir(PessoaRepository.buscarPorCpf(cpf)); // implementei 
	}

	public static boolean cpfJaCadastrado(String cpf) {
		for (Pessoa pessoa : LISTA_DE_PESSOAS) {
			if (pessoa.getCpf().equals(cpf)) {
				System.out.println("CPF ja cadastrado");
				return true;
			}
		}
		return false;
	}

}
