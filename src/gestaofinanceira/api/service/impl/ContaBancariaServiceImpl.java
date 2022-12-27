package gestaofinanceira.api.service.impl;

import java.math.BigDecimal;
import gestaofinanceira.api.domain.ContaBancaria;
import gestaofinanceira.api.domain.Pessoa;
import gestaofinanceira.api.repository.ContaBancariaRepository;
import gestaofinanceira.api.service.ContaBancariaService;

public class ContaBancariaServiceImpl implements ContaBancariaService{
	

	@Override
	public boolean senha(ContaBancaria senha) {
		return ContaBancariaRepository.senha(senha);
		
	}

	@Override
	public boolean dono(ContaBancaria nomeDono) {
		return ContaBancariaRepository.dono(nomeDono);
	}

	@Override
	public void transferir(BigDecimal transferir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultarSaldo(BigDecimal consultarSaldo) {
		ContaBancariaRepository.consultarSaldo(consultarSaldo);
	}

	@Override
	public void buscarPorNumeroDaConta(ContaBancaria buscarPorNumeroDaConta) {
	
		ContaBancariaRepository.buscarPorNumeroDaConta(buscarPorNumeroDaConta);
	}

	@Override
	public void buscarPorNomeDoDono(ContaBancaria buscarPorNomeDoDono) {
		ContaBancariaRepository.buscarPorNumeroDaConta(buscarPorNomeDoDono);
		
	}


}
