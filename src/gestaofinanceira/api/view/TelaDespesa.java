package gestaofinanceira.api.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import gestaofinanceira.api.domain.Despesa;
import gestaofinanceira.api.repository.DespesaRepository;
import gestaofinanceira.api.service.DespesaService;
import gestaofinanceira.api.service.impl.DespesaServiceImpl;

public class TelaDespesa {


	Scanner scanner = new Scanner(System.in);
	
	 DespesaService = new DespesaService();
	
	public void imprimirMenu() {
		int opcaoSelecionada = 0;
		while (opcaoSelecionada >= 0 && opcaoSelecionada <= 3) {
			System.out.println("------- MENU DE DESPESAS --------------");
			System.out.println("- 1) Cadastrar nova despesa           -");
			System.out.println("- 2) Mostrar uma despesa              -");
			System.out.println("- 3) Pagar um despesa                 -");
			System.out.println("- 4) Mostrar todas as despesas        -");
			System.out.println("- 5) Excluir                          -");	
			System.out.println("- 0) Voltar menu anterior    		  -");
			System.out.println("---------------------------------------");
			
			System.out.println("Escolha uma opção: ");
			opcaoSelecionada = Integer.parseInt(scanner.nextLine());
			
			if (opcaoSelecionada == 1) {
				cadastrar();
				
			} else if (opcaoSelecionada == 2) {
				buscarUmaDespesa();
			} else if (opcaoSelecionada == 3) {
				pagarDespesa();
			}else if( opcaoSelecionada == 4) {
				buscarTodas();
			}else if( opcaoSelecionada == 5) {
				excluir();
			}
			else if (opcaoSelecionada == 0) {
			TelaPessoa.imprimirMenu();
				opcaoSelecionada = -1;
			} else {
				System.out.println("ATENÇÃO!!! Opção inválida, digite uma das opções abaixo");
				opcaoSelecionada = 0;
			}
		}
	}
	
	
	public void cadastrar() {
		
		Despesa novaDespesa = new Despesa();
		
		System.out.println("Informe o nome da despesa para cadastro: ");
		String nomeDigitado = scanner.nextLine();
		novaDespesa.setDescricao(nomeDigitado);// TODO arrumar o tipo do atributo 
		

		System.out.println("Informe o valor da despesa: ");
		BigDecimal valorDigitado = scanner.nextBigDecimal();
		novaDespesa.setValor(valorDigitado);
		
		System.out.println("Informe a data de vencimento da despesa: ");
		String dataDigitada = scanner.nextLine();
		LocalDate dataLocalDate = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		novaDespesa.setDataVencimento(dataLocalDate);
	
		DespesaRepository.salvar(novaDespesa);
	}
	
	public void buscarUmaDespesa() {
		
		System.out.println("Informe o nome da despesa: ");
		String nomeDigitado = scanner.nextLine();
		
		System.out.println("Informe a data de vencimento da despesa: ");
		String dataDigitada = scanner.nextLine();
		LocalDate dataLocalDate = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		DespesaRepository.buscarUmaDespesas(null, dataLocalDate); // TODO arrumar o tipo 
		
	}
	
	public void pagarDespesa() {
	//	TipoDespesa descricao, BigDecimal valor, ContaBancaria conta
		
		System.out.println("Informe o nome da despesa para ser paga: ");
		String nomeDespesa = scanner.nextLine();
		
		System.out.println("Informe o valor da despesa: ");
		BigDecimal valorDigitado = scanner.nextBigDecimal();
		
		System.out.println("Informe o numero da sua conta para realizar a debitação: ");
		int numeroDaContaParaTransferencia = scanner.nextInt(); // TODO mudar em despesaService o tipo da conta 
		
		DespesaRepository.pagarUmaDespesas(null, valorDigitado, numeroDaContaParaTransferencia);
		
	}
	
	public void buscarTodas() {
		
		System.out.println("Informe o nome da despesa: ");
		String nomeDigitado = scanner.nextLine();
		
		System.out.println("Informe a data de vencimento da despesa: ");
		String dataDigitada = scanner.nextLine();
		LocalDate dataLocalDate = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		DespesaRepository.buscarUmaDespesas(nomeDigitado, dataLocalDate); // TODO alterar nao passar parametros apenas printar todas 

	}
	
	public void excluir() {
		
		System.out.println("Informe o nome da despesa para excluir: ");
		String despesaDigitada = scanner.nextLine();
		DespesaRepository.excluir(null); // TODO arrumar o tipo 
	
	}
	
}
