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
	
	public void setlocalizacao(Coordenadas localizacao) {
		this.localizacao = localizacao;
	}
	
	public boolean getcoberto() {
		return coberto;
	}
	
	public void setcoberto(boolean coberto) {
		this.coberto = coberto;
	}
	
}
