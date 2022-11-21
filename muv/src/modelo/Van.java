package modelo;

public class Van extends Veiculo {
	
	public int assentos;
	
	public Van(int assentos, String marca, String modelo, String cor) {
		super (marca, modelo, cor);
		this.assentos = assentos;
		
	}
	public int getAssentos() {
		return assentos;
	}
	
	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

}
