package beans;

import java.util.ArrayList;
import java.util.Collection;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Pessoa;
import modelo.PessoaFisica;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class CadastroPessoasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoaSelecionada;
	private Collection<Pessoa> lista;
	
	public CadastroPessoasBean() {
		pessoaSelecionada = new PessoaFisica();
		lista = new ArrayList<Pessoa>();
		
		for (int i = 0; i < 10; i++) {
			Pessoa p = new PessoaFisica();
			p.setNome(String.format("Fulano %02d", i));
			p.setEmail(String.format("fulano%02d@teste.com.br", i));
			p.setTelefone(String.format("99999.88%02d", i));
			lista.add(p);
		}
	}
	
	
	public void salvar() {
		
		if(!lista.contains(pessoaSelecionada)) {
			lista.add(pessoaSelecionada);
		} 
	}
	
	public String cancelar() {
		return "primeiro.jsf";
	}
	
	public void excluir() {
		
		lista.remove(pessoaSelecionada);
		pessoaSelecionada = new PessoaFisica();
		
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

	
}
