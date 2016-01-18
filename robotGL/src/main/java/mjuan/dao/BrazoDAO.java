package mjuan.dao;

import java.util.List;

import org.hibernate.Session;

import mjuan.dao.interfaces.BrazoIDAO;
import mjuan.model.Brazo;
import mjuan.util.HibernateUtil;

public class BrazoDAO implements BrazoIDAO
{	
	
	public static BrazoDAO getInstance(){
		return INSTANCE;
	}

	@SuppressWarnings("rawtypes")
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

	public Brazo getBrazo(int id) 
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try
		{
			session.beginTransaction();	
			return (Brazo) session.createQuery("FROM Brazo b WHERE b.brazo_id="+id).list().get(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}	
	}
}
