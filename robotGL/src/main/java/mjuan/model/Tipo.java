package mjuan.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO")
public class Tipo 
{
	@Id
	@Column(name="TIPO_ID")
	private int tipo_ID;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Pieza> piezas;
	

	public int getTipo_ID() {
		return tipo_ID;
	}
	public void setTipo_ID(int tipo_ID) {
		this.tipo_ID = tipo_ID;
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
