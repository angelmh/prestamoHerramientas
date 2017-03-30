package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.*;
import vista.becario.MBecario;

/**
 *
 * @author Angel
 */
public class BecarioCtrl implements ActionListener, KeyListener{
    MBecario becarioVista = new MBecario();
    BecarioDAO becarioModel = new BecarioDAO();
    
    public BecarioCtrl(MBecario becarioVista, BecarioDAO becarioModel)
    {
        this.becarioModel = becarioModel;
        this.becarioVista = becarioVista;
        this.becarioVista.btnRegistrar.addActionListener(this);
        this.becarioVista.btnActualizar.addActionListener(this);
        this.becarioVista.btnEliminar.addActionListener(this);
        this.becarioVista.txtBuscarBecario.addKeyListener(this);
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
       
       for(Becario a : becarioModel.listBecarios())
       {
            columna[0] = a.getMatricula();
            columna[1] = a.getNombre();
            columna[2] = a.getApellidoP();
            columna[3] = a.getApellidoM();
            columna[4] = a.getCarrera();
            columna[5] = a.getMatricula();
            columna[6] = a.getHorarioE();
            columna[7] = a.getHorarioS();
            modeloT.addRow(columna);
       }
       
      
    }
    
    public void limpiarTabla()
    {
        DefaultTableModel model = (DefaultTableModel)this.becarioVista.jTable1.getModel();
        model.setRowCount(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()== becarioVista.btnRegistrar) 
            registrar();
        else if(e.getSource() == becarioVista.btnActualizar) 
            actualizar();
        else if(e.getSource() == becarioVista.btnEliminar ) 
                if( !becarioVista.txtBuscarBecario.isEnabled() ) 
                    eliminar();
    }
    
    public void registrar()
    {
        int rspRegistro = becarioModel.insertarBecario(becarioVista.txtNombre.getText(), 
        becarioVista.txtPaterno.getText(), becarioVista.txtMaterno.getText(), 
        0, Integer.parseInt(becarioVista.txtMatricula.getText()), becarioVista.txtCarrera.getText(), 
        becarioVista.txtHorarioE.getText(), becarioVista.txtHorarioS.getText(), 
        Boolean.parseBoolean( becarioVista.txtEstatus.getText() )  );

        if (rspRegistro !=0 ) 
        {
            JOptionPane.showMessageDialog(null,"Registrado correctamente.");
            limpiarTabla();
            LlenarTabla(this.becarioVista.jTable1);   
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Registro Erroneo.");
        }
    }
    
    public void actualizar()
    {
        int rspRegistro = becarioModel.actualizarBecario(becarioVista.txtNombre.getText(), 
        becarioVista.txtPaterno.getText(), becarioVista.txtMaterno.getText(), 
        0, Integer.parseInt(becarioVista.txtMatricula.getText()), becarioVista.txtCarrera.getText(), 
        becarioVista.txtHorarioE.getText(), becarioVista.txtHorarioS.getText(), 
        Boolean.parseBoolean( becarioVista.txtEstatus.getText() )  );

        if (rspRegistro !=0 ) 
        {
            JOptionPane.showMessageDialog(null,"Registrado actualizado correctamente.");
            limpiarTabla();
            LlenarTabla(this.becarioVista.jTable1);   
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Registro Erroneo.");
        }
    }
    
    public void eliminar()
    {
        int rspRegistro = becarioModel.eliminarBecario(
                          Integer.parseInt(becarioVista.txtBuscarBecario.getText())
        );

        if (rspRegistro !=0 ) 
        {
            JOptionPane.showMessageDialog(null,"Registrado eliminado correctamente.");
            limpiarTabla();
            LlenarTabla(this.becarioVista.jTable1);   
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Registro Erroneo.");
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) 
    {
        if (e.getSource() == becarioVista.txtBuscarBecario) 
        {
            if (e.getKeyCode() == 13 || e.getKeyCode()==10) 
            {
                becarioVista.txtBuscarBecario.setEnabled(false);
                //Buscar el becario
                for(Becario a : becarioModel.listBecario( 
                       Integer.parseInt(becarioVista.txtBuscarBecario.getText()) ) )
                {
                         becarioVista.txtMatricula.setText(""+a.getMatricula());
                         becarioVista.txtNombre.setText(a.getNombre());
                         becarioVista.txtPaterno.setText(a.getApellidoP());
                         becarioVista.txtMaterno.setText(a.getApellidoM());
                         becarioVista.txtCarrera.setText(a.getCarrera());
                         becarioVista.txtHorarioE.setText(a.getHorarioE());
                         becarioVista.txtHorarioS.setText(a.getHorarioS());
                         becarioVista.txtEstatus.setText(""+a.isEstatus());
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}
    
}
   
    