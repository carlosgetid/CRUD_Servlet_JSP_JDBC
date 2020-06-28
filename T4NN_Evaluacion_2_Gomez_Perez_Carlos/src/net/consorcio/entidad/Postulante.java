package net.consorcio.entidad;

public class Postulante {
	private int codigo;
	private String nombre;
	private String apellido;
	private int dniPostulante;
	private int numHijos;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDniPostulante() {
		return dniPostulante;
	}
	public void setDniPostulante(int dniPostulante) {
		this.dniPostulante = dniPostulante;
	}
	public int getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}
}
