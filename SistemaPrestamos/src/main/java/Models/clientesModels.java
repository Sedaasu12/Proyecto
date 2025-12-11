package Models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Beans.clientesBeans;
import Utils.conexion;



public class clientesModels extends conexion{
	ResultSet rs;
	CallableStatement cs;
	Statement st;
	public List<clientesBeans> listarClientes(){
		ArrayList<clientesBeans> clientes = new ArrayList<>();
		String sql = "call sp_listarCleintes()";
		this.abrirConexion();
		
		try {
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();

			while (rs.next()) {
			    clientesBeans ct = new clientesBeans();
				ct.setId_clientes(rs.getInt("id_cliente"));
				ct.setNombres(rs.getString("nombres"));
				ct.setApellidos(rs.getString("apellidos"));
				ct.setDni(rs.getString("dni"));
				ct.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				ct.setDireccion(rs.getNString("direccion"));
				
				clientes.add(ct);
			}

			this.cerrarConexion();
			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return null;
		}
		
	  }
	
	public int insertarClientes(clientesBeans clientes_) {

		try {
			int filasAfectadas = 0;

			String sql = "CALL sp_agregarClientes(?,?,?,?,?)";
			this.abrirConexion();

			cs = conexion.prepareCall(sql);

			
			cs.setString(1, clientes_.getNombres());
	        cs.setString(2, clientes_.getApellidos());
	        cs.setString(3, clientes_.getDni());
	        cs.setDate(4, clientes_.getFecha_nacimiento());
	        cs.setString(5, clientes_.getDireccion());
	        
			filasAfectadas = cs.executeUpdate();

			return filasAfectadas;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	public int eliminarClientes(int id) {

		try {
			int filasAfectadas = 0;

			String sql = "CALL sp_eliminarClientes(?)";
			this.abrirConexion();

			cs = conexion.prepareCall(sql);
			cs.setInt(1, id);

			filasAfectadas = cs.executeUpdate();

			return filasAfectadas;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int modificarClientes(clientesBeans clientes_) {

		try {
			int filasAfectadas = 0;

			String sql = "CALL sp_insertarClientes(?,?,?,?,?,?)";
			this.abrirConexion();

			cs = conexion.prepareCall(sql);
			cs.setInt(1, clientes_.getId_clientes());
			cs.setString(2, clientes_.getNombres());
			cs.setString(3, clientes_.getApellidos());
			cs.setString(4, clientes_.getDni());
			cs.setDate(5, clientes_.getFecha_nacimiento());
			cs.setString(6, clientes_.getDireccion());

			filasAfectadas = cs.executeUpdate();

			return filasAfectadas;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public clientesBeans obtenerClientes(int clientes_) {
		String sql = "call sp_obtenerCliente(?)";
		this.abrirConexion();

		try {
			cs = conexion.prepareCall(sql);
			cs.setInt(1, clientes_);
			rs = cs.executeQuery();
			clientesBeans au = new clientesBeans();
			if(rs.next()) {
				au.setId_clientes(rs.getInt("id_cliente"));
				au.setNombres(rs.getString("nombres"));
				au.setApellidos(rs.getString("apellidos"));
				au.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				au.setDireccion(rs.getNString("direccion"));
				
			}

			this.cerrarConexion();
			return au;
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return null;
		}
	}

	}
