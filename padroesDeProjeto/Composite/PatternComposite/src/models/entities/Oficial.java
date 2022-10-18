package models.entities;

public class Oficial extends ComandanteComposite{

	private String nome;	
	
	@Override
	public String getNomeDeGuerra() {
		return nome;
	}
	

}
