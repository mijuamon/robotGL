package mjuan.dao.interfaces;

import java.util.List;

import mjuan.dao.PiezaDAO;

public interface PiezaIDAO 
{
	static PiezaDAO INSTANCE = new PiezaDAO();
	
	public List getBases();
	
	public List getAntebrazos();
	
	public List getManos();

}
