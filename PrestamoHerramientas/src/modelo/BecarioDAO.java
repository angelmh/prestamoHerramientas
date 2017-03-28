package modelo;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class BecarioDAO {
    Conexion conexion;
    static Connection cnn  = null;
    static Statement  st   = null;
    static ResultSet  rs   = null;
    
    public int insertarBecario(String nombre,String aPaterno, String aMaterno, int edad,
            int matricula,String carrera, String horarioE, String horarioS, boolean estatus)
    {
        int rsp=0;
        try
        {
            conexion = new Conexion(); cnn = conexion.conectar();
            st= cnn.createStatement();
           
            String sql = "INSERT INTO becario "
                           + "VALUES("+  matricula  +", "
                           + "'" + nombre   +"', "
                           + "'" + aPaterno+"', "
                           + "'" + aMaterno+"', "
                           + "'" + carrera   +"', "
                           + "'" + horarioE  +"', "
                           + "'" + horarioS +"', "
                           + "'" + true +"' "
                           + "); ";
            System.out.println(sql);              
            rsp = st.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error Al Guardar, posible problema de red o bd: "+e);
        }
        
        return rsp;   
    }
    
    public ArrayList<Becario> listBecarios()
    {
        ArrayList listaBecario = new ArrayList();
        Becario becario;
        try
        {
           conexion = new Conexion();
           cnn = conexion.conectar();
           
           PreparedStatement p = cnn.prepareStatement("SELECT * FROM becario;");
           rs = p.executeQuery();
           
           while( rs.next() )
           {
           
            becario = new Becario(rs.getString("nombre_becario"), 
                                    rs.getString("apelldop_becario"),
                                    rs.getString("apelldom_becario"), 0,
                                    rs.getInt("id_becario"),
                                    rs.getString("carrera_becario"), 
                                    rs.getString("horarioe_becario"), 
                                    rs.getString("horarios_becario"));
            becario.setNombre( rs.getString("nombre_becario") );
            
            listaBecario.add(becario);
           }
        }
        catch(Exception e){
               System.out.println(":"+e);
        }
        return listaBecario;
    }
}
