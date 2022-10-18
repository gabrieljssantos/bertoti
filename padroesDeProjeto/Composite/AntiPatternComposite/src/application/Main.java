package application;

import models.entities.Sargento;
import models.entities.ComandanteComposite;

public class Main {

	public static void main(String[] args) {
		Sargento sargento = new Sargento("dos Santos", "sargento");
		ComandanteComposite comandante = new ComandanteComposite("Souza", "comandante");

		comandante.add(sargento);
		sargento.add(comandante);

		System.out.println(comandante.getNomeDeGuerra());
	}

}
