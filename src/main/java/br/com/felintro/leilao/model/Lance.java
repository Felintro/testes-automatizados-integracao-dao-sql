package br.com.felintro.leilao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lance")
public class Lance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lance")
	private Long id;

	@NotNull
	@Column(name = "vl_lance")
	private BigDecimal valor;

	@NotNull
	@Column(name = "dt_lance")
	private LocalDate data;

	@OneToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Leilao leilao;

	@Deprecated
	public Lance() {
	}

	public Lance(Usuario usuario, BigDecimal valor) {
		if (valor.doubleValue() <= 0) {
			throw new IllegalArgumentException();
		}
		this.usuario = usuario;
		this.valor = valor;
		this.data = LocalDate.now();
	}

	public Lance(@NotNull @DecimalMin("0.1") BigDecimal valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

}
