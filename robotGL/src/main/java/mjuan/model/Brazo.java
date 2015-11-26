package mjuan.model;

import java.util.Set;

public class Brazo 
{
	private int id;
	private String nombre, descripcion,url,img;
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
