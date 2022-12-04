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
import modelo.Ponto;

public class MainMuv {

	public static void main(String[] args) {
		Integer opcaoSelecionada = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		EmpresaDAO bancoEmpresa = EmpresaDAO.getInstancia();

		var path = Paths.get("/Users/joogps/Desktop/muv/muv/src/visao/banner.txt");
		System.out.println(path);
		try {
			String logo = Files.readString(path);
			System.out.println(logo);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (opcaoSelecionada != 0) {
			System.out.println(separador("MENU PRINCIPAL"));
			System.out.println("0 • SAIR");
			System.out.println("1 • CADASTRAR");
			System.out.println("2 • ALTERAR");
			System.out.println("3 • EXCLUIR");
			System.out.println("4 • LISTAR");

			System.out.println(separador(""));

			opcaoSelecionada = Integer.valueOf(leitura.nextLine());

			switch (opcaoSelecionada) {
			case 0: {
				break;
			}
			
			case 1: {
				Empresa empresa = new Empresa();
				
				String nome = "";
				while (true) {
					System.out.println("Digite o nome da empresa:");
					nome = leitura.nextLine();
					
					if (nome.isEmpty()) {
						System.out.println("O nome não pode ser vazio. Tente novamente.");
					} else {
						break;
					}
				}

				String cnpj = "";
				while (true) {
					System.out.println("Digite o CNPJ da empresa:");
					cnpj = leitura.nextLine();
					
					if (cnpj.isEmpty()) {
						System.out.println("O CNPJ não pode ser vazio. Tente novamente.");
					} else if (cnpj.length() != 14) {
						System.out.println("O CNPJ deve conter 14 dígitos. Tente novamente.");
					} else {
						break;
					}
				}

				empresa.setNome(nome);
				empresa.setCnpj(cnpj);

				String nomeLinha = "";

				while (true) {
					System.out.println("Digite o nome da linha para cadastrar uma nova. Para finalizar, pressione enter.");
					nomeLinha = leitura.nextLine();

					if (nomeLinha.isEmpty()) {
						break;
					} else {
						ArrayList<Ponto> pontos = new ArrayList<>();
						String latitudePonto = "";
						String longitudePonto = "";

						while (true) {
							System.out.println("Você quer cadastrar um novo ponto? (s/n)");
							String resposta = leitura.nextLine();

							if (resposta.equals("s")) {
								while (true) {
									System.out.println("Digite a latitude do ponto:");
									latitudePonto = leitura.nextLine();

									if (latitudePonto.isEmpty()) {
										System.out.println("A latitude não pode ser vazia. Tente novamente.");
									} else {
										break;
									}
								}

								while (true) {
									System.out.println("Digite a longitude do ponto:");
									longitudePonto = leitura.nextLine();

									if (longitudePonto.isEmpty()) {
										System.out.println("A longitude não pode ser vazia. Tente novamente.");
									} else {
										break;
									}
								}

								System.out.println("O ponto é coberto? (s/n)");
								Boolean coberto = leitura.nextLine() == "s";
								Coordenadas coordenadas = new Coordenadas(Float.valueOf(latitudePonto), Float.valueOf(longitudePonto));
								Ponto ponto = new Ponto(coordenadas, coberto);
								pontos.add(ponto);
							} else {
								break;
							}
						}


						Linha linha = new Linha(nomeLinha, pontos);
						empresa.addLinha(linha);
					}
				}

				boolean valida = bancoEmpresa.inserir(empresa);
				if (valida == true) {
					System.out.println("Cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar a empresa.");
				}
				break;
			}
				
			case 2: {
				System.out.println("Digite o CNPJ da empresa que deseja alterar:");
				
				break;
			}
			case 3: {
				System.out.println("Digite o CNPJ da empresa que deseja excluir:");
				String cnpj = leitura.nextLine();

				boolean excluir = bancoEmpresa.excluir(cnpj);
				if(excluir == true) {
					System.out.println("Excluido com sucesso");
				} else {
					System.out.println("Erro ao excluir");
				}
				
				break;
			}
			case 4: {
				listar();

				break;
			}

			}

		}

		leitura.close();

	}

	static public void listar() {
		EmpresaDAO bancoEmpresa = EmpresaDAO.getInstancia();

		System.out.println(separador("EMPRESAS"));
		ArrayList<Empresa> lista = bancoEmpresa.listarEmpresas();
		for (Empresa empresa : lista) {
			System.out.println(empresa);
		}
		System.out.println(separador(""));
	}

	static String separador(String title) {
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