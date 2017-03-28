package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.*;
import vista.becario.MBecario;

/**
 *
 * @author Angel
 */
public class BecarioCtrl implements ActionListener{
    MBecario becarioVista = new MBecario();
    BecarioDAO becarioModel = new BecarioDAO();
    
    public BecarioCtrl(MBecario becarioVista, BecarioDAO becarioModel)
    {
        this.becarioModel = becarioModel;
        this.becarioVista = becarioVista;
        this.becarioVista.btnRegistrar.addActionListener(this);
        this.becarioVista.btnListar.addActionListener(this);
        LlenarTabla(this.becarioVista.jTable1);
     
    }
    
    
    public void LlenarTabla(JTable tabla)
    {
       DefaultTableModel modeloT = new DefaultTableModel();
       tabla.setModel(modeloT);
    
       modeloT.addColumn("Matricula");
       modeloT.addColumn("Nombre");
       modeloT.addColumn("Apellido Paterno");
       modeloT.addColumn("Apellido Materno");
       modeloT.addColumn("Carrera");
       modeloT.addColumn("Horario E");
       modeloT.addColumn("Horario S");
       modeloT.addColumn("Estatus");
       
       Object [] columna = new Object[8];
       int numRegistros = becarioModel.listBecarios().size();
       
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = becarioModel.listBecarios().get(i).getMatricula();
            columna[1] = becarioModel.listBecarios().get(i).getNombre();
            columna[2] = becarioModel.listBecarios().get(i).getApellidoP();
            columna[3] = becarioModel.listBecarios().get(i).getApellidoM();
            columna[4] = becarioModel.listBecarios().get(i).getCarrera();
            columna[5] = becarioModel.listBecarios().get(i).getMatricula();
            columna[6] = becarioModel.listBecarios().get(i).getHorarioE();
            columna[7] = becarioModel.listBecarios().get(i).getHorarioS();
            modeloT.addRow(columna);
        }
    }
    
   
    public void WindowEvent(WindowEvent e)
    {
        if (e.getSource() == becarioVista.getWindowListeners()) {
            JOptionPane.showMessageDialog(null,"Cerrando.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource() == becarioVista.btnRegistrar) {
            int rspRegistro = becarioModel.insertarBecario(becarioVista.txtNombre.getText(), 
            becarioVista.txtPaterno.getText(), becarioVista.txtMaterno.getText(), 
            0, Integer.parseInt(becarioVista.txtMatricula.getText()), becarioVista.txtCarrera.getText(), 
            becarioVista.txtHorarioE.getText(), becarioVista.txtHorarioS.getText(), 
            Boolean.parseBoolean( becarioVista.txtEstatus.getText() )  );
        
            if (rspRegistro !=0 ) 
            {
                JOptionPane.showMessageDialog(null,rspRegistro);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Registro Erroneo.");
            }
        }
    }
    
}
