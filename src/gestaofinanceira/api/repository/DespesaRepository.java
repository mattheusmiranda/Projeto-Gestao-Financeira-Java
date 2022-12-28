package gestaofinanceira.api.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Despesa;
import gestaofinanceira.api.domain.TipoDespesa;
import gestaofinanceira.api.service.impl.ContaBancariaServiceImpl;

public class DespesaRepository {

	private static List<Despesa> INFORMACOES_DE_DESPESA = new ArrayList<>();

	public static void novaDespesa(TipoDespesa descricao, BigDecimal valor, LocalDate dataVencimento) { // faz sentido
																										// implementar a
																										// opcao de
																										// conta paga
		for (Despesa despesa : INFORMACOES_DE_DESPESA) {
			if (despesa.getDataVencimento().equals(dataVencimento)) { // verificar aonde esse metodo deve ser passado
				return;
			}
		}
		Despesa despesa = new Despesa();
		despesa.setDescricao(descricao);
		despesa.setValor(valor);
		despesa.setDataVencimento(dataVencimento);
		salvar(despesa);
	}

	public static void salvar(Despesa despesas) {
		for (Despesa despesa : INFORMACOES_DE_DESPESA) {
			if (despesa.equals(despesas)) {
				despesa = despesas;
				return;
			}
		}
		INFORMACOES_DE_DESPESA.add(despesas);

	}

	public static List<Despesa> buscarTodasAsDespesas(Despesa despesa) {
		return INFORMACOES_DE_DESPESA;

	}

	public static Despesa buscarUmaDespesas(Despesa tipoDespesa, LocalDate dataVencimento) {
		for (Despesa tipoDespesa2 : INFORMACOES_DE_DESPESA) {
			if (tipoDespesa2.equals(tipoDespesa) && tipoDespesa2.getDataVencimento().equals(dataVencimento)) { // verificar
																												// se
																												// entendi
																												// certo
				return tipoDespesa2;
			}
		}
		return null;
	}

	public static Despesa excluir(Despesa despesa) {
		if (despesa.isIndicadorContaPaga() == true) {
			for (Despesa tipoDespesa2 : INFORMACOES_DE_DESPESA) {
				if (tipoDespesa2.equals(despesa)) {
					INFORMACOES_DE_DESPESA.remove(despesa);
					break; // break ou return?
				}
			}
			return null;
		}
		DespesaRepository.pagarUmaDespesas(despesa, 0);
		return null; // o return esta correto ?
	}

	public static void pagarUmaDespesas(Despesa despesa, int numero) {
		// ContaBancariaRepository conta = new ContaBancariaRepository();
		ContaBancariaServiceImpl contas = new ContaBancariaServiceImpl();

		if (DespesaRepository.buscarUmaDespesas(despesa, null) != null) { // verifica se a despesa existe
			return;
		} else {
			for (ContaBancaria conta : ContaBancariaRepository.buscarTodos()) {
				if (conta.getNumero() == numero) { // verifica se o numero da conta existe
					contas.transferir(despesa.getValor(), conta, null); // verificar
					INFORMACOES_DE_DESPESA.remove(despesa);
				}
			}

		}

	}

}
