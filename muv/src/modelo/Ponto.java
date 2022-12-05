package modelo;

public class Ponto {
	private Coordenadas localizacao;
	private boolean coberto;
	
	public Ponto(Coordenadas localizacao, boolean coberto) {
		this.localizacao = localizacao;
		this.coberto = coberto;
	}
	
	public Coordenadas getLocalizacao() {
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
		String string = localizacao.latitude + "º, " + localizacao.longitude + "º " + (coberto ? "(coberto)" : "(descoberto)");
		return string;
	}
}
