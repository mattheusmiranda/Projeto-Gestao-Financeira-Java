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

	static {
		Despesa despesa = new Despesa();
		despesa.setDescricao(TipoDespesa.LUZ);
		despesa.setDataVencimento(LocalDate.now().plusDays(2));
		despesa.setValor(new BigDecimal(200));
		despesa.setIndicadorContaPaga(false);
		INFORMACOES_DE_DESPESA.add(despesa);
	}

	public static void novaDespesa(TipoDespesa descricao, BigDecimal valor, LocalDate dataVencimento) {
		for (Despesa despesa : INFORMACOES_DE_DESPESA) {
			if (despesa.getDataVencimento().equals(dataVencimento)) {
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

		INFORMACOES_DE_DESPESA.add(despesas);
		System.out.println("Despesa salva com sucesso");

	}

	public static List<Despesa> buscarTodasAsDespesas() {
		return INFORMACOES_DE_DESPESA;

	}

	public static void buscarUmaDespesa(TipoDespesa descricao, LocalDate dataVencimento) {
		for (Despesa tipoDespesa2 : INFORMACOES_DE_DESPESA) {
			if (tipoDespesa2.getDescricao().equals(descricao)) {
				if (tipoDespesa2.getDataVencimento().equals(dataVencimento)) {
					System.out.println(tipoDespesa2);
					return;
				}
			}
		}
		System.out.println("Despesa não cadastrada");
	}

	public static void excluir(TipoDespesa descricao) {
		for (Despesa despesa : INFORMACOES_DE_DESPESA) {
			if (despesa.isIndicadorContaPaga() == true) {
				INFORMACOES_DE_DESPESA.remove(despesa);
				for (Despesa tipoDespesa2 : INFORMACOES_DE_DESPESA) {
					if (tipoDespesa2.getDescricao().equals(descricao)) {
						INFORMACOES_DE_DESPESA.remove(tipoDespesa2);
						System.out.println("Despesa excluida");
						return;
					}
				}
			}
			System.out.println("Conta não foi paga");
			System.out.println("Pagar conta " + despesa.getDescricao());
			DespesaRepository.pagarUmaDespesas(despesa.getDescricao(), despesa.getDataVencimento(), 0);
		}
	}

	public static void pagarUmaDespesas(TipoDespesa descricao, LocalDate dataVencimento, int conta) {
		for (ContaBancaria contas : ContaBancariaRepository.buscarTodos()) {
			if (contas.getNumero() == conta) {
				for (Despesa despesa : INFORMACOES_DE_DESPESA) { 
					if (despesa.getDescricao().equals(descricao)
							&& despesa.getDataVencimento().equals(dataVencimento)) {
						contas.setSaldo(contas.getSaldo().subtract(despesa.getValor()));
						despesa.setIndicadorContaPaga(true);
						salvar(despesa);
						System.out.println("Pagamento realizado com sucesso");
						return;
					}
				}
				System.out.println("Despesa não encontrada");
				break;
			}
		}
		System.out.println("Numero da conta inexistente");
	}

}
