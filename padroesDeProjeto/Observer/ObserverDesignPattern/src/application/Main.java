package application;

import models.entities.GerenciadorEmail;
import models.entities.Usuarios;

public class Main {

	public static void main(String[] args) {
		Usuarios user = new Usuarios("teste@gmail.com", "Gabriel");
		GerenciadorEmail gerEmail = new GerenciadorEmail(user, "email@gmail.com");
		
		user.addObserver(gerEmail);
		user.emailEnviado();
		user.notificarObservers();
	}

}
