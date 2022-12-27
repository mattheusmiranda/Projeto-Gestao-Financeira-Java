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
		return PessoaRepository.buscarPorCpf(cpf);
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
	public void excluir(Pessoa pessoaParaExcluir) {
		PessoaRepository.excluir(pessoaParaExcluir);
	}

	@Override
	public boolean excluir(String cpf) {
		Pessoa pessoa = buscarPorCpf(cpf);
		excluir(pessoa);
		return false;
	}
	
	@Override
	public boolean cpfJaCadastrado(String cpf) {
		return PessoaRepository.cpfJaCadastrado(cpf);
	}

}
