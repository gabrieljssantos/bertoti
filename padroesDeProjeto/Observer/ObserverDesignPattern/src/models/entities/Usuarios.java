package models.entities;

import java.util.ArrayList;
import java.util.List;

import models.interfaces.Email;
import models.interfaces.Observable;
import models.interfaces.Observer;

public class Usuarios implements Email, Observable{
	
	private List<Observer> observers = new ArrayList<>();
	private String email;
	private Double km;
	private String name;
	
	
	public Usuarios(String email, String name) {
		this.email = email;
		this.name = name;
	}


	public List<Observer> getObservers() {
		return observers;
	}


	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}


	public String getemail() {
		return email;
	}


	public void setemail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void notificarObservers() {
		for(Observer obs: observers ) {
			obs.atualizar(name);
		}
		
	}


	@Override
	public void emailEnviado() {
		System.out.println(" O Email foi enviado ");
		
	}


	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}

}
