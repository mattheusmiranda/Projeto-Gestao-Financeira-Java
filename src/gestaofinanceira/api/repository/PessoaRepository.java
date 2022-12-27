package gestaofinanceira.api.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestaofinanceira.api.domain.Pessoa;

public class PessoaRepository {

	private static List<Pessoa> LISTA_DE_PESSOAS = new ArrayList<>();

	public static void salvar(Pessoa pessoa) {
		LISTA_DE_PESSOAS.add(pessoa);
	}

	public static void cadastrar(String nome, String cpf, LocalDate dataNascimento) {

		if (CpfJaCadastrado(cpf)) {
			System.out.println("Esse CPF já existe no banco de dados!");
			return;
		}

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		pessoa.setDataNascimento(dataNascimento);
		PessoaRepository.salvar(pessoa);
	}

	public static void  buscarPorCpf(String cpf) {

		for (Pessoa buscarPorCpf : LISTA_DE_PESSOAS) {
			List<Pessoa> pessoasEncontradasPeloCpf = new ArrayList<>();
			if (buscarPorCpf.getCpf().equals(cpf)) {
				pessoasEncontradasPeloCpf.add(buscarPorCpf);
			}
		}
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

	public static void atualizar(Pessoa pessoaParaAtualizar) {
		for (Pessoa pessoaBancoDeDados : LISTA_DE_PESSOAS) {
			if (pessoaParaAtualizar.equals(pessoaBancoDeDados)) {
				pessoaBancoDeDados = pessoaParaAtualizar;
				break;
			}
		}
	}

	public static void excluir(Pessoa pessoaParaExcluir) {
		for (Pessoa excluirUsuario : LISTA_DE_PESSOAS) {
			if (pessoaParaExcluir.equals(excluirUsuario)) {
				LISTA_DE_PESSOAS.remove(pessoaParaExcluir);
			}
		}
	}

	public static boolean CpfJaCadastrado(String cpf) {
		for (Pessoa cpfBancoDeDados : LISTA_DE_PESSOAS) {
			if (cpfBancoDeDados.getCpf().contains(cpf)) {
				System.out.println("CPF ja cadastrado");
				return true;
			}
			break;
		}
		return false;
	}

}
