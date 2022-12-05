package visao;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import java.nio.file.Paths;

import controle.EmpresaDAO;
import modelo.Coordenadas;
import modelo.Empresa;
import modelo.Linha;
import modelo.Onibus;
import modelo.Ponto;
import modelo.Van;
import modelo.Veiculo;

public class MainMuv {
	static Scanner leitura = new Scanner(System.in);
	static EmpresaDAO bancoEmpresa = EmpresaDAO.getInstancia();

	public static void main(String[] args) {
		// Substituir com o caminho do arquivo na máquina
		var path = Paths.get("/Users/joogps/Desktop/muv/muv/src/visao/logo.txt");
		System.out.println(path);

		try {
			String logo = Files.readString(path);
			System.out.println(logo);
		} catch (IOException e) {
			e.printStackTrace();
		}

		menu();

		leitura.close();

	}

	static public void menu() {
		Integer opcao = Integer.MAX_VALUE;

		while (opcao != 0) {
			System.out.println(separador("MENU"));
			System.out.println("0 • SAIR");
			System.out.println("1 • CADASTRAR");
			System.out.println("2 • ALTERAR");
			System.out.println("3 • EXCLUIR");
			System.out.println("4 • LISTAR");

			System.out.println(separador(""));

			opcao = Integer.valueOf(leitura.nextLine());

			switch (opcao) {
			case 0: {
				break;
			}
			case 1: {
				cadastrar();
				break;
			}
			case 2: {
				atualizar();
				break;
			}
			case 3: {
				excluir();
				break;
			}
			case 4: {
				listar();
				break;
			}
			}

			System.out.println(separador(""));
		}
	}

	static public void atualizar() {
		System.out.println(separador("ATUALIZAR"));

		String cnpj = lerString("o CNPJ da empresa que deseja alterar", 14);

		
		String nome = lerString("o nome atualizado", 0);
	}

	static public void cadastrar() {
		System.out.println(separador("CADASTRAR"));

		Empresa empresa = new Empresa();
				
		String nome = lerString("o nome", 0);
		String cnpj = lerString("o CNPJ", 14)
						.substring(0, 14)
						.replaceAll("[^0-9]", "");

		empresa.setNome(nome);
		empresa.setCnpj(cnpj);

		while (true) {
			Linha linha = cadastrarLinha();
			if (linha == null) {
				break;
			}
			empresa.addLinha(linha);
		}

		while (true) {
			Veiculo veiculo = cadastrarVeiculo();
			if (veiculo == null) {
				break;
			}
			empresa.addVeiculo(veiculo);
		}

		boolean valida = bancoEmpresa.inserir(empresa);
		if (valida == true) {
			System.out.println("\nCadastrado realizado com sucesso!");
		} else {
			System.out.println("\nErro ao cadastrar a empresa.");
		}
	}

	public static Veiculo cadastrarVeiculo() {
		char tipo = lerChar("Digite o tipo de veículo que deseja cadastrar (v: van, o: ônibus). Para finalizar, pressione enter.");

		if (tipo != 'v' && tipo != 'o') {
			return null;
		}

		String marca = lerString("a marca", 0);
		String modelo = lerString("o modelo", 0);
		String cor = lerString("a cor", 0);

		Veiculo veiculo = null;

		if (tipo == 'v') {
			int assentos = Integer.valueOf(lerString("o número de assentos", 0));

			veiculo = new Van(marca, modelo, cor, assentos);
		} else if (tipo == 'o') {
			int assentos = Integer.valueOf(lerString("o número de assentos", 0));
			int capacidade = Integer.valueOf(lerString("a capacidade total", 0));
			int andares = Integer.valueOf(lerString("o número de andares", 0));
			boolean sanfonado = lerBooleano("O ônibus é sanfonado?");

			veiculo = new Onibus(marca, modelo, cor, assentos, capacidade, andares, sanfonado);
		}

		return veiculo;
	}

	public static Linha cadastrarLinha() {
		Linha linha;

		System.out.println("\nDigite o nome da linha para cadastrar uma nova. Para finalizar, pressione enter.");
		String nomeLinha = leitura.nextLine();

		if (nomeLinha.isEmpty()) {
			return null;
		} else {
			ArrayList<Ponto> pontos = new ArrayList<>();

			while (true) {
				boolean cadastrar = lerBooleano("Você quer cadastrar um novo ponto?");

				if (cadastrar) {
					String latitude = lerString("a latitude do ponto", 0);
					String longitude = lerString("a longitude do ponto", 0);
					Boolean coberto = lerBooleano("O ponto é coberto?");

					Coordenadas coordenadas = new Coordenadas(Float.valueOf(latitude), Float.valueOf(longitude));
					Ponto ponto = new Ponto(coordenadas, coberto);
					pontos.add(ponto);
				} else {
					break;
				}
			}

			linha = new Linha(nomeLinha, pontos);
		}

		return linha;
	}

	public static void excluir() {
		System.out.println(separador("EXCLUIR"));
		System.out.println("Digite o CNPJ da empresa que deseja excluir:");
		String cnpj = leitura.nextLine();

		boolean excluir = bancoEmpresa.excluir(cnpj);
		if (excluir == true) {
			System.out.println("Excluída com sucesso.");
		} else {
			System.out.println("Erro ao excluir. Tente novamente.");
		}
	}

	static public void listar() {
		System.out.println(separador("EMPRESAS"));
		ArrayList<Empresa> lista = bancoEmpresa.listarEmpresas();
		for (Empresa empresa : lista) {
			System.out.println(empresa);
		}
	}

	static String lerString(String nome, Integer digitos) {
		String valor = "";
		while (true) {
			System.out.println("\nDigite " + nome + ":");
			valor = leitura.nextLine();
			
			if (valor.isEmpty()) {
				System.out.println("O " + nome + " não pode ser vazio. Tente novamente.");
			} else if (valor.length() < digitos) {
				System.out.println("O " + nome + " deve conter no mínimo " + digitos + " digitos. Tente novamente.");
			} else {
				break;
			}
		}

		return valor;
	}

	static boolean lerBooleano(String prompt) {
		char resposta = lerChar("\n"+prompt+" (s/n)");
		return resposta == 's';
	}

	static char lerChar(String prompt) {
		System.out.println(prompt);
		if (prompt.isEmpty()) {
			return ' ';
		} else {
			return Character.toLowerCase(leitura.nextLine().charAt(0));
		}
	}

	public static String separador(String title) {
		Integer length = 40;
		String separador = "\n";
		Integer dashes = 0;

		if (title.isEmpty()) {
			dashes = (length+2-title.length())/2;
		} else {
			dashes = (length-title.length())/2;
		}

		separador+= "-".repeat(dashes);
		if (!title.isEmpty()) {
			separador+=" "+title+" ";
		}
		separador+= "-".repeat(dashes);

		separador+="\n";

		return separador;
	}
}