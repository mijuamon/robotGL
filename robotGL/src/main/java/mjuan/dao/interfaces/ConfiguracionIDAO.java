package mjuan.dao.interfaces;

import mjuan.model.Configuracion;
import mjuan.model.Pieza;

public interface ConfiguracionIDAO 
{
	public Configuracion getConfiguracionByID(int id);
	public Configuracion getConfiguracionByPieza(Pieza pieza);

}
