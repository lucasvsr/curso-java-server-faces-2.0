package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import modelo.Pessoa;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity

public class Reserva implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long codigo;
	private Date data;
	private double valor;
	@ManyToOne
	@JoinColumn(name="cod_pessoa")
	private Pessoa cliente;
	@OneToMany(mappedBy="reserva", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<DiariaReservada> diariaReservadas;
	private static final long serialVersionUID = 1L;

	public Reserva() {
		super();
	}   
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}   
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}   
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}   
	public Pessoa getCliente() {
		return this.cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Collection<DiariaReservada> getDiariaReservadas() {
		return diariaReservadas;
	}
	public void setDiariaReservadas(Collection<DiariaReservada> diariaReservadas) {
		this.diariaReservadas = diariaReservadas;
	}
   
}
