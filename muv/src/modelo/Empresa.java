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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public ArrayList<Linha> getLinhas(){
		return linhas;
	}
	
	public void setLinhas(ArrayList<Linha> linhas) {
		this.linhas = linhas;
	}
	
	public ArrayList<Veiculo> getFrota(){
		return frota;
	}
	
	public void setFrota(ArrayList<Veiculo> frota) {
		this.frota = frota;
	}
	
}
