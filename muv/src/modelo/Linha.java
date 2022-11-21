package modelo;

import java.util.ArrayList;

public class Linha {
	
	public String nome;
	public ArrayList<Ponto> pontos;
	
	public static double distanciaAbsoluta() {
		return 0.0;
	}
	
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
	
	public ArrayList<Ponto> getpontos(){
		return pontos;
	}
	
	public void setpontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}

}
