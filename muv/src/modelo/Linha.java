package modelo;

import java.util.ArrayList;

public class Linha {
	
	private String nome;
	private ArrayList<Ponto> pontos;
	
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
			return pontos.get(0).getLocalizacao().distancia(pontos.get(pontos.size()-1).getLocalizacao());
		}
		return (float) 0.0;
	}

	@Override
	public String toString() {
		String string = nome + " • " + pontos.size() + " pontos" + " • " + distanciaAbsoluta() + " km\n";
		int indice = 0;
		for (Ponto ponto : pontos) {
			string += "\nPonto " + indice + ": " + ponto.toString() + "";
			indice++; 		}
		
		return string;
	}
}
