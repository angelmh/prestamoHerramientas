package main;
import modelo.*;
import vista.*;
import controlador.BecarioCtrl;
import vista.becario.MBecario;
/**
 *
 * @author Angel
 */
public class Main {
    
    public static void main(String[] args) {
        MBecario vista = new MBecario();
        BecarioDAO modelo = new BecarioDAO();
        BecarioCtrl controlador = new BecarioCtrl(vista, modelo);
                                   
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        
    }
  
}
