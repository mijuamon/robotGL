package mjuan.dao.interfaces;

import java.util.List;

import mjuan.dao.PiezaDAO;

public interface PiezaIDAO 
{
	static PiezaDAO INSTANCE = new PiezaDAO();
	
	@SuppressWarnings("rawtypes")
	public List getBases();
	
	@SuppressWarnings("rawtypes")
	public List getAntebrazos();
	
	@SuppressWarnings("rawtypes")
	public List getManos();

}
