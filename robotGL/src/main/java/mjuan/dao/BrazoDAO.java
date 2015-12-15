package mjuan.dao;

import java.util.List;

import org.hibernate.Session;

import mjuan.dao.interfaces.BrazoIDAO;
import mjuan.model.Pieza;
import mjuan.util.Global;
import mjuan.util.HibernateUtil;

public class BrazoDAO implements BrazoIDAO
{
	static BrazoDAO INSTANCE = new BrazoDAO();
	
	public static BrazoDAO getInstance(){
		return INSTANCE;
	}

	public List getBrazos() 
	{
		// TODO Auto-generated method stub
		List<Pieza> lista;
		String sql="";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try
		{
			session.beginTransaction();	
			return session.createQuery("FROM Brazo").list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}		
	}
}
