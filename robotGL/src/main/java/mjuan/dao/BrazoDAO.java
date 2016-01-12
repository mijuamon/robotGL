package mjuan.dao;

import java.util.List;

import org.hibernate.Session;

import mjuan.dao.interfaces.BrazoIDAO;
import mjuan.util.HibernateUtil;

public class BrazoDAO implements BrazoIDAO
{	
	
	public static BrazoDAO getInstance(){
		return INSTANCE;
	}

	public List getBrazos() 
	{		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try
		{
			session.beginTransaction();	
			return session.createQuery("FROM Brazo b ORDER BY b.brazo_id").list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}		
	}
}
