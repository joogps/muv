package visao;

import java.util.ArrayList;
import java.util.Scanner;

import controle.EmpresaDAO;
import modelo.Coordenadas;
import modelo.Empresa;
import modelo.Linha;
import modelo.Ponto;

public class MainMuv {

	public static void main(String[] args) {
		ArrayList<Ponto> pontos = new ArrayList<>();
		pontos.add(new Ponto(new Coordenadas(0, 0), false));
		pontos.add(new Ponto(new Coordenadas(10, 10), false));

		Linha linha = new Linha("Linha 1", pontos);

		System.out.println(linha.distanciaAbsoluta());

		Integer opcaoSelecionada = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		EmpresaDAO bancoEmpresa = EmpresaDAO.getInstancia();
		while (opcaoSelecionada != 0) {

			System.out.println("- MENU EXEMPLO -");
			System.out.println("0 SAIR");
			System.out.println("1 CADASTRAR");
			System.out.println("2 ALTERAR");
			System.out.println("3 EXCLUIR");
			System.out.println("4 LISTAR");
			opcaoSelecionada = Integer.valueOf(leitura.nextLine());

			switch (opcaoSelecionada) {
			case 0: {
				break;
			}
			
			
			case 1: {
				Empresa empresa = new Empresa();
				System.out.println("Nome:");
				String nome = leitura.nextLine();
				// fazer validacao
				System.out.println("Cnpj:");
				String cnpj = leitura.nextLine();

				// fazer validacao
				empresa.setNome(nome);

				/**
				 * Exemplo de validacao
				 * 
				 */
				if (!cnpj.isEmpty()) {
					empresa.setCnpj(cnpj);
				} else {
					System.out.println("Erro");
				}

				boolean valida = bancoEmpresa.inserir(empresa);
				if (valida == true) {
					System.out.println("Cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar!");
				}
				break;
			}
				
			case 2: {
				System.out.println("Digite o codigo da pessoa que deseja alterar:");
				// finalizar codigo
				break;
			}
			case 3: {
				System.out.println("Digite o codigo da pessoa que deseja excluir:");
				boolean excluir = bancoEmpresa.inserir(Excluir); //excluir e arrumar o excluir
				if(excluir == true) {
					System.out.println("Excluido com sucesso");
				} else {
					System.out.println("Erro ao excluir");
				}
				
				
				break;
			}
			case 4: {
				ArrayList<Empresa> lista = bancoEmpresa.listarEmpresas();
				for (Empresa empresa : lista) {

					// TODO fazer a sobrescrita do toString na classe Empresa
					System.out.println(empresa);
				}

				break;
			}

			}

		}

		leitura.close();

	}

}
