package gestaofinanceira.api.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
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
	public void buscarTodasAsDespesas(Despesa despesa) {
		DespesaRepository.buscarTodasAsDespesas(despesa);

	}

	@Override
	public void buscarUmaDespesas(Despesa tipoDespesa, LocalDate dataVencimento) {
		DespesaRepository.buscarUmaDespesas(tipoDespesa, dataVencimento);

	}

	@Override
	public void excluir(Despesa despesa) {
		DespesaRepository.excluir(despesa);

	}

	@Override
	public void pagarUmaDespesas(Despesa despesa, int numero) {
		DespesaRepository.pagarUmaDespesas(despesa, numero);

	}

}
