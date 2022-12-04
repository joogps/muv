package modelo;

public class Van extends Veiculo {
	
	public int assentos;
	
	public Van(String marca, String modelo, String cor, int assentos) {
		super (marca, modelo, cor);
		this.assentos = assentos;
	}

	public Van() {
		super();
		this.assentos = 0;
	}

	public int getAssentos() {
		return assentos;
	}
	
	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

}
