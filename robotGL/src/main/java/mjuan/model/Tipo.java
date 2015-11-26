package mjuan.model;

import java.util.Set;

public class Tipo 
{
	private int id;
	private String nombre;
	private Set<Pieza> piezas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(Set<Pieza> piezas) {
		this.piezas = piezas;
	}
}
