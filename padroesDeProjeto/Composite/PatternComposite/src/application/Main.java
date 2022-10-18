package application;

import models.entities.Sargento;
import models.entities.Oficial;
import models.interfaces.Soldado;

public class Main {

	public static void main(String[] args) {
		Soldado sargento = new Sargento("Dos Santios");
		Soldado oficial = new Oficial();
		
		oficial.adicionarServico(sargento);
		oficial.getNomeDeGuerra();
	}

}
