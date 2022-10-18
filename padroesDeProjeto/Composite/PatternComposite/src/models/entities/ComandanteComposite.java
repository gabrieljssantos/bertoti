package models.entities;

import java.util.ArrayList;
import java.util.List;

import models.interfaces.Soldado;

public abstract class ComandanteComposite implements Soldado{
	
	private String nome;
	private List<Soldado> list = new ArrayList<>();


	public String getNomeDeGuerra() {
		return nome;
	}

	public void setNomeDeGuerra(String nome) {
		this.nome = nome;
	}

	public List<Soldado> getList() {
		return list;
	}

	public void setList(List<Soldado> list) {
		this.list = list;
	}

	public void adicionarServico(Soldado soldado) {
		this.list.add(soldado);
		
	}

	@Override
	public void removerServico(Soldado soldado) {
		this.list.remove(soldado);
		
	}

}
