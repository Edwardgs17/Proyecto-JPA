package com.ecodeup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="personas")
public class PersonaVO {

	@Id
	private int documento;
	@Column 
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String telefono;
	@Column
	private String correo;
	@Column
	private String sexo;
	@Column
	private double salario;
	@Column
	private String tipoEmpleado;
	@Column 
	private double SalarioTotal;
	
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public double getSalarioTotal() {
		return SalarioTotal;
	}
	public void setSalarioTotal(double salarioTotal) {
		SalarioTotal = salarioTotal;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void imprimirResultados() {
		
	        JOptionPane.showMessageDialog(null, "Nombre: "+getNombre()+"\n Apellidos: "+getApellidos()+"\n Telefono: "+getTelefono()+" \n Correo: "+getCorreo()+"\n Sexo: "+getSexo()+"\n Salario:"+getSalario()+"\n Tipo Empleado: "+getTipoEmpleado()+"\n Salario Total: "+getSalarioTotal());
	}


}
