package mjuan.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
}
