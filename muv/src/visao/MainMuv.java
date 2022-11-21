package visao;

import java.util.ArrayList;

import modelo.Coordenadas;
import modelo.Linha;
import modelo.Ponto;

public class MainMuv {

	public static void main(String[] args) {
		ArrayList<Ponto> pontos = new ArrayList<>();
		pontos.add(new Ponto(new Coordenadas(0, 0), false));
		pontos.add(new Ponto(new Coordenadas(10, 10), false));

		Linha linha = new Linha("Linha 1", pontos);

		System.out.println(linha.distanciaAbsoluta());
	}

}
