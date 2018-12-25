package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Diaria
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public class Diaria implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long codigo;
	private Date data;
	@ManyToMany
	@JoinTable(name="Hospedagem",
	joinColumns = @JoinColumn(name = "cod_diaria"),
	inverseJoinColumns = @JoinColumn(name = "cod_pessoa"))
	private Collection<PessoaFisica> hospedes;
	private static final long serialVersionUID = 1L;

	public Diaria() {
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
	
	public Collection<PessoaFisica> getHospedes() {
		return hospedes;
	}
	public void setHospedes(Collection<PessoaFisica> hospedes) {
		this.hospedes = hospedes;
	}
   
}
