package gestaofinanceira.api.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Despesa;
import gestaofinanceira.api.domain.TipoDespesa;
import gestaofinanceira.api.repository.DespesaRepository;
import gestaofinanceira.api.service.DespesaService;

public class DespesaServiceImpl implements DespesaService {

	@Override
	public void novaDespesa(TipoDespesa descricao, BigDecimal valor, LocalDate dataVencimento) {
		DespesaRepository.novaDespesa(descricao, valor, dataVencimento);

	}

	@Override
	public void salvar(Despesa despesas) {
		DespesaRepository.salvar(despesas);

	}

	@Override
	public void buscarTodasAsDespesas(TipoDespesa descricao, LocalDate dataVencimento) {
		DespesaRepository.buscarUmaDespesa(descricao, dataVencimento);

	}

	@Override
	public void excluir(TipoDespesa descricao) {

		DespesaRepository.excluir(descricao);
	}

	@Override
	public void pagarUmaDespesas(TipoDespesa descricao, LocalDate dataVencimento, int numeroConta) {
		DespesaRepository.pagarUmaDespesas(descricao, dataVencimento, numeroConta);

	}

	@Override
	public void buscarUmaDespesas(TipoDespesa descricao, LocalDate dataVencimento) {
		DespesaRepository.buscarUmaDespesa(descricao, dataVencimento);

	}
}
