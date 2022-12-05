package modelo;

public class Onibus extends Veiculo {
	private int assentos;
	private int capacidade;
	private int andares;
	private boolean sanfonado;
	
	public Onibus(Integer codigo, String marca, String modelo, String cor, int assentos, int capacidade, int andares, boolean sanfonado) {
		super (codigo, marca, modelo, cor);
		this.assentos = assentos;
		this.capacidade = capacidade;
		this.andares = andares;
		this.sanfonado = sanfonado;
	}

	public Onibus() {
		super();
		this.assentos = 0;
		this.capacidade = 0;
		this.andares = 0;
		this.sanfonado = false;
	}
	
	public int getAssentos() {
		return assentos;
	}
	
	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public int getAndares() {
		return andares;
	}
	
	public void setAndares(int andares) {
		this.andares = andares;
	}
	
	public boolean getSanfonado() {
		return sanfonado;
	}
	
	public void setSanfonado(boolean sanfonado) {
		this.sanfonado = sanfonado;
	}

	@Override
	public String toString() {
		String string = "Ônibus • " + super.toString() + " • " + getAssentos() + " assentos • Capacidade total de " + getCapacidade() + "  pessoas • " + getAndares() + " andares • " + (getSanfonado() ? "sanfonado" : "não sanfonado");
		return string;
	}
}


