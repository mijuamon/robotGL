package mjuan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import mjuan.model.Tipo;

@Entity
@Table(name = "PIEZA")
public class Pieza 
{
	@Id
	@Column(name="PIEZA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")  
	@SequenceGenerator(name = "generator", sequenceName = "PIE_SEQ", allocationSize=1) 
	private int pieza_id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "BRAZO_FK")
	private Brazo brazo_fk;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "TIPO_FK")
	private Tipo tipo_fk;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="pieza")
	private List<SubPieza> subPiezas;
	
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="IMG")
	private String img;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	
	public int getPieza_id() {
		return pieza_id;
	}
	public void setPieza_id(int pieza_id) {
		this.pieza_id = pieza_id;
	}
	public Brazo getBrazo_fk() {
		return brazo_fk;
	}
	public void setBrazo_fk(Brazo brazo_fk) {
		this.brazo_fk = brazo_fk;
	}
	public Tipo getTipo_fk() {
		return tipo_fk;
	}
	public void setTipo_fk(Tipo tipo_fk) {
		this.tipo_fk = tipo_fk;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<SubPieza> getSubPiezas() {
		return subPiezas;
	}
	public void setSubPiezas(List<SubPieza> subPiezas) {
		this.subPiezas = subPiezas;
	}

}
