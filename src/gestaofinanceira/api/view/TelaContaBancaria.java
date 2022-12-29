package gestaofinanceira.api.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;
import gestaofinanceira.api.repository.ContaBancariaRepository;
import gestaofinanceira.api.service.impl.ContaBancariaServiceImpl;

public class TelaContaBancaria {

	Scanner scanner = new Scanner(System.in);
	
	public void imprimirMenu() {
		int opcaoSelecionada = 0;
		while (opcaoSelecionada >= 0 && opcaoSelecionada <= 3) {
			System.out.println("------- MENU DE DESPESAS -----------------------");
			System.out.println("- 1) Criar uma nova conta             		   -");
			System.out.println("- 2) Procurar uma conta               		   -");
			System.out.println("- 3) Fazer transferencia              		   -");
			System.out.println("- 4) Procurar uma conta pelo o numero dela     -");
			System.out.println("- 5) Procurar uma conta pelo nome do dono      -");	
			System.out.println("- 0) Voltar menu anterior    		  		   -");
			System.out.println("------------------------------------------------");
			
			System.out.println("Escolha uma opção: ");
			opcaoSelecionada = Integer.parseInt(scanner.nextLine());
			
			if (opcaoSelecionada == 1) {
				cadastrar();
				
			} else if (opcaoSelecionada == 2) {
				procurarConta();
			} else if (opcaoSelecionada == 3) {
				// transferir
			}else if( opcaoSelecionada == 4) {
				buscarComONumeroDaConta();
			}else if( opcaoSelecionada == 5) {
				buscarPeloNome();
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
		
		ContaBancaria novaConta = new ContaBancaria();
		Pessoa pessoa = new Pessoa();
		
		System.out.println("Informe o numero da conta: ");
		int numeroDigitado = scanner.nextInt();
		novaConta.setNumero(numeroDigitado);  // TODO verificar se aceita pelo tipo 
		
		System.out.println("Informe o valor do seu saldo: ");
		BigDecimal valorDigitado = scanner.nextBigDecimal();
		novaConta.setSaldo(valorDigitado);
		
		System.out.println("Informe o nome do dono: ");
		String nome = scanner.nextLine();
		pessoa.setNome(nome);
		novaConta.setDono(pessoa);
		
		ContaBancariaRepository.salvar(novaConta);
	}
	
	public void procurarConta() {
		
		ContaBancaria procurarConta = new ContaBancaria();
		Pessoa pessoa = new Pessoa();
		
		System.out.println("Informe o nome do dono da conta: ");
		String nome = scanner.nextLine();
		pessoa.setNome(nome);
		procurarConta.setDono(pessoa);
		
		System.out.println("Informe o numero da conta: ");
		int numeroConta = scanner.nextInt();
		procurarConta.setNumero(numeroConta);
		
	}
	
	public void transferir() {
		// BigDecimal transferir, ContaBancaria contaBancariaParaTransferir, ContaBancaria contaBancariaParaReceber
		ContaBancaria conta = new ContaBancaria();
		ContaBancaria conta2 = new ContaBancaria();
		
		System.out.println("Informe o valor pra ser transferido: ");
		BigDecimal valorDigitado = new BigDecimal(scanner.nextLine());
		
		System.out.println("Informe o numero da sua conta: ");
		int num = scanner.nextInt();
		conta.setNumero(num);
		
		System.out.println("Informe o numero da conta que voce deseja transferir: ");
		int num2 = scanner.nextInt();
		conta2.setNumero(num);
	
		ContaBancariaServiceImpl av = new ContaBancariaServiceImpl();
		av.transferir(valorDigitado, conta, conta2);
		
	
	}
	
	
	public void buscarComONumeroDaConta() {
		
		System.out.println("Informe o numero da conta: ");
		int numeroDigitado = scanner.nextInt();
		
		ContaBancariaRepository.buscarPorNumeroDaConta(numeroDigitado);
	}
	
	public void buscarPeloNome() {
		
		System.out.println("Informe o nome do dono da conra: ");
		String nomeDigitado = scanner.nextLine();
		
		ContaBancariaRepository.buscarPorNomeDoDono(nomeDigitado);
	}	
	
}
