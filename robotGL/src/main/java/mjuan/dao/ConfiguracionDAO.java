package mjuan.dao;

import org.hibernate.Session;

import mjuan.dao.interfaces.ConfiguracionIDAO;
import mjuan.model.Configuracion;
import mjuan.model.Pieza;
import mjuan.util.HibernateUtil;

public class ConfiguracionDAO implements ConfiguracionIDAO
{
	private Session session;
	
	public Configuracion getConfiguracionByID(int id) 
	{
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try
		{
			session.beginTransaction();
			return (Configuracion) session.createQuery("FROM Configuracion b WHERE b.id="+id).list().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}		
	}

	public Configuracion getConfiguracionByPieza(Pieza pieza) 
	{
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try
		{
			session.beginTransaction();
			return (Configuracion) session.createQuery("FROM Configuracion b WHERE b.pieza="+pieza).list().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}		
	}

	

}
