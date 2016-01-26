package mjuan.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "BRAZO")
public class Brazo 
{
	@Id
	@Column(name="BRAZO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")  
	@SequenceGenerator(name = "generator", sequenceName = "BRA_SEQ", allocationSize=1)  
	private int brazo_id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="IMG")
	private String img;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "brazo_fk")
	private List<Pieza> piezas;
	
	
	public List<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}
	public int getId() {
		return brazo_id;
	}
	public void setId(int brazo_id) {
		this.brazo_id = brazo_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

}
