package mjuan.dao;

import java.util.List;

import org.hibernate.Session;

import mjuan.dao.interfaces.PiezaIDAO;
import mjuan.model.Tipo;
import mjuan.util.HibernateUtil;

public class PiezaDAO implements PiezaIDAO
{	
	
	public static PiezaDAO getInstance(){
		return INSTANCE;
	}
	
	@SuppressWarnings("rawtypes")
	public List getBases() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try
		{
			session.beginTransaction();				
			List l = session.createQuery("FROM Tipo t WHERE t.nombre = 'BASE'").list();
			Tipo t=(Tipo)l.get(0);			
			
			String sql ="FROM Pieza p WHERE p.tipo_fk = '"+t.getTipo_FK()+"' ORDER BY p.pieza_id";

			List l2 = session.createQuery(sql).list();
			
			return l2;			
		}
		catch(Exception e)
		{
	
			return null;
		}		
	}

	@SuppressWarnings("rawtypes")
	public List getAntebrazos() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try
		{
			session.beginTransaction();				
			List l = session.createQuery("FROM Tipo t WHERE t.nombre = 'ANTEBRAZO'").list();
			Tipo t=(Tipo)l.get(0);			
			
			String sql ="FROM Pieza p WHERE p.tipo_fk = '"+t.getTipo_FK()+"' ORDER BY p.pieza_id";
			System.out.println(sql);
			List l2 = session.createQuery(sql).list();
			return l2;			
		}
		catch(Exception e)
		{
	
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public List getManos() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try
		{
			session.beginTransaction();				
			List l = session.createQuery("FROM Tipo t WHERE t.nombre = 'MANO'").list();
			Tipo t=(Tipo)l.get(0);			
			
			String sql ="FROM Pieza p WHERE p.tipo_fk = '"+t.getTipo_FK()+"' ORDER BY p.pieza_id";
			System.out.println(sql);
			List l2 = session.createQuery(sql).list();
			return l2;			
		}
		catch(Exception e)
		{
	
			return null;
		}
	}
}
