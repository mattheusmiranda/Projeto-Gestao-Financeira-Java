package gestaofinanceira.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import gestaofinanceira.api.domain.Despesa;
import gestaofinanceira.api.domain.TipoDespesa;

public interface DespesaService {

	void novaDespesa(TipoDespesa descricao, BigDecimal valor, LocalDate dataVencimento);
	
	void salvar(Despesa despesas);
	
	void buscarTodasAsDespesas(Despesa despesa);
	
	void buscarUmaDespesas(Despesa tipoDespesa, LocalDate dataVencimento); // verificar sobre os tipos TipoDespesa
	
	void excluir(Despesa despesa);
	
	void pagarUmaDespesas(Despesa despesa, int numero);
}
