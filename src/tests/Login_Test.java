package tests;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import modelo.Conexion;

import org.junit.jupiter.api.Test;

import controllers.Login;


public class Login_Test{
	
	@Test
	public void test() throws SQLException {
		
		//con estos datos intentará iniciar sesion
		String email = "juan@juan.com";
		String pw = "1234";
		
		
		
		Login logueo = new Login();
		//procederá a loguearse en el sistema
		
		boolean seLogueo =  logueo.loguearse(email, pw);
		
		
		Conexion conect = new Conexion();
		conect.conectar();
		
		
		//aca se realiza la prueba de si el usuario pudo loguearse correctamente
		assertEquals(true,seLogueo);
	}
}