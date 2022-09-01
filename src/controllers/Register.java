package controllers;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;



public class Register{
	
	Conexion con = new Conexion();
	
	public void registrarse(String inpId,String inpName,String inpLastName,String inpEmail,String inpPassword,String inpAge) throws SQLException{
		
		

		if(inpId==null || inpId.isEmpty())
	        System.out.println("Debe ingresar una Identificacion valida");
	    else if(inpName==null || inpName.isEmpty())
	    	System.out.println("Debe ingresar un Nombre valido");
	    else if(inpLastName==null || inpLastName.isEmpty())
	    	System.out.println("Debe ingresar un Apellido valido");
	    else if(inpEmail==null || inpEmail.isEmpty())
	    	System.out.println("Debe ingresar un Email valido");
	    else if(inpPassword==null || inpPassword.isEmpty())
	    	System.out.println("Debe ingresar un Contrase�a valida");
	    else if(inpAge==null || inpAge.isEmpty())
	    	System.out.println("Debe ingresar una Edad valida");
	    else {
	    	
			String query = "INSERT into personas (id,nombre,apellido,email,edad,pw) values ('"+inpId+"','"+inpName+"','"+inpLastName+"','"+inpEmail+"','"+inpAge+"','"+inpPassword+"')";
			con.conectar();
			Answer(query);
			
            con.desconectar();
	    }
		
	}
		
	public void Answer(String query){
			try (Statement stm = con.getCon().createStatement()){
		         int rest = stm.executeUpdate(query);
		         if(rest != 0){
		        	 	System.out.println("Datos Registrados con exito");
		            }
		            else{
		            	System.out.println("Error al grabar los datos por favor verifique");
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        con.desconectar();
		        
		        
			} 
		
		
		
	    
}
