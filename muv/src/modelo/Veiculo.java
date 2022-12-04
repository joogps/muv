package modelo;

public abstract class Veiculo {
	
	public String marca;
	public String modelo;
	public String cor;
	
	public Veiculo(String marca, String modelo, String cor) {
		this.marca = marca;
		this.modelo = modelo; 
		this.cor = cor;
	}

	public Veiculo() {
		this.marca = "";
		this.modelo = "";
		this.cor = "";
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	

}
