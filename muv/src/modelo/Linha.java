package modelo;

import java.util.ArrayList;

public class Linha {
	
	private Integer numero;
	private String nome;
	private ArrayList<Ponto> pontos;
	
	public Linha(Integer numero, String nome, ArrayList<Ponto> pontos) {
		this.numero = numero;
		this.nome = nome;
		this.pontos = pontos;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
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
		String string = "\n[" + numero + "] " + nome + " • " + pontos.size() + " pontos" + " • " + distanciaAbsoluta() + " km";
		int indice = 0;
		for (Ponto ponto : pontos) {
			string += "\nPonto " + indice + ": " + ponto.toString();
			indice++;
		}
		return string;
	}
}
