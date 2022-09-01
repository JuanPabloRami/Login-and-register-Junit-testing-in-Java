package tests;

import java.sql.SQLException;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Statement;

import modelo.Conexion;

import org.junit.jupiter.api.Test;

import controllers.Register;


public class Register_Test{
	
	@Test
	public void test() throws SQLException {
		
		//el registro se hará con estos datos
		String id = "11";
		String nombre = "juan pablo";
		String apellido = "rami";
		String email = "juan@juan.com";
		String pw = "1234";
		String edad = "19";
		
		Register registro = new Register();
		
		//se realiza el registro
		registro.registrarse(id, nombre, apellido, email, pw, edad);
		
		//se realiza la conexion a la base de datos
		Conexion conect = new Conexion();
		conect.conectar();
		
		if(conect.isConectado()){
			String query = "SELECT * FROM personas WHERE id = '"+id+"' AND  nombre = '"+nombre+"' AND apellido = '"+apellido+"' AND email = '"+email+"' AND pw = '"+pw+"' AND edad = '"+edad+"'";
			
			try  (Statement stm = conect.getCon().createStatement()){
				
				System.out.println("se metio al try");
				//se ejecuta la consulta el resultado se guarda en el resultset
				ResultSet rst = stm.executeQuery(query);
				
				//aca se realiza la prueba de si el usuario existe en la base de datos comprobando asi que el usuario se registró exitosamente
				assertEquals(true,rst.next());
				
			}catch (Exception e) {
	            System.out.println("ERROR: Aborting...");
	            e.printStackTrace();
	        }
		}
	}
}

