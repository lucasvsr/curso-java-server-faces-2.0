package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MeuPrimeiroBean {

	private String ola = "Olá amigos!";
	
	public String getOla() {
		return ola;
	}
	
	public void setOla(String ola) {
		this.ola = ola;
	}

}
