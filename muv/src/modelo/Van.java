package modelo;

public class Van extends Veiculo {
	private int assentos;
	
	public Van(Integer codigo, String marca, String modelo, String cor, int assentos) {
		super (codigo, marca, modelo, cor);
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

	@Override
	public String toString() {
		String string = "Van • " + super.toString() + " • " + getAssentos() + " assentos";
		return string;
	}
}
