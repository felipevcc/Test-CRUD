package Principal;

import Controlador.ControladorEmpleado;
import Modelo.ConsultasEmpleado;
import Modelo.Empleado;
import Vista.frmEmpleado;


public class Principal {
    public static void main(String[] args) {
        Empleado mod=new Empleado();
        ConsultasEmpleado modC=new ConsultasEmpleado();
        frmEmpleado frm=new frmEmpleado();
        ControladorEmpleado crtl=new ControladorEmpleado(mod,modC,frm);
        crtl.iniciar();
        frm.setVisible(true);
    }
}
