package designPattern.models.entites;

import designPattern.models.interfaces.ValorPedagio;

public class ValorPedagioCaminhoes implements ValorPedagio{

	@Override
	public void pagamentoPedagio() {
		System.out.println("Pedagio de R$ 50");
		
	}

}
