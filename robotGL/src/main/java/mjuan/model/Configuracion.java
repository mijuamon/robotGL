package mjuan.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURACION")
public class Configuracion 
{
	

	@Id
	@Column(name="CONF_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")  
	@SequenceGenerator(name = "generator", sequenceName = "CON_SEQ", allocationSize=1) 
	private int id;
	
	@Column(name="ROT_X")
	private int rot_x;
	
	@Column(name="ROT_Y")
	private int rot_y;
	
	@Column(name="ROT_Z")
	private int rot_z;
	
	@Column(name="TRAS_X")
	private int tras_x;
	
	@Column(name="TRAS_Y")
	private int tras_y;
	
	@Column(name="TRAS_Z")
	private int tras_z;
	
	@Column(name="LIMIT_ROT")
	private int limit_rot;
	
	@Column(name="LIMIT_TRAS")
	private int limit_tras;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Pieza pieza;
	
	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getRot_x() {
		return rot_x;
	}

	public void setRot_x(int rot_x) {
		this.rot_x = rot_x;
	}

	public int getRot_y() {
		return rot_y;
	}

	public void setRot_y(int rot_y) {
		this.rot_y = rot_y;
	}

	public int getRot_z() {
		return rot_z;
	}

	public void setRot_z(int rot_z) {
		this.rot_z = rot_z;
	}

	public int getTras_x() {
		return tras_x;
	}

	public void setTras_x(int tras_x) {
		this.tras_x = tras_x;
	}

	public int getTras_y() {
		return tras_y;
	}

	public void setTras_y(int tras_y) {
		this.tras_y = tras_y;
	}

	public int getTras_z() {
		return tras_z;
	}

	public void setTras_z(int tras_z) {
		this.tras_z = tras_z;
	}

	public int getLimit_rot() {
		return limit_rot;
	}

	public void setLimit_rot(int limit_rot) {
		this.limit_rot = limit_rot;
	}

	public int getLimit_tras() {
		return limit_tras;
	}

	public void setLimit_tras(int limit_tras) {
		this.limit_tras = limit_tras;
	}

}
