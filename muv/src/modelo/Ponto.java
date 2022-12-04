package modelo;

public class Ponto {

	 Coordenadas localizacao;
	 boolean coberto;
	
	public Ponto(Coordenadas localizacao, boolean coberto) {
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
	
	@Override
	public String toString() {
		String string = "Latitude: " + localizacao.latitude + " - Longitude: " + localizacao.longitude + (coberto ? " - Coberto" : " - Descoberto");
		return string;
	}
}
