package visao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
		logo();
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

			opcao = lerNumero("a opção desejada");

			switch (opcao) {
			case 0: {
				System.out.println(separador(""));
				System.out.println("Até breve!");
				break;
			}
			case 1: {
				cadastrar();
				break;
			}
			case 2: {
				alterar();
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

	static public void cadastrar() {
		System.out.println(separador("CADASTRAR"));

		Empresa empresa = new Empresa();
				
		String nome = lerString("o nome da empresa", 0);
		String cnpj = lerString("o CNPJ da empresa", 14)
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

		if (bancoEmpresa.inserir(empresa)) {
			System.out.println("\nCadastrado realizado com sucesso!");
		} else {
			System.out.println("\nErro ao cadastrar a empresa.");
		}
	}

	public static Veiculo cadastrarVeiculo() {
		char tipo = lerChar("\nDigite o tipo de veículo que deseja cadastrar (v: van, o: ônibus). Para finalizar, pressione enter.");

		if (tipo != 'v' && tipo != 'o') {
			return null;
		}

		Integer codigo = lerNumero("o código do veículo");
		String marca = lerString("a marca", 0);
		String modelo = lerString("o modelo", 0);
		String cor = lerString("a cor", 0);

		Veiculo veiculo = null;

		if (tipo == 'v') {
			Integer assentos = Integer.valueOf(lerString("o número de assentos", 0));

			veiculo = new Van(codigo, marca, modelo, cor, assentos);
		} else if (tipo == 'o') {
			Integer assentos = Integer.valueOf(lerString("o número de assentos", 0));
			Integer capacidade = Integer.valueOf(lerString("a capacidade total", 0));
			Integer andares = Integer.valueOf(lerString("o número de andares", 0));
			Boolean sanfonado = lerBooleano("O ônibus é sanfonado?");

			veiculo = new Onibus(codigo, marca, modelo, cor, assentos, capacidade, andares, sanfonado);
		}

		return veiculo;
	}

	public static Linha cadastrarLinha() {
		System.out.print("\nDigite um número de linha para cadastrar uma nova linha. Para finalizar, pressione enter: ");
		String numero = leitura.nextLine();

		Integer numeroLinha;
		while (true) {
			try {
				if (numero.isEmpty()) {
					return null;
				}

				numeroLinha = Integer.valueOf(numero);
				break;
			} catch (NumberFormatException e) {
				System.out.print("Valor inválido. Tente novamente ou pressione enter para finalizar: ");
				numero = leitura.nextLine();
			}
		}

		String nomeLinha = lerString("o nome da linha " + numeroLinha, 0);

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

		Linha linha = new Linha(numeroLinha, nomeLinha, pontos);
		return linha;
	}

	static public void alterar() {
		System.out.println(separador("ALTERAR"));

		String cnpj = lerString("o CNPJ da empresa que deseja alterar", 14)
						.substring(0, 14)
						.replaceAll("[^0-9]", "");

		Empresa empresa = null;
		for (Empresa e: bancoEmpresa.listar()) {
			if (e.getCnpj().equals(cnpj)) {
				empresa = e;
				break;
			}
		}

		if (empresa != null) {
			System.out.println(empresa);
			
			String nome = lerString("o nome atualizado da empresa", 0);
			if (!nome.isEmpty()) {
				empresa.setNome(nome);
			}

			Integer opcao = Integer.MAX_VALUE;
			while (opcao != 0) {
				System.out.println("Há " + empresa.getLinhas().size() + " linhas cadastradas para esta empresa.");
				System.out.println("0 • PRÓXIMO");
				System.out.println("1 • CADASTRAR");
				System.out.println("2 • EXCLUIR");

				opcao = lerNumero("a opção desejada");
				switch (opcao) {
					case 0: {
						break;
					}
					case 1: {
						Linha linha = cadastrarLinha();
						if (linha == null) {
							break;
						}
						empresa.addLinha(linha);
						break;
					}
					case 2: {
						System.out.print("\nDigite o número da linha que deseja excluir: ");
						Integer numero = Integer.valueOf(leitura.nextLine());
						if (empresa.excluirLinha(numero)) {
							System.out.println("Linha " + numero + " excluída com sucesso.");
						} else {
							System.out.println("Linha " + numero + " não encontrada.");
						}
						
						break;
					}
				}

				System.out.println(separador(""));
			}

			opcao = Integer.MAX_VALUE;
			while (opcao != 0) {
				System.out.println("Há " + empresa.getFrota().size() + " veículos cadastrados para esta empresa.");
				System.out.println("0 • FINALIZAR");
				System.out.println("1 • CADASTRAR");
				System.out.println("2 • EXCLUIR");

				opcao = lerNumero("a opção desejada");
				switch (opcao) {
					case 0: {
						break;
					}
					case 1: {
						Veiculo veiculo = cadastrarVeiculo();
						if (veiculo == null) {
							break;
						}
						empresa.addVeiculo(veiculo);
						break;
					}
					case 2: {
						System.out.print("\nDigite o código do veículo que deseja excluir: ");
						Integer codigo = Integer.valueOf(leitura.nextLine());
						if (empresa.excluirVeiculo(codigo)) {
							System.out.println("Veículo " + codigo + " excluído com sucesso.");
						} else {
							System.out.println("Veículo " + codigo + " não encontrado.");
						}
						
						break;
					}
				}

				System.out.println(separador(""));
			}
		} else {
			System.out.println("Empresa não encontrada. Verifique o CNPJ e tente novamente.");
		}
		
		bancoEmpresa.alterar(empresa);
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
		ArrayList<Empresa> lista = bancoEmpresa.listar();
		for (Empresa empresa : lista) {
			System.out.println(empresa);
		}
	}

	// Validação
	static String lerString(String nome, Integer digitos) {
		String valor = "";
		while (true) {
			System.out.print("\nDigite " + nome + ": ");
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
		String valor = leitura.nextLine();
		if (valor.isEmpty()) {
			return ' ';
		} else {
			return Character.toLowerCase(valor.charAt(0));
		}
	}

	static Integer lerNumero(String nome) {
		Integer valor = 0;
		while (true) {
			System.out.print("\nDigite " + nome + ": ");
			try {
				valor = Integer.valueOf(leitura.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Valor inválido. Tente novamente.");
			}
		}

		return valor;	
	}

	// Interface
	public static String separador(String title) {
		Integer length = 60;
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

	static public void logo() {
		// Substituir com o caminho do arquivo na máquina
		Path path = Paths.get("/Users/joogps/Desktop/muv/muv/src/visao/logo.txt");

		try {
			String logo = Files.readString(path);
			System.out.println(logo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}