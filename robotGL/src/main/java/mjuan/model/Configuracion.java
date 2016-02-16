package mjuan.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="ESC_X")
	private int esc_x;
	
	@Column(name="ESC_Y")
	private int esc_y;
	
	@Column(name="ESC_Z")
	private int esc_z;
	
	@Column(name="LIMIT_ROT")
	private int limit_rot;
	
	@Column(name="LIMIT_POS")
	private int limit_pos;
	
	@Column(name="POS_X")
	private int pos_x;
	
	@Column(name="POS_Y")
	private int pos_y;
	
	@Column(name="POS_Z")
	private int pos_z;
		
	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}

	public int getPos_z() {
		return pos_z;
	}

	public void setPos_z(int pos_z) {
		this.pos_z = pos_z;
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

	public int getEsc_x() {
		return esc_x;
	}

	public void setEsc_x(int esc_x) {
		this.esc_x = esc_x;
	}

	public int getEsc_y() {
		return esc_y;
	}

	public void setEsc_y(int esc_y) {
		this.esc_y = esc_y;
	}

	public int getEsc_z() {
		return esc_z;
	}

	public void setEsc_z(int esc_z) {
		this.esc_z = esc_z;
	}

	public int getLimit_rot() {
		return limit_rot;
	}

	public void setLimit_rot(int limit_rot) {
		this.limit_rot = limit_rot;
	}

	public int getLimit_pos() {
		return limit_pos;
	}

	public void setLimit_pos(int limit_pos) {
		this.limit_pos = limit_pos;
	}

	public String toString() 
	{
		// TODO Auto-generated method stub	
		String txt="";
		txt="\"pos:"+getPos_x()+","+getPos_y()+","+getPos_z()+";";
		txt=txt+"rot:"+getRot_x()+","+getRot_y()+","+getRot_z()+";";
		txt=txt+"sca:"+getEsc_x()+","+getEsc_y()+","+getEsc_z()+";";
		txt=txt+"lim:"+getLimit_pos()+","+getLimit_rot()+";\"";
		
		return txt;
	}
}
