package gestaofinanceira.api.service;

import java.time.LocalDate;
import java.util.List;

import gestaofinanceira.api.domain.Pessoa;

public interface PessoaService {
	
	void cadastrar(String nome, String cpf, LocalDate dataNascimento);
	
	Pessoa buscarPorCpf(String cpf);
	
	List<Pessoa> buscarPorNome(String nome);
	
	void atualizar(Pessoa pessoa);
	
	//boolean excluir(String cpf);
	
	void excluir(Pessoa pessoa);
	
	boolean cpfJaCadastrado(String cpf);

}
