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
	public int getassentos() {
		return assentos;
		}
	
	public void setassentos(int assentos) {
		this.assentos = assentos;
		}
	
	public int getcapacidade() {
	return capacidade;
		}
	
	public void setcapacidade(int capacidade) {
	this.capacidade = capacidade;
		}
	
	public int getandares() {
	return andares;
		}

	public void setandares(int andares) {
	this.andares = andares;
		}
	
	public boolean getsanfonado() {
		return sanfonado;
		}

		public void setsanfonado(boolean sanfonado) {
		this.sanfonado = sanfonado;
		}

}


