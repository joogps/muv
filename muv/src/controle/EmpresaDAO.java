package controle;

import java.util.ArrayList;

import modelo.Empresa;
import modelo.IEmpresaDAO;

public class EmpresaDAO implements IEmpresaDAO {

	private static ArrayList<Empresa> tabelaEmpresas;
	private static EmpresaDAO instancia;

	private EmpresaDAO() {
	}

	public static EmpresaDAO getInstancia() {

		if (instancia == null) {
			instancia = new EmpresaDAO();
			tabelaEmpresas = new ArrayList<>();
		}

		return instancia;
	}

	@Override
	public boolean inserir(Empresa emp) {
		if (emp != null) {
			tabelaEmpresas.add(emp);
			return true;
		}
		return false;
	}

	@Override
	public boolean alterar(Empresa e) {
		for (Empresa empresa : tabelaEmpresas) {
			if (empresa.getCnpj() == e.getCnpj()) {
				empresa.setFrota(e.getFrota());
				empresa.setNome(e.getNome());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean excluir(String cnpj) {
		for (Empresa empresa : tabelaEmpresas) {
			if (empresa.getCnpj() == cnpj) {
				tabelaEmpresas.remove(empresa);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Empresa> listarEmpresas() {
		return tabelaEmpresas;
	}

}
