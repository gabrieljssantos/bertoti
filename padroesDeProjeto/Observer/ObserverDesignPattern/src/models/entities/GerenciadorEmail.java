package models.entities;


import models.interfaces.Email;
import models.interfaces.Observer;

public class GerenciadorEmail implements Email, Observer{
	
	private Usuarios possivelUsuario;
	
	private String email;
	private String name;	

	public GerenciadorEmail(Usuarios possivelUsuario, String email) {
		this.possivelUsuario = possivelUsuario;
		this.email = email;
	}

	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}


	@Override
	public void emailEnviado() {
		System.out.println("Usuario recebeu um email com sucesso!");
		
	}


	@Override
	public void atualizar(String str) {
		System.out.println("Ocorreu uma mudança no estado!");
		
	}



}
