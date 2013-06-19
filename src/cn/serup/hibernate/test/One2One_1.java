package cn.serup.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.Body;
import cn.serup.model.Heart;
import cn.serup.model.Heart2;

public class One2One_1 {
	
	private static SessionFactory sessionFactory ;
	
	@Test
	public void testSaveTeacher() {
		Heart h = new Heart() ;
		h.setHeartName("h2") ;
		
		Body b = new Body() ;
		b.setBodyName("b2") ;
		b.setHeart(h) ;
 		
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx =session.beginTransaction() ;
		session.save(h) ;
		session.save(b) ;
		tx.commit() ;
	}
	
	@Test
	public void testLoadOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx =session.beginTransaction() ;
		Body b = (Body) session.get(Body.class, 1) ;
		System.out.println(b.getId() +" "+b.getBodyName());
		
		Heart h = b.getHeart() ;
		System.out.println(h.getId() +" "+h.getHeartName());
		
		tx.commit() ;
	}
	
	
	@Test
	public void testLoadOne2One2() {
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx= session.beginTransaction() ;
		
		Heart2 h = (Heart2) session.load(Heart2.class, 1) ;
		System.out.println(h.getId() +" "+h.getHeartName());
		
		Body b = h.getBody() ;
		System.out.println(b.getId()+ " " +b.getBodyName());
		
		tx.commit();
	}
		
	
	@Test
	public void testDeleteOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx =session.beginTransaction() ;

		Body b = (Body) session.get(Body.class, 1) ;
		
		session.delete(b) ;
		
		tx.commit() ;
	}
	
	@BeforeClass
	public static void beforeClass() {
//		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true) ;
		
		sessionFactory = new AnnotationConfiguration().configure()
		.buildSessionFactory() ;
	}
	
	
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close() ;
	}

}

