package com.boraji.tutorial.spring.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.boraji.tutorial.spring.model.Noticia;

public class NoticiaDetailsDaoImp implements NoticiaDetailsDao {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticiaDetailsDaoImp.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

//	@Override
//	public void addNoticia(Noticia n) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.persist(n);
//		logger.info("New saved successfully, New Details="+n);
//	}
	
	public void saveNoticia(Noticia n) {
        sessionFactory.getCurrentSession().saveOrUpdate(n);
 
    }

//	@Override
//	public void updateNoticia(Noticia n) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.update(n);
//		logger.info("New updated successfully, New Details="+n);
//	}
	
//	@Override
//    public void updateNoticia(Noticia n) {
//        sessionFactory.getCurrentSession().update(n);
//        return n;
//    }
	
	public void updateNoticia(Noticia n) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(n);
		session.getTransaction().commit();
		session.close();
		
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Noticia> listNoticias() {
//		Session session = this.sessionFactory.getCurrentSession();
//		List<Noticia> personsList = session.createQuery("from News").list();
//		for(Noticia n : personsList){
//			logger.info("New List::"+n);
//		}
//		return personsList;
//	}
	
	 @SuppressWarnings("unchecked")
	    public List<Noticia> listNoticias() {
	 
	        return sessionFactory.getCurrentSession().createQuery("from news")
	                .list();
	    }

//	@Override
//	public Noticia getNoticiaById(int id) {
//		Session session = this.sessionFactory.getCurrentSession();		
//		Noticia n = (Noticia) session.load(Noticia.class, new Integer(id));
//		logger.info("New loaded successfully, New details="+n);
//		return n;
//	}

	public Noticia getNoticiaById(int id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Noticia n = (Noticia) session.load(Noticia.class, new Integer(id));
		session.getTransaction().commit();
		return n;
	}
//	@Override
//	public void removeNoticia(int id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		Noticia n = (Noticia) session.load(Noticia.class, new Integer(id));
//		if(null != n){
//			session.delete(n);
//		}
//		logger.info("New deleted successfully, new details="+n);
//	}
	
	
	public void removeNoticia(int id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Noticia n = (Noticia)session.get(Noticia.class, new Integer(id));
		session.delete(n);
		session.getTransaction().commit();
		session.close();
	}

}
