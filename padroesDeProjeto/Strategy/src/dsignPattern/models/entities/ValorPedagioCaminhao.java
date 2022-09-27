package dsignPattern.models.entities;

import designPattern.models.interfaces.ValorPedagio;

public class ValorPedagioCaminhao implements ValorPedagio {

	@Override
	public void pagamentoPedagio() {
		System.out.println("Valor do pedagio é R$ 30,00");
		
	}
	
}
