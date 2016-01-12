package mjuan.dao.interfaces;


import java.util.List;

import mjuan.dao.BrazoDAO;

public interface BrazoIDAO 
{
	static BrazoDAO INSTANCE = new BrazoDAO();
	public List getBrazos();

}
