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
	
	public void setLocalizacao(Coordenadas localizacao) {
		this.localizacao = localizacao;
	}
	
	public Boolean getCoberto() {
		return coberto;
	}
	
	public void setCoberto(Boolean coberto) {
		this.coberto = coberto;
	}
	
}
