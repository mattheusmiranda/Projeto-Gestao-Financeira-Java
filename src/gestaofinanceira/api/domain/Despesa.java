package gestaofinanceira.api.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Despesa {

	private TipoDespesa descricao;
	private BigDecimal valor;
	private LocalDate dataVencimento;
	private boolean indicadorContaPaga;
	
	public TipoDespesa getDescricao() {
		return descricao;
	}
	public void setDescricao(TipoDespesa descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public boolean isIndicadorContaPaga() {
		return indicadorContaPaga;
	}
	public void setIndicadorContaPaga(boolean indicadorContaPaga) {
		this.indicadorContaPaga = indicadorContaPaga;
	}
	
	public double getJuros() {
		if(TipoDespesa.LUZ.equals(descricao)) {
			return 1;
		}else if(TipoDespesa.FATURA_CARTAO.equals(descricao)) {
			return 1;
		}else if(TipoDespesa.AGUA.equals(descricao)) {
			return 1;
		}else if(TipoDespesa.NETFLIX.equals(descricao)) {
			return 1;
		}else {
			return 0;
		}
	} 
	
	@Override
	public int hashCode() {
		return Objects.hash(dataVencimento, descricao);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(dataVencimento, other.dataVencimento) && descricao == other.descricao;
	}

	
}
