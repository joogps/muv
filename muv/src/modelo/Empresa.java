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
	
	public Empresa() {
		this.nome = "";
		this.cnpj = "";
		this.linhas = new ArrayList<>();
		this.frota = new ArrayList<>();
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

	public void addLinhas(ArrayList<Linha> linhas) {
		this.linhas.addAll(linhas);
	}

	public void addLinha(Linha linha) {
		this.linhas.add(linha);
	}
	
	public ArrayList<Veiculo> getFrota(){
		return frota;
	}
	
	public void setFrota(ArrayList<Veiculo> frota) {
		this.frota = frota;
	}

	public void addVeiculos(ArrayList<Veiculo> veiculos) {
		this.frota.addAll(veiculos);
	}

	public void addVeiculo(Veiculo veiculo) {
		this.frota.add(veiculo);
	}
	
	@Override
	public String toString() {
		String cnpjPattern = "(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})";
		String parsedCnpj = String.valueOf(cnpj).replaceAll(cnpjPattern, "$1.$2.$3/$4-$5");

		String string = nome;
		string += " • " + parsedCnpj;
		for (Linha linha: linhas) {
			string+="\n"+"-".repeat(40)+"\n";
			string += linha.toString();
		}
		return string;
	}
}
