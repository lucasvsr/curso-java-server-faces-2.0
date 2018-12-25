package modelo;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import modelo.Pessoa;

/**
 * Entity implementation class for Entity: PessoaFisica
 *
 */
@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa implements Serializable {

	
	private String cpf;
	private String rg;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Enumerated
	private Sexo sexo;
	private static final long serialVersionUID = 1L;

	public PessoaFisica() {
		super();
	}  
	
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	} 
	
	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}   
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
   
}
