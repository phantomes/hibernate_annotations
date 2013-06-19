package cn.serup.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.Teacher;

public class TeacherTest {
	
	private static SessionFactory sessionFactory ;
	
	@Test
	public void testSaveTeacher() {
		
		Teacher t = new Teacher() ;
		t.setId(3) ;
		t.setUsername("努尔哈赤2") ;
		t.setPassword("123456") ;
		
		Session session = sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction() ;
		
		session.save(t) ;
		
		tx.commit() ;
	}
	
	@BeforeClass
	public static void beforeClass() {
		
		//设置根据javabean生产对于的表
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true) ;
		
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close() ;
	}

}

