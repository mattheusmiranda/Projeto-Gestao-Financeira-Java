package gestaofinanceira.api.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Despesa;
import gestaofinanceira.api.domain.TipoDespesa;

public class DespesaRepository {

	private static List<Despesa> INFORMACOES_DE_DESPESA = new ArrayList<>();

	public static void novaDespesa(TipoDespesa descricao, BigDecimal valor, LocalDate dataVencimento) {
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

	public static Despesa buscarUmaDespesas(TipoDespesa descricao, LocalDate dataVencimento) {
		for (Despesa tipoDespesa2 : INFORMACOES_DE_DESPESA) {
			if (tipoDespesa2.getDescricao().equals(descricao)
					&& tipoDespesa2.getDataVencimento().equals(dataVencimento)) {
				return tipoDespesa2;
			}
		}
		return null;
	}

	public static void excluir(TipoDespesa descricao) {
		for (Despesa despesa : INFORMACOES_DE_DESPESA) {
			if (despesa.isIndicadorContaPaga() == true) {
				for (Despesa tipoDespesa2 : INFORMACOES_DE_DESPESA) {
					if (tipoDespesa2.getDescricao().equals(descricao)) {
						INFORMACOES_DE_DESPESA.remove(tipoDespesa2);
						return;
					}
				}
			}
			System.out.println("Conta não foi paga");
			System.out.println("Pagar conta " + despesa.getDescricao());
			DespesaRepository.pagarUmaDespesas(despesa.getDescricao(), despesa.getValor(), null);
		}
	}

	public static Object pagarUmaDespesas(TipoDespesa descricao, BigDecimal valor, ContaBancaria conta) {
		// altera o indicador de pago da despesa, e salva a despesa
		// e debita da conta o valor da despesa, e salva a conta
		// ContaBancariaRepository conta = new ContaBancariaRepository();
		// ContaBancariaServiceImpl contas = new ContaBancariaServiceImpl();
		for (ContaBancaria contas : ContaBancariaRepository.buscarTodos()) {
			if (contas.getNumero() == conta.getNumero()) {
				for (Despesa despesa : INFORMACOES_DE_DESPESA) {
					if (despesa.getDescricao().equals(descricao)) {
						conta.setSaldo(conta.getSaldo().subtract(valor)); // debita o valor da conta
						despesa.setIndicadorContaPaga(true); // altera a conta para paga 
						salvar(despesa);
					} System.out.println("Conta inexistente");
				}

			}
			System.out.print("Numero da conta inexistente");
		}
		return null;

	}

}
