package antiPattern.models.entities;

public abstract class Caminhao{
	
	
	private Integer eixo;
	private String modelo;
	private Double preco;
	
	
	public Caminhao() {
	}

	public Caminhao(Integer eixo, String modelo, Double preco) {
		this.eixo = eixo;
		this.modelo = modelo;
		this.preco = preco;

		
	}

	public Integer getEixo() {
		return eixo;
	}

	public void setEixo(Integer eixo) {
		this.eixo = eixo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

	public void valorPedagioTeste() {
		System.out.println("30,00");
		
	}

	public void valorPedagio() {
		
	}
}