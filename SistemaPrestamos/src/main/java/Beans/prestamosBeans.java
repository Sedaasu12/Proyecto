package Beans;

import java.sql.Date;

public class prestamosBeans {
	private int idPrestamo;
    private Date fechaPrestamo;
    private double monto;
    private double interes;
    private int numeroCuotas;
    private int idCliente;
    
    
    private String nombreCliente;
    
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public prestamosBeans() {
		super();
	}
	public prestamosBeans(int idPrestamo, Date fechaPrestamo, double monto, double interes, int numeroCuotas,
			int idCliente) {
		super();
		this.idPrestamo = idPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.monto = monto;
		this.interes = interes;
		this.numeroCuotas = numeroCuotas;
		this.idCliente = idCliente;
	}
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public int getNumeroCuotas() {
		return numeroCuotas;
	}
	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
    
    
}
