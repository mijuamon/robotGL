package mjuan.dao.interfaces;

import java.util.List;

import mjuan.model.SubPieza;

public interface SubPiezaIDAO 
{
	public List<SubPieza> getSPiezasByPiezaID(int id);

}
