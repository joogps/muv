package modelo;

public class Onibus extends Veiculo {
	
	public int assentos;
	public int capacidade;
	public int andares;
	public boolean sanfonado;
	
	public Onibus(int assentos, int capacidade, int andares, boolean sanfonado, String marca, String modelo, String cor) {
		super (marca, modelo, cor);
		
		this.assentos = assentos;
		this.capacidade = capacidade;
		this.andares = andares;
		this.sanfonado = sanfonado;
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
	
}


