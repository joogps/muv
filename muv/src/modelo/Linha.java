package modelo;

import java.util.ArrayList;

public class Linha {
	
	public String nome;
	public ArrayList<Ponto> pontos;
	
	public Linha(String nome, ArrayList<Ponto> pontos){
		this.nome = nome;
		this.pontos = pontos;
	}
	
	public String getnome() {
		return nome;
	}
	
	public void setnome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}
	
	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}

	public Float distanciaAbsoluta() {
		if (pontos.size() > 1) {
			return pontos.get(0).localizacao.distancia(pontos.get(pontos.size()-1).localizacao);
		}
		return (float) 0.0;
	}
}
