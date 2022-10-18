package models.entities;

import java.util.ArrayList;
import java.util.List;

public class Soldado {
	
	private String nome;
	private String patente;
	private List<Soldado> militares = new ArrayList<>();
	
	public Soldado(String nome, String patente) {
		super();
		this.nome = nome;
		this.patente = patente;
	}

	public String getNomeDeGuerra() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPatente() {
		return patente;
	}
	
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void add(Soldado func) {
		this.militares.add(func);
		
	}
}
