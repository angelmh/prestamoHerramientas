package modelo;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
class Conexion {
    static Connection conexion = null;
    static Statement  statement = null;
    static ResultSet  resultset = null;
    static String usuario =  "postgres";
    static String url =      "jdbc:postgresql://192.168.1.79:5432/bdprestamo";
    static String password = "motor";
   
    public Connection conectar() 
    {
        try {
                Class.forName("org.postgresql.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
        }catch (SQLException ex) {
                conexion= null;
        }catch(ClassNotFoundException e){
                System.out.println(e);
        }catch(Exception e){
               System.out.println("::"+e);
        }
        return conexion;
    }
    
    public void desconectar() 
    {
        if (conexion!=null) 
        {
            conexion = null;
        }
    }
}
