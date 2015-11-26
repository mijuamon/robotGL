package mjuan.model;

public class Pieza 
{
	private int id, brazo_id, tipo,configuracion_id;
	private String descripcion,url,img,nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBrazo_id() {
		return brazo_id;
	}
	public void setBrazo_id(int brazo_id) {
		this.brazo_id = brazo_id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getConfiguracion_id() {
		return configuracion_id;
	}
	public void setConfiguracion_id(int configuracion_id) {
		this.configuracion_id = configuracion_id;
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

}
