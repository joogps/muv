package modelo;

import java.util.ArrayList;

public class Empresa {

	public String nome;
	public String cnpj;
	public ArrayList<Linha> linhas;
	public ArrayList<Veiculo> frota;
	
	public Empresa(String nome, String cnpj, ArrayList<Linha> linhas, ArrayList<Veiculo> frota) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.linhas = linhas;
		this.frota = frota;
		
	}
	
	public String getnome() {
		return nome;
	}
	
	public void setnome(String nome) {
		this.nome = nome;
	}
	
	public String getcnpj() {
		return cnpj;
	}
	
	public void setcnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public ArrayList<Linha> getlinhas(){
		return linhas;
	}
	
	public void setlinhas(ArrayList<Linha> linhas) {
		this.linhas = linhas;
	}
	
	public ArrayList<Veiculo> getfrota(){
		return frota;
	}
	
	public void setfrota(ArrayList<Veiculo> frota) {
		this.frota = frota;
	}
}
