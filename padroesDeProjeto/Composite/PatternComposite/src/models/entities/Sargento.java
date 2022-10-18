package models.entities;

import java.util.ArrayList;
import java.util.List;

import models.interfaces.Soldado;

public class Sargento implements Soldado {

	private String nome;
	private List <Soldado> list = new ArrayList<>();

	public Sargento(String nome) {
		this.nome = nome;
	}

	@Override
	public void adicionarServico(Soldado soldado) {
		this.list.add(soldado);
	}

	@Override
	public void removerServico(Soldado soldado) {
		this.list.remove(soldado);

	}

	@Override
	public String getNomeDeGuerra() {
		return nome;
	}

}
