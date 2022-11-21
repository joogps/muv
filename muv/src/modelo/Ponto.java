package modelo;

public class Ponto {

	 Coordenadas localizacao;
	 Boolean coberto;
	
	public Ponto(Coordenadas localizacao, Boolean coberto) {
		this.localizacao = localizacao;
		this.coberto = coberto;
	}
	
	public Coordenadas getlocalizacao() {
		return localizacao;
	}
	
	public void setlocalizacao(Coordenadas localizacao) {
		this.localizacao = localizacao;
	}
	
	public Boolean getcoberto() {
		return coberto;
	}
	
	public void setcoberto(Boolean coberto) {
		this.coberto = coberto;
	}
	
}
