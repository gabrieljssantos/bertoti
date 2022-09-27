package designPattern.models.entites;

import designPattern.models.interfaces.ValorPedagio;

public  class Caminhao{
	
	private ValorPedagio valorPedagio;
	
	private Integer eixo;
	private String modelo;
	private Double preco;
	
	
	public Caminhao() {
	}

	public Caminhao(Integer eixo, String modelo, Double preco, ValorPedagio x) {
		this.eixo = eixo;
		this.modelo = modelo;
		this.preco = preco;
		this.valorPedagio = x;
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

	public void setValorPedagio(ValorPedagio valorPedagio) {
		this.valorPedagio = valorPedagio;
	}
	
	public void getValorPedagio() {
		this.valorPedagio.pagamentoPedagio();
	}
	
}
