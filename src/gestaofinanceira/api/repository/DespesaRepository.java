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

		INFORMACOES_DE_DESPESA.add(despesas);

	}

	public static List<Despesa> buscarTodasAsDespesas() {
		return INFORMACOES_DE_DESPESA;

	}

	public static void buscarUmaDespesa(TipoDespesa descricao, LocalDate dataVencimento) {
		for (Despesa tipoDespesa2 : INFORMACOES_DE_DESPESA) {
			if (tipoDespesa2.getDescricao().equals(descricao)) {
				if (tipoDespesa2.getDataVencimento().equals(dataVencimento)) {
					System.out.println(tipoDespesa2);
					return ;
				}
			}
		}
		System.out.println("nao");
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
			DespesaRepository.pagarUmaDespesas(despesa.getDescricao(), despesa.getValor(), 0); // TODO ARRUMAR
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void pagarUmaDespesas(TipoDespesa descricao, BigDecimal valor, int conta) {
		
		for (ContaBancaria contas : ContaBancariaRepository.buscarTodos()) {
			
			if (contas.getNumero() == conta) {
				contas.setSaldo(contas.getSaldo().subtract(valor));
				System.out.println("Pagamento realizado com sucesso");
				break;
			}else {
				System.out.println("Numero da conta inexistente");
			}
			for (Despesa despesa : INFORMACOES_DE_DESPESA) {
				if (despesa.getDescricao().equals(descricao)) {
					despesa.setIndicadorContaPaga(true); 
					salvar(despesa);
				}else {
					System.out.println("Conta inexistente");
				}
				return;
				
			}
			
			System.out.print("Numero da conta inexistente");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
