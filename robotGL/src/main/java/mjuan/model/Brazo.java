package mjuan.model;

import java.util.Set;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "BRAZO")
public class Brazo 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="BRAZO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")  
	@SequenceGenerator(name = "generator", sequenceName = "BRA_SEQ", allocationSize=1)  
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="URL")
	private String url;
	@Column(name="IMG")
	private String img;
	
	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="ROL_PRIV", 
				joinColumns={@JoinColumn(name="ROL_ID")}, 
				inverseJoinColumns={@JoinColumn(name="PRIVILEGIO_ID")})
	private Set<Pieza> piezas;
	
	
	public Set<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(Set<Pieza> piezas) {
		this.piezas = piezas;
	}
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
