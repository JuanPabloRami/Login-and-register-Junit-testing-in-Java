package controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Conexion;


public class Login {
	
	

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    
    
    public boolean loguearse(String login,String clave) throws SQLException{
        
        Conexion conect = new Conexion();
        conect.conectar();
        if(conect.isConectado()){
            String query = "SELECT id FROM personas WHERE email ='"+login+"'AND pw = '"+clave+"'";
            try(Statement stm = conect.getCon().createStatement()){        
                ResultSet rst = stm.executeQuery(query);
                
                if(rst.next()){
                    System.out.println("inicio de sesion exitoso de APRENDIZ");
                    conect.desconectar();
                    return true;
                }else{
                    System.out.println("Usuario o Clave no validos");
                    return false;
                    
                }
            }catch (Exception e) {
                System.out.println("ERROR: Aborting...");
                e.printStackTrace();
                return false;
            }
        }
       return false;
    }
}