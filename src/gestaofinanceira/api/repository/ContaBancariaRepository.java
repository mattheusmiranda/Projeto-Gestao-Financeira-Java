package gestaofinanceira.api.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;

public class ContaBancariaRepository {

	private static List<ContaBancaria> INFORMACOES_DA_CONTA = new ArrayList<>();
	
	public static boolean senha(ContaBancaria senha) {
		List<ContaBancaria> senhaDaConta = new ArrayList<>(); // verificar 
		if(senha.equals(senhaDaConta)) {
			return true;
		}
		return false;
	}
	
	public static boolean dono(ContaBancaria nomeDono) {
		List<ContaBancaria> nomeDonoDaConta = new ArrayList<>(); // verificar 
		if(nomeDono.equals(nomeDonoDaConta)) {
			return true;
		}
		return false;
	}
	
	
	public static void consultarSaldo(BigDecimal consultarSaldo) {
		List<ContaBancaria> saldoConta = new ArrayList<>();
		for(ContaBancaria buscarSado : INFORMACOES_DA_CONTA) {
			if(buscarSado.getSaldo().equals(saldoConta)) {
				saldoConta.add(buscarSado);
			}
		}
	}
	
	
	public static void buscarPorNumeroDaConta(ContaBancaria buscarPorNumeroDaConta) {
		List<ContaBancaria> listaNumeroDaConta = new ArrayList<>();
		for(ContaBancaria numeroConta : INFORMACOES_DA_CONTA) {
			if(listaNumeroDaConta.contains(numeroConta)) {
				listaNumeroDaConta.add(numeroConta);
			}
		}
	}
	
	
	public static void buscarPorNome(ContaBancaria buscarPorNome) {
		List<ContaBancaria> listaDeNomes = new ArrayList<>();
		for(ContaBancaria nomes : INFORMACOES_DA_CONTA) {
			if(listaDeNomes.contains(nomes)) {
				listaDeNomes.add(nomes);
			}
		}
	}	

	
	
	

	public static List<ContaBancaria> getINFORMACOES_DA_CONTA() {
		return INFORMACOES_DA_CONTA;
	}

	public static void setINFORMACOES_DA_CONTA(List<ContaBancaria> iNFORMACOES_DA_CONTA) {
		INFORMACOES_DA_CONTA = iNFORMACOES_DA_CONTA;
	}
	
}
