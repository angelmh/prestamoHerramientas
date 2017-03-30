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
    
    public int actualizarBecario(String nombre,String aPaterno, String aMaterno, int edad,
            int matricula,String carrera, String horarioE, String horarioS, boolean estatus)
    {
        int rsp=0;
        try
        {
            conexion = new Conexion(); cnn = conexion.conectar();
            st = cnn.createStatement();
           
            String sql = "UPDATE becario SET "
                           + "nombre_becario='" + nombre   +"', "
                           + "apelldop_becario='" + aPaterno+"', "
                           + "apelldom_becario='" + aMaterno+"', "
                           + "carrera_becario='" + carrera   +"', "
                           + "horarioe_becario='" + horarioE  +"', "
                           + "horarios_becario='" + horarioS +"', "
                           + "status='" + estatus +"' "
                           + "WHERE id_becario="+matricula+";";
            System.out.println(sql);              
            rsp = st.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error al actualizar, posible problema de red o bd: "+e);
        }
        
        return rsp;   
    }
    
    public int eliminarBecario(int id_becario)
    {
     int rsp=0;
        try
        {
            conexion = new Conexion(); cnn = conexion.conectar();
            st = cnn.createStatement();
           
            System.out.println("("+id_becario+")");
            String sql = "DELETE FROM becario "
                       + "WHERE id_becario="+id_becario+";";
            System.out.println(sql);
            rsp = st.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error al actualizar, posible problema de red o bd: "+e);
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
           
           PreparedStatement p = cnn.prepareStatement("SELECT * FROM becario "
                   + "order by id_becario;");
           rs = p.executeQuery();
           
           while( rs.next() )
           {
                System.out.println("Nombre:"+rs.getString("nombre_becario"));
                    becario = new Becario(rs.getString("nombre_becario"), 
                                    rs.getString("apelldop_becario"),
                                    rs.getString("apelldom_becario"), 0,
                                    rs.getInt("id_becario"),
                                    rs.getString("carrera_becario"), 
                                    rs.getString("horarioe_becario"), 
                                    rs.getString("horarios_becario"),
                                    rs.getBoolean("status")    
            );
            
            
            listaBecario.add(becario);
           }
        }
        catch(Exception e){
               System.out.println(":"+e);
        }
        return listaBecario;
    }
    
    public ArrayList<Becario> listBecario(int id_becario)
    {
        ArrayList listaBecario = new ArrayList();
        Becario becario;
        try
        {
           conexion = new Conexion();
           cnn = conexion.conectar();
           
           PreparedStatement p = cnn.prepareStatement("SELECT * FROM becario "
                                                    + "WHERE id_becario="+id_becario);
           rs = p.executeQuery();
           
           while( rs.next() )
           {
                becario = new Becario(rs.getString("nombre_becario"), 
                                    rs.getString("apelldop_becario"),
                                    rs.getString("apelldom_becario"), 0,
                                    rs.getInt("id_becario"),
                                    rs.getString("carrera_becario"), 
                                    rs.getString("horarioe_becario"), 
                                    rs.getString("horarios_becario"),
                                    rs.getBoolean("status")
                );
                listaBecario.add(becario);
           }
        }
        catch(Exception e){
               System.out.println(":"+e);
        }
        return listaBecario;
    }
    
}
