package modelo;

import java.util.ArrayList;

public interface IEmpresaDAO {

	public Boolean inserir(Empresa e);

	public Boolean alterar(Empresa e);

	public Boolean excluir(String cnpj);

	public ArrayList<Empresa> listar();

}
