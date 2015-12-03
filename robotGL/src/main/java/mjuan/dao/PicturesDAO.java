package mjuan.dao;

import java.util.List;

import org.hibernate.Session;

import mjuan.dao.interfaces.PicturesIDAO;
import mjuan.model.Pieza;
import mjuan.util.Global;
import mjuan.util.HibernateUtil;

public class PicturesDAO implements PicturesIDAO
{
	static PicturesDAO INSTANCE = new PicturesDAO();
	
	public static PicturesDAO getInstance(){
		return INSTANCE;
	}

	public List getPicturesPath(int PIEZA) 
	{
		// TODO Auto-generated method stub
		List<Pieza> lista;
		String sql="";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try
		{
			session.beginTransaction();			
			switch(PIEZA)
			{
				case Global.PIEZA_TODO:sql="FROM BRAZO";break;
				default: sql="FROM PIEZA WHERE tipo_fk="+PIEZA;break;
			}
			
			 return session.createQuery(sql).list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}		
	}
}
