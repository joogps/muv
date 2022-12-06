package modelo;

public abstract class Veiculo {
	private Integer codigo;
	private String marca;
	private String modelo;
	private String cor;
	
	public Veiculo(Integer codigo, String marca, String modelo, String cor) {
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo; 
		this.cor = cor;
	}

	public Veiculo() {
		this.codigo = 0;
		this.marca = "";
		this.modelo = "";
		this.cor = "";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		String string = "[" + getCodigo() + "] Modelo " + getModelo() + " • " + getMarca() + " • " + getCor();
		return string;
	}
}
