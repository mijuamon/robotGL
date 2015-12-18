package mjuan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(Compatibilidad.class)
public class Compatibilidad implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	private Pieza Pieza_Base;
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	private Pieza Pieza_Ante;
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	private Pieza Pieza_Mano;
	
	public Compatibilidad(){}	
	
	public Compatibilidad(Pieza pieza_Base, Pieza pieza_Ante, Pieza pieza_Mano) {
		super();
		this.Pieza_Base = pieza_Base;
		this.Pieza_Ante = pieza_Ante;
		this.Pieza_Mano = pieza_Mano;
	}

	public Pieza getPieza_Base() {
		return Pieza_Base;
	}

	public void setPieza_Base(Pieza Pieza_Base) {
		this.Pieza_Base = Pieza_Base;
	}

	public Pieza getPieza_Ante() {
		return Pieza_Ante;
	}

	public void setPieza_Ante(Pieza Pieza_Ante) {
		this.Pieza_Ante = Pieza_Ante;
	}

	public Pieza getPieza_Mano() {
		return Pieza_Mano;
	}

	public void setPieza_Mano(Pieza Pieza_Mano) {
		this.Pieza_Mano = Pieza_Mano;
	}

}
