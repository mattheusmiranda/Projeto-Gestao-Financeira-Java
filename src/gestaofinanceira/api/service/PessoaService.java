package gestaofinanceira.api.service;

import java.time.LocalDate;

import java.util.List;

import gestaofinanceira.api.domain.Pessoa;

import java.time.LocalDate;
import java.util.List;

public interface PessoaService {

	void salvar(Pessoa pessoa);

	void cadastrar(String nome, String cpf, LocalDate dataNascimento);

	Pessoa buscarPorCpf(String cpf);

	List<Pessoa> buscarPorNome(String nome);

	boolean excluir(String cpf);

	void excluir(Pessoa pessoa);

	boolean cpfJaCadastrado(String cpf);

}
