package antiPattern.models.application;

import antiPattern.models.entities.TipoCaminhao;
import antiPattern.models.entities.TipoCaminhaoEspecial;

public class Program {

	public static void main(String[] args) {
		TipoCaminhao caminhao = new TipoCaminhao(8, "Carreta Furacao" , 100.000, 2.0);
		TipoCaminhaoEspecial caminhao2 = new TipoCaminhaoEspecial();
		caminhao.valorPedagio();
		caminhao2.valorPedagio();
		
	}

}
