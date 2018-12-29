package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MeuPrimeiroBean {

	private String ola = "<b>Olá amigos!</b>";
	private boolean exibir = true;
	
	public boolean isExibir() {
		return exibir;
	}

	public void setExibir(boolean exibir) {
		this.exibir = exibir;
	}

	public String getOla() {
		return ola;
	}
	
	public void setOla(String ola) {
		this.ola = ola;
	}

}
