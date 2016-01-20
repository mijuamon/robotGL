package mjuan.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO")
public class Tipo 
{
	@Id
	@Column(name="TIPO_ID")
	private int tipo_FK;
	
	@Column(name="NOMBRE")
	private String nombre;	
	
	public int getTipo_FK() {
		return tipo_FK;
	}
	public void setTipo_FK(int tipo_FK) {
		this.tipo_FK = tipo_FK;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
