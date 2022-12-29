package gestaofinanceira.api.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import gestaofinanceira.api.domain.Pessoa;
import gestaofinanceira.api.repository.PessoaRepository;
import gestaofinanceira.api.service.PessoaService;
import gestaofinanceira.api.service.impl.PessoaServiceImpl;

public class TelaPessoa {

	static Scanner scanner = new Scanner(System.in);
	
	static PessoaService pessoaService = new PessoaServiceImpl();
	
	public static void imprimirMenu() {
		int opcaoSelecionada = 0;
		while (opcaoSelecionada >= 0 && opcaoSelecionada <= 3) {
			System.out.println("------- MENU DE PESSOA --------------");
			System.out.println("- 1) Cadastrar                      -");
			System.out.println("- 2) Buscar por CPF                 -");
			System.out.println("- 3) Buscar por Nome                -");
			System.out.println("- 4) Excluir                        -");
			System.out.println("- 5) Verificar cpf ja cadastrado    -");	
			System.out.println("- 0) Voltar menu anterior    		-");
			System.out.println("-------------------------------------");
			
			System.out.println("Escolha uma opção: ");
			opcaoSelecionada = Integer.parseInt(scanner.nextLine());
			
			if (opcaoSelecionada == 1) {
				cadastrar();
				
			} else if (opcaoSelecionada == 2) {
				buscarPorCpf();
			} else if (opcaoSelecionada == 3) {
				buscarPorNome();
			}else if( opcaoSelecionada == 4) {
				excluir();
			}else if( opcaoSelecionada == 5) {
				verificarCpf();
			}
			else if (opcaoSelecionada == 0) {
				//TODO sair do menu de pessoa
				opcaoSelecionada = -1;
			} else {
				System.out.println("ATENÇÃO!!! Opção inválida, digite uma das opções abaixo");
				opcaoSelecionada = 0;
			}
		}
	}
	
	public static void cadastrar() {
		
		Pessoa novaPessoa = new Pessoa();
		
		System.out.println("Informe o nome para cadastro: ");
		String nomeDigitado = scanner.nextLine();
		novaPessoa.setNome(nomeDigitado);
		
		System.out.println("Informe o CPF para cadastro: ");
		String cpfDigitado = scanner.nextLine();
		novaPessoa.setCpf(cpfDigitado);
		
		System.out.println("Informe a data de nascimento do usuario para cadastro: ");
		String dataDigitada = scanner.nextLine();
		LocalDate dataLocalDate = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		novaPessoa.setDataNascimento(dataLocalDate);
	
		//pessoaService.salvar(novaPessoa);
	}
	
	public static void buscarPorCpf() {
		
		Pessoa novaPessoa = new Pessoa();
		
		System.out.println("Informe o CPF para a busca: ");
		String cpfDigitado = scanner.nextLine();
		PessoaRepository.buscarPorCpf(cpfDigitado);
		// TODO implementar toStrings
	}
	
	public static void buscarPorNome() {
		
		System.out.println("Informe o nome para a busca: ");
		String nomeDigitado = scanner.next();
		pessoaService.buscarPorNome(nomeDigitado);
		
	}
	
	public static void excluir() {
		
		System.out.println("Informe o CPF para excluir: ");
		String cpfDigitado = scanner.nextLine();
		pessoaService.excluir(cpfDigitado);
	
	}
	
	public static void verificarCpf() {
		System.out.println("Informe o CPF para verificar: ");
		String cpfDigitado = scanner.nextLine();
		pessoaService.cpfJaCadastrado(cpfDigitado);

	}
	
	
}
