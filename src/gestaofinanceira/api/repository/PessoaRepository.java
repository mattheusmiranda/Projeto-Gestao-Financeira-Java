package gestaofinanceira.api.repository;

import java.util.ArrayList;
import java.util.List;

import gestaofinanceira.api.domain.Pessoa;

public class PessoaRepository {

	private static List<Pessoa> LISTA_DE_PESSOAS = new ArrayList<>();

	public static void salvar(Pessoa pessoa) {
		LISTA_DE_PESSOAS.add(pessoa);
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

	public static boolean CpfJaCadastrado(String cpf) {
		boolean existe = true;
		boolean naoExiste = false;
		for (Pessoa cpfBancoDeDados : LISTA_DE_PESSOAS) {
			if (cpfBancoDeDados.getCpf().contains(cpf)) {
				System.out.println("CPF ja cadastrado");
				return existe;
			}
			break;
		}
		return naoExiste;
	}

	public static void excluir(Pessoa pessoaParaExcluir) {
		for (Pessoa excluirUsuario : LISTA_DE_PESSOAS) {
			if (pessoaParaExcluir.equals(excluirUsuario)) {
				LISTA_DE_PESSOAS.remove(pessoaParaExcluir);
			}
		}
	}

}
