package com.api.aluguelcarro.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ALUGUEL")
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USUARIO", nullable = false)
	@JsonIgnore
	private User usuario;

	@ManyToOne
	@JoinColumn(name = "VEICULO", nullable = false)
	private Vehicle veiculo;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	@Column(name="MEIO_PAGAMENTO")
	private Integer meioPagamento;
	@Column(name = "DATA_ALUGUEL")
	private Timestamp dataAluguel;

	@Column(name = "DATA_INICIO")
	private Timestamp dataInicio;

	@Column(name = "DATA_FIM")
	private Timestamp dataFim;

	@Column(name = "STATUS")
	@Enumerated(EnumType.ORDINAL)
	private StatusAluguel status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Vehicle getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Vehicle veiculo) {
		this.veiculo = veiculo;
	}

	public Timestamp getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Timestamp dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Timestamp getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Timestamp getDataFim() {
		return dataFim;
	}

	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}

	public StatusAluguel getStatus() {
		return status;
	}

	public void setStatus(StatusAluguel status) {
		this.status = status;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(Integer meioPagamento) {
		this.meioPagamento = meioPagamento;
	}
}
