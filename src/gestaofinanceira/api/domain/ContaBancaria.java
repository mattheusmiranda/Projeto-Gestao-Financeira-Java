package gestaofinanceira.api.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaBancaria {
	private int numero;
	private BigDecimal saldo;
	private Pessoa dono;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Pessoa getDono() {
		return dono;
	}
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		return numero == other.numero;
	}
	
}
