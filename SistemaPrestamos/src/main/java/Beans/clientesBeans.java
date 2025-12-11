package Beans;

import java.sql.Date;

public class clientesBeans {
	private int id_clientes;
	private String nombres;
	private String apellidos;
	private String dni;
	private Date fecha_nacimiento;
	private String direccion;
	private String ajssjada;
	 
	 
	public clientesBeans() {
		super();
	}
	public clientesBeans(int id_clientes, String nombres, String apellidos, String dni, Date fecha_nacimiento,
			String direccion) {
		super();
		this.id_clientes = id_clientes;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
	}
	public int getId_clientes() {
		return id_clientes;
	}
	public void setId_clientes(int id_clientes) {
		this.id_clientes = id_clientes;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	

}
