package Controlador;

import Modelo.ConsultasEmpleado;
import Modelo.Empleado;
import Vista.frmEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorEmpleado implements ActionListener {

    private Empleado mod;
    private ConsultasEmpleado modC;
    private frmEmpleado frm;

    public ControladorEmpleado(Empleado mod, ConsultasEmpleado modC, frmEmpleado frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);

    }

    //Método para iniciar la vista
    public void iniciar() {
        frm.setTitle("Empleados");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    //Métodos de escucha a los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        //***----------Boton guardar
        if (e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setDomicilio(frm.txtDomicilio.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            mod.setCorreo_electronico(frm.txtCorreo.getText());
            mod.setSalario(Double.parseDouble(frm.txtSalario.getText()));

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        //***----------Boton modificar
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setDomicilio(frm.txtDomicilio.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            mod.setCorreo_electronico(frm.txtCorreo.getText());
            mod.setSalario(Double.parseDouble(frm.txtSalario.getText()));

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        //***----------Boton eliminar
        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Elliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        //***----------Boton buscar
        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());
            if (modC.buscar(mod)) {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtDomicilio.setText(mod.getDomicilio());
                frm.txtTelefono.setText(mod.getTelefono());
                frm.txtCorreo.setText(mod.getCorreo_electronico());
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtSalario.setText(String.valueOf(mod.getSalario()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            }
        }
        //***----------Boton limpiar
          if (e.getSource() == frm.btnLimpiar)
          {
             limpiar();
          }
    }

    //Limpiar el formulario
    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtDomicilio.setText(null);
        frm.txtTelefono.setText(null);
        frm.txtCorreo.setText(null);
        frm.txtSalario.setText(null);

    }

}
