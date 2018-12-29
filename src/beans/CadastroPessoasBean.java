package beans;

import java.util.ArrayList;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.Sexo;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class CadastroPessoasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoaSelecionada;
	private Collection<Pessoa> lista;
	private String tipoNovaPessoa;
	
	
	public CadastroPessoasBean() {
		pessoaSelecionada = new PessoaFisica();
		lista = new ArrayList<Pessoa>();
		
		for (int i = 0; i < 10; i++) {
			
			Pessoa p = (i%2 == 0) ? new PessoaFisica() : new PessoaJuridica();
			p.setNome(String.format("Fulano %02d", i));
			p.setEmail(String.format("fulano%02d@teste.com.br", i));
			p.setTelefone(String.format("99999.88%02d", i));
			
			lista.add(p);
		}
		
		pessoaSelecionada = null;
	}
	
	public void criar() {
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if(tipoNovaPessoa == null) {
			contexto.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Especifique o tipo de pessoa", ""));
			return;
		}
		
		if (tipoNovaPessoa.equals("PF")) {
			pessoaSelecionada = new PessoaFisica();
		} else if (tipoNovaPessoa.equals("PJ")) {
			pessoaSelecionada = new PessoaJuridica();
		}
		
		contexto.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa criada com sucesso",""));
		
	}
	
	public void salvar() {
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if(!lista.contains(pessoaSelecionada)) {
			lista.add(pessoaSelecionada);
		} 
		
		contexto.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa editada com sucesso",""));

	}
	
	public String cancelar() {
		
		pessoaSelecionada = null;
		tipoNovaPessoa = null;
		
		return "cadastropessoas.jsf";
	}
	
	public void excluir() {
		
		lista.remove(pessoaSelecionada);
		pessoaSelecionada = new PessoaFisica();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa excluída com sucesso", " "));
		
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	public Collection<Pessoa> getLista() {
		return lista;
	}
	public void setLista(Collection<Pessoa> lista) {
		this.lista = lista;
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}


	public String getTipoNovaPessoa() {
		return tipoNovaPessoa;
	}


	public void setTipoNovaPessoa(String tipoNovaPessoa) {
		this.tipoNovaPessoa = tipoNovaPessoa;
	}

	
	public boolean isPessoaFisicaSelecionada() {
		return pessoaSelecionada instanceof PessoaFisica;
	}
	
	public boolean isPessoaJuridicaSelecionada() {
		return pessoaSelecionada instanceof PessoaJuridica;
	}
	
}
