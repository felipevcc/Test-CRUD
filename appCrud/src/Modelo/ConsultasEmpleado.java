package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ConsultasEmpleado extends Conexion {

    public boolean registrar(Empleado emp) {
        PreparedStatement ps = null;
        Connection con=getConexion();

        String sql="INSERT INTO  empleado (codigo,nombre,domicilio,telefono,"
                + "correo_electronico,salario) VALUES (?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getCodigo());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getDomicilio());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo_electronico());
            ps.setDouble(6, emp.getSalario());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
            
    }

    public boolean modificar (Empleado emp) {
        PreparedStatement ps = null;
        Connection con=getConexion();

        String sql="UPDATE   empleado SET codigo=?, nombre=?, domicilio=?,telefono=?,"
                + "correo_electronico=?,salario=? where id=? ";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getCodigo());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getDomicilio());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo_electronico());
            ps.setDouble(6, emp.getSalario());
            ps.setInt(7, emp.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
            
    }

    public boolean eliminar (Empleado emp) {
        PreparedStatement ps = null;
        Connection con=getConexion();

        String sql="DELETE FROM   empleado  WHERE id=? ";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, emp.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Empleado emp) {
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con=getConexion();

        String sql="SELECT *  FROM   empleado  WHERE codigo=? ";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getCodigo());
            rs=ps.executeQuery();
            if(rs.next())
            {
                emp.setId(Integer.parseInt(rs.getString("id")));
                emp.setCodigo(rs.getString("codigo"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDomicilio(rs.getString("domicilio"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setCorreo_electronico(rs.getString("correo_electronico"));
                emp.setSalario(rs.getDouble("salario"));
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
