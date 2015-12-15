package mjuan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPATIBILIDAD")
public class Compatibilidad 
{
	private Pieza Pieza_Base, Pieza_Ante, Pieza_Mano;

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
