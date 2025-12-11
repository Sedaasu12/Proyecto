package Models;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Beans.prestamosBeans;
import Utils.conexion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class prestamosModels extends conexion{
	
	ResultSet rs;
	CallableStatement cs;
	Statement st;
	public List<prestamosBeans> listarPrestamos(){
		ArrayList<prestamosBeans> prestamos = new ArrayList<>();
		String sql = "call sp_listarPrestamos()";
		this.abrirConexion();
		
		try {
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();

			while (rs.next()) {
			    prestamosBeans ct = new prestamosBeans();
				ct.setIdPrestamo(rs.getInt("id_prestamo"));
				ct.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				ct.setMonto(rs.getDouble("monto"));
				ct.setInteres(rs.getDouble("interes"));
				ct.setNumeroCuotas(rs.getInt("numero_cuotas"));
				ct.setNombreCliente(rs.getString("nombre_cliente"));

				
				prestamos.add(ct);
			}

			this.cerrarConexion();
			return prestamos;
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return null;
		}
		
	  }
	
	public int insertarPrestamos(prestamosBeans prestamo) {
        try {
            int filasAfectadas = 0;
            String sql = "CALL sp_agregarPrestamos(?,?,?,?,?)";
            
            this.abrirConexion();
            cs = conexion.prepareCall(sql);
            cs.setDate(1, prestamo.getFechaPrestamo());
            cs.setDouble(2, prestamo.getMonto());
            cs.setDouble(3, prestamo.getInteres());
            cs.setInt(4, prestamo.getNumeroCuotas());
            cs.setInt(5, prestamo.getIdCliente());
            
            filasAfectadas = cs.executeUpdate();
            this.cerrarConexion();
            return filasAfectadas;
            
        } catch (SQLException e) {
            e.printStackTrace();
            this.cerrarConexion();
            return 0;
        }
    }
	
	public int eliminarPrestamo(int id) {
        try {
            int filasAfectadas = 0;
            String sql = "CALL sp_eliminarPrestamo(?)";
            this.abrirConexion();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, id);
            filasAfectadas = cs.executeUpdate();
            
            this.cerrarConexion();
            return filasAfectadas;
            
        } catch (SQLException e) {
            e.printStackTrace();
            this.cerrarConexion();
            return 0;
        }
    }
	
	 
	 

}
