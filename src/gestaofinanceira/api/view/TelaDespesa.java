package gestaofinanceira.api.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Despesa;
import gestaofinanceira.api.domain.Pessoa;
import gestaofinanceira.api.domain.TipoDespesa;
import gestaofinanceira.api.repository.ContaBancariaRepository;
import gestaofinanceira.api.repository.DespesaRepository;
import gestaofinanceira.api.service.ContaBancariaService;
import gestaofinanceira.api.service.impl.ContaBancariaServiceImpl;

public class TelaDespesa {

	Scanner scanner = new Scanner(System.in);
	
	 //DespesaRepository v = new DespesaService();
	
	public void imprimirMenu() {
		int opcaoSelecionada = 0;
		while (opcaoSelecionada >= 0 && opcaoSelecionada <= 15) {
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
			TelaPessoa telaPessoa = new TelaPessoa();
			telaPessoa.imprimirMenu();
				opcaoSelecionada = -1;
			} else {
				System.out.println("ATENÇÃO!!! Opção inválida, digite uma das opções abaixo");
				opcaoSelecionada = 0;
			}
		}
	}
	
	
	public void cadastrar() {
		
		Despesa novaDespesa = new Despesa();
		TipoDespesa respostaDespesa;

		System.out.println("Informe o nome da despesa para cadastro: ");
		String  nomeDigitado = scanner.nextLine();
		respostaDespesa = TipoDespesa.valueOf(nomeDigitado);
		novaDespesa.setDescricao(respostaDespesa); 

		System.out.println("Informe o valor da despesa: ");
		BigDecimal valorDigitado = new BigDecimal(scanner.nextLine());
		novaDespesa.setValor(valorDigitado);
		
		System.out.println("Informe a data de vencimento da despesa: ");
		String dataDigitada = scanner.nextLine();
		LocalDate dataLocalDate = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		novaDespesa.setDataVencimento(dataLocalDate);
		
		DespesaRepository.salvar(novaDespesa);
	}
	
	public void buscarUmaDespesa() {
		
		TipoDespesa respostaNome;
		System.out.println("Informe o nome da despesa: ");
		String nomeDigitado = scanner.nextLine();
		respostaNome = TipoDespesa.valueOf(nomeDigitado);
		
		System.out.println("Informe a data de vencimento da despesa: ");
		String dataDigitada = scanner.nextLine();
		LocalDate dataLocalDate = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		DespesaRepository.buscarUmaDespesa(respostaNome, dataLocalDate);
		
	}
	
	public void pagarDespesa() {

		TipoDespesa nomeDaDespesa;
		System.out.println("Informe o nome da despesa para ser paga: ");
		String nomeDespesa = scanner.nextLine();
		nomeDaDespesa = TipoDespesa.valueOf(nomeDespesa);
		
		System.out.println("Informe o valor da despesa: ");
		BigDecimal valorDigitado = new BigDecimal(scanner.nextLine());
		
		System.out.println("Informe o numero da sua conta para realizar a debitação: ");
		int numeroDaContaParaTransferencia = Integer.valueOf(scanner.nextInt());
		
		DespesaRepository.pagarUmaDespesas(nomeDaDespesa, valorDigitado, numeroDaContaParaTransferencia);
		
	}
	
	public void buscarTodas() {
	
		System.out.println(DespesaRepository.buscarTodasAsDespesas());
		
		
	}
	
	public void excluir() {
		
		TipoDespesa contaParaExcluir;
		System.out.println("Informe o nome da despesa para excluir: ");
		String despesaDigitada = scanner.nextLine();
		contaParaExcluir = TipoDespesa.valueOf(despesaDigitada);
		
		DespesaRepository.excluir(contaParaExcluir);
	
	}
	
}
