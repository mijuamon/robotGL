package mjuan.dao;

import java.util.List;

import org.hibernate.Session;

import mjuan.dao.interfaces.SubPiezaIDAO;
import mjuan.util.HibernateUtil;

public class SubPiezaDAO implements SubPiezaIDAO
{
	private Session session;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getSPiezasByPiezaID(int id) 
	{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try
		{
			session.beginTransaction();
			return  session.createQuery("FROM subpieza b WHERE b.pieza_id="+id+" ORDER BY orden").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
