package controle;

import java.util.ArrayList;

import modelo.Empresa;
import modelo.IEmpresaDAO;

public class EmpresaDAO implements IEmpresaDAO {

	private static ArrayList<Empresa> empresas;
	private static EmpresaDAO instancia;

	private EmpresaDAO() {
	}

	public static EmpresaDAO getInstancia() {

		if (instancia == null) {
			instancia = new EmpresaDAO();
			empresas = new ArrayList<>();
		}

		return instancia;
	}

	@Override
	public Boolean inserir(Empresa e) {
		if (e != null) {
			empresas.add(e);
			return true;
		}
		return false;
	}

	@Override
	public Boolean alterar(Empresa e) {
		for (Empresa empresa : empresas) {
			if (empresa.getCnpj().equals(e.getCnpj())) {
				empresa.setNome(e.getNome());
				empresa.setLinhas(e.getLinhas());
				empresa.setFrota(e.getFrota());
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean excluir(String cnpj) {
		for (Empresa empresa : empresas) {
			if (empresa.getCnpj().equals(cnpj)) {
				empresas.remove(empresa);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Empresa> listar() {
		return empresas;
	}

}
