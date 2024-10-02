package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String bd="app_perros";
    private String url="jdbc:mysql://localhost:3306/"+bd;
    private String user="root";
    private String pass="admi123";

    Connection conec=null;

    public Connection conecta() throws SQLException {

        try{
            conec= DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion Ok");
        }catch (SQLException e){
            System.out.println("Error en la conexion: "+e);
        }
        return conec;
    }
}
