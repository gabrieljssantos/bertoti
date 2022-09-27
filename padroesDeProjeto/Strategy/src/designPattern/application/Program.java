package designPattern.application;

import designPattern.models.entites.Caminhao;
import designPattern.models.entites.ValorPedagioCaminhoes;

public class Program {

	public static void main(String[] args) {
		Caminhao caminhao = new Caminhao();
		caminhao.setValorPedagio(new ValorPedagioCaminhoes());
		caminhao.getValorPedagio();
		

	}

}
