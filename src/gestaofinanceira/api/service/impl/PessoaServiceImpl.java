package gestaofinanceira.api.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestaofinanceira.api.domain.Pessoa;
import gestaofinanceira.api.repository.PessoaRepository;
import gestaofinanceira.api.service.PessoaService;

public class PessoaServiceImpl implements PessoaService {

	@Override
	public void cadastrar(String nome, String cpf, LocalDate dataNascimento) {
		
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

	@Override
	public Pessoa buscarPorCpf(String cpf) {
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
	public void atualizar(Pessoa pessoaParaAtualizar) {		
		if (pessoaParaAtualizar == null || !cpfJaCadastrado(pessoaParaAtualizar.getCpf())) {
			System.out.println("Favor informar uma pessoa existente.");
			return;
		}
		PessoaRepository.atualizar(pessoaParaAtualizar);
	}

	@Override
	public boolean excluir(String cpf) {
		return false;
	}

	@Override
	public boolean excluir(Pessoa pessoa) {
		return false;
	}

	@Override
	public boolean cpfJaCadastrado(String cpf) {

		return PessoaRepository
	}
	
}
