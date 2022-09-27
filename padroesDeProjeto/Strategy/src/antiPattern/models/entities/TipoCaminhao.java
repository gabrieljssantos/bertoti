package antiPattern.models.entities;

public class TipoCaminhao extends Caminhao{
	private Double step;

	public TipoCaminhao(Integer eixo, String modelo, Double preco, Double step) {
		super(eixo, modelo, preco);
		this.step = step;
	}

	public Double getstep() {
		return step;
	}

	public void setstep(Double step) {
		this.step = step;
	}
	
	@Override
	public void valorPedagio() {
		System.out.println("O valor do Caminhao Especial Step é: " +30 + (step*10));
	}

}
