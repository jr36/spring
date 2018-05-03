package org.ingservicios.mvcejemplo;


import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//Indica que el bean es un dao
@Repository
public class DAOUsuarios implements DAOUsuariosInterfaz {
	//A�adir libreria spring-jdbc y dependencia junto a la versi�n
	public JdbcTemplate jdbcTemplate;
	//private DataSource dataSource;
	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
		public List<DTOUsuarios> leeUsuarios(){
			String sql = "select * from usuarios";
			UsuarioMapper mapper = new UsuarioMapper();
			List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql,mapper);
			return usuarios;
		}
		
		public DTOUsuarios buscaAdmin(String nombre, String contrase�a){ //Devuelve el usuario buscado o null si no existe
			if(nombre.equals("Admin") && contrase�a.equals("12345")) {
			String sql = "select * from usuarios where Nombre = ? AND Password = ?";
			Object[ ] parametros = {nombre, contrase�a}; //Array de objetos
			UsuarioMapper mapper = new UsuarioMapper();
			List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
			if (usuarios.isEmpty()) return null;
			else return usuarios.get(0);
			}else {
				return null;
			}
			}
		
		
		public DTOUsuarios buscaUsuario(String id){ //Devuelve el usuario buscado o null si no existe
			String sql = "select * from usuarios where DNI = ?";
			Object[ ] parametros = {id}; //Array de objetos
			UsuarioMapper mapper = new UsuarioMapper();
			List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
			if (usuarios.isEmpty()) return null;
			else return usuarios.get(0);
			}
		
		
		public DTOUsuarios buscaUsuario(String nombre, String contrase�a){ //Devuelve el usuario buscado o null si no existe
			String sql = "select * from usuarios where Nombre = ? AND Password = ?";
			Object[ ] parametros = {nombre,contrase�a}; //Array de objetos
			UsuarioMapper mapper = new UsuarioMapper();
			List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
			if (usuarios.isEmpty()) return null;
			else return usuarios.get(0);
			}
		
		public boolean buscaUsuario(String nombre, String email, String dni){ 
			String sql = "SELECT * FROM usuarios WHERE Nombre= ? AND Email = ? AND DNI = ?";
			Object[ ] parametros = {nombre,email,dni}; //Array de objetos
			UsuarioMapper mapper = new UsuarioMapper();
			List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
			if (usuarios.isEmpty()) return false;
			else return true;
			}
		
		//A�adir usuario, en jdbcTemplate se utiliza ??
		public void addUsuario(DTOUsuarios usuario) {			
			String sql = "insert into usuarios values(?,?,?,?)";
			Object[ ] parametros = {usuario.getNombre(),usuario.getPassword(), usuario.getEmail(), 
					usuario.getDni()}; //Array de objetos
			//Para operaciones INSERT, UPDATE o DELETE se usa el m�todo jdbcTemplate.update
			this.jdbcTemplate.update(sql,parametros);
		}
		
		
}

