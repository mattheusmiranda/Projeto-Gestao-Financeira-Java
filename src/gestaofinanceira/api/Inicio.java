package gestaofinanceira.api;

import java.util.Scanner;

import gestaofinanceira.api.view.TelaContaBancaria;
import gestaofinanceira.api.view.TelaDespesa;
import gestaofinanceira.api.view.TelaPessoa;

public class Inicio {
	
	static TelaPessoa telaPessoa = new TelaPessoa();
	static TelaDespesa telaDespesa = new TelaDespesa();
	static TelaContaBancaria telaContaBancaria = new TelaContaBancaria();
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Aqui é onde o sistema vai começar!!!!
		
		int opcaoSelecionada = 0;
		while (opcaoSelecionada >= 0 && opcaoSelecionada <= 3) {
			System.out.println("----------- SISTEMA DE GESTÃO FINANCEIRA -------------");
			System.out.println("- 1) Gerir pessoas                                   -");
			System.out.println("- 2) Gerir despesas                                  -");
			System.out.println("- 3) Gerir contas bancárias                          -");
			System.out.println("- 0) Sair do sistema                                 -");
			System.out.println("------------------------------------------------------");
			
			System.out.println("EScolha uma opção:");
			opcaoSelecionada = Integer.parseInt(scanner.nextLine());
			
			if (opcaoSelecionada == 1) {
				telaPessoa.imprimirMenu();
				
			} else if (opcaoSelecionada == 2) {
				telaDespesa.imprimirMenu();
				
			} else if (opcaoSelecionada == 3) {
				telaContaBancaria.imprimirMenu();
			} else if (opcaoSelecionada == 0) {
				return;
			} else {
				System.out.println("Opção invalida");  
			}
		}
	}
	
}
