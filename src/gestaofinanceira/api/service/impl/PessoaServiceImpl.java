package gestaofinanceira.api.service.impl;

import java.time.LocalDate;
import java.util.List;

import gestaofinanceira.api.domain.Pessoa;
import gestaofinanceira.api.repository.PessoaRepository;
import gestaofinanceira.api.service.PessoaService;

public class PessoaServiceImpl implements PessoaService {

	@Override
	public void salvar(Pessoa pessoa) {
		PessoaRepository.salvar(pessoa);
	}

	@Override
	public void cadastrar(String nome, String cpf, LocalDate dataNascimento) {
		PessoaRepository.cadastrar(nome, cpf, dataNascimento);
	}

	@Override
	public Pessoa buscarPorCpf(String cpf) {
		PessoaRepository.buscarPorCpf(cpf);
		return null;

	}

	@Override
	public List<Pessoa> buscarPorNome(String nome) {
		if (nome == null) {
			System.out.println("É necessário informar um nome para a pesquisa.");
			return null;
		}
		return PessoaRepository.buscarPorNome(nome);
	}

	@Override
	public boolean excluir(String cpf) {
		return false;

	}

	@Override
	public boolean cpfJaCadastrado(String cpf) {
		return PessoaRepository.cpfJaCadastrado(cpf);
	}

	@Override
	public void excluir(Pessoa pessoa) {
		PessoaRepository.excluir(pessoa);
		return;

	}

}
