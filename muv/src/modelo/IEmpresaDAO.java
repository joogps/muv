package modelo;

import java.util.ArrayList;

public interface IEmpresaDAO {

	public boolean inserir(Empresa emp);

	public boolean alterar(Empresa emp);

	public boolean excluir(Empresa emp);

	public ArrayList<Empresa> listarEmpresas();

}
