package mjuan.dao.interfaces;


import java.util.List;

import mjuan.dao.BrazoDAO;
import mjuan.model.Brazo;

public interface BrazoIDAO 
{
	static BrazoDAO INSTANCE = new BrazoDAO();
	@SuppressWarnings("rawtypes")
	public List getBrazos();
	public Brazo getBrazo(int id);

}
