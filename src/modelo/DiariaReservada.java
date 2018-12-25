package modelo;

import java.io.Serializable;
import javax.persistence.*;
import modelo.Diaria;

/**
 * Entity implementation class for Entity: DiariaReservada
 *
 */
@Entity
public class DiariaReservada extends Diaria implements Serializable {

	@ManyToOne
	@JoinColumn(name="cod_reserva")
	private Reserva reserva;
	private static final long serialVersionUID = 1L;

	public DiariaReservada() {
		super();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
   
}
