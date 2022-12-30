package gestaofinanceira.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Despesa;
import gestaofinanceira.api.domain.TipoDespesa;

public interface DespesaService {

	void novaDespesa(TipoDespesa descricao, BigDecimal valor, LocalDate dataVencimento);
	
	void salvar(Despesa despesas);
	
	void buscarUmaDespesas(TipoDespesa descricao, LocalDate dataVencimento); // verificar sobre os tipos TipoDespesa

	void pagarUmaDespesas(TipoDespesa descricao, BigDecimal valor, int conta);

	void excluir(TipoDespesa descricao);

	void buscarTodasAsDespesas(TipoDespesa descricao, LocalDate dataVencimento);	
}