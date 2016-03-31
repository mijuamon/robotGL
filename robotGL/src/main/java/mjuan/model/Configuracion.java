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
	private double id;
	
	@Column(name="ROT_X")
	private double rot_x;
	
	@Column(name="ROT_Y")
	private double rot_y;
	
	@Column(name="ROT_Z")
	private double rot_z;
	
	@Column(name="ESC_X")
	private double esc_x;
	
	@Column(name="ESC_Y")
	private double esc_y;
	
	@Column(name="ESC_Z")
	private double esc_z;
	
	@Column(name="LIMIT_ROT")
	private double limit_rot;
	
	@Column(name="LIMIT_POS")
	private double limit_pos;
	
	@Column(name="POS_X")
	private double pos_x;
	
	@Column(name="POS_Y")
	private double pos_y;
	
	@Column(name="POS_Z")
	private double pos_z;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="UNION_T_X")
	private double union_t_x;

	@Column(name="UNION_T_Y")
	private double union_t_y;

	@Column(name="UNION_T_Z")
	private double union_t_z;

	@Column(name="UNION_R_X")
	private double union_r_x;

	@Column(name="UNION_R_Y")
	private double union_r_y;

	@Column(name="UNION_R_Z")
	private double union_r_z;
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getUnion_t_x() {
		return union_t_x;
	}

	public void setUnion_t_x(double union_t_x) {
		this.union_t_x = union_t_x;
	}

	public double getUnion_t_y() {
		return union_t_y;
	}

	public void setUnion_t_y(double union_t_y) {
		this.union_t_y = union_t_y;
	}

	public double getUnion_t_z() {
		return union_t_z;
	}

	public void setUnion_t_z(double union_t_z) {
		this.union_t_z = union_t_z;
	}

	public double getUnion_r_x() {
		return union_r_x;
	}

	public void setUnion_r_x(double union_r_x) {
		this.union_r_x = union_r_x;
	}

	public double getUnion_r_y() {
		return union_r_y;
	}

	public void setUnion_r_y(double union_r_y) {
		this.union_r_y = union_r_y;
	}

	public double getUnion_r_z() {
		return union_r_z;
	}

	public void setUnion_r_z(double union_r_z) {
		this.union_r_z = union_r_z;
	}

	public double getPos_x() {
		return pos_x;
	}

	public void setPos_x(double pos_x) {
		this.pos_x = pos_x;
	}

	public double getPos_y() {
		return pos_y;
	}

	public void setPos_y(double pos_y) {
		this.pos_y = pos_y;
	}

	public double getPos_z() {
		return pos_z;
	}

	public void setPos_z(double pos_z) {
		this.pos_z = pos_z;
	}
	
	public double getId() {
		return id;
	}
	
	public void setId(double id) {
		this.id = id;
	}

	public double getRot_x() {
		return rot_x;
	}

	public void setRot_x(double rot_x) {
		this.rot_x = rot_x;
	}

	public double getRot_y() {
		return rot_y;
	}

	public void setRot_y(double rot_y) {
		this.rot_y = rot_y;
	}

	public double getRot_z() {
		return rot_z;
	}

	public void setRot_z(double rot_z) {
		this.rot_z = rot_z;
	}

	public double getEsc_x() {
		return esc_x;
	}

	public void setEsc_x(double esc_x) {
		this.esc_x = esc_x;
	}

	public double getEsc_y() {
		return esc_y;
	}

	public void setEsc_y(double esc_y) {
		this.esc_y = esc_y;
	}

	public double getEsc_z() {
		return esc_z;
	}

	public void setEsc_z(double esc_z) {
		this.esc_z = esc_z;
	}

	public double getLimit_rot() {
		return limit_rot;
	}

	public void setLimit_rot(double limit_rot) {
		this.limit_rot = limit_rot;
	}

	public double getLimit_pos() {
		return limit_pos;
	}

	public void setLimit_pos(double limit_pos) {
		this.limit_pos = limit_pos;
	}

	public String toString() 
	{
		String txt="";
		txt="\"pos:"+getPos_x()+","+getPos_y()+","+getPos_z()+";";
		txt=txt+"rot:"+getRot_x()+","+getRot_y()+","+getRot_z()+";";
		txt=txt+"sca:"+getEsc_x()+","+getEsc_y()+","+getEsc_z()+";";
		txt=txt+"lim:"+getLimit_pos()+","+getLimit_rot()+";";
		txt=txt+"union_T:"+getUnion_t_x()+","+getUnion_t_y()+","+getUnion_t_z()+";";
		txt=txt+"union_R:"+getUnion_r_x()+","+getUnion_r_y()+","+getUnion_r_z()+";\"";
		return txt;
	}
}
