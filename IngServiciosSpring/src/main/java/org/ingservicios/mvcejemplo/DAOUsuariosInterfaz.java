package org.ingservicios.mvcejemplo;

import java.util.List;


public interface DAOUsuariosInterfaz {

	public List<DTOUsuarios> leeUsuarios();
	
	public void addUsuario(DTOUsuarios usuario);
	
	public DTOUsuarios buscaAdmin(String nombre, String password);
	
	public DTOUsuarios buscaUsuario(String id);
	
	public boolean buscaUsuario(String nombre, String email, String dni);
	
	public DTOUsuarios buscaUsuario(String nombre, String contrase�a);
}