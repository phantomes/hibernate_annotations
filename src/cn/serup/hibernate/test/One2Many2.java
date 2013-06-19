package cn.serup.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.Company;
import cn.serup.model.Organization;

public class One2Many2 {
	
	private static SessionFactory sessionFactory ;
	
	@Test
	public void testSaveOne2One() {
		Organization o = new Organization() ;
		o.setOrgName("谷度培训机构") ;

		Company c = new Company() ;
		c.setCompayName("广州分公司") ;
		c.setOrg(o) ;
		
		Company c1 = new Company() ;
		c1.setCompayName("成都分公司") ;
		c1.setOrg(o) ;
		
		Company c2 = new Company() ;
		c2.setCompayName("天津分公司") ;
		c2.setOrg(o) ;
		
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx=session.beginTransaction() ;
		
		session.save(o) ;
		session.save(c) ;
		session.save(c1) ;
		session.save(c2) ;
		
		tx.commit() ;
	}
	
	@Test
	public void testLoadOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx=session.beginTransaction() ;
		
		Company c = (Company)session.load(Company.class,1) ;
		
		System.out.println(c.getCompayName()+"org:"+c.getOrg().getOrgName());
		
		tx.commit() ;
	}
	
	@Test
	public void testDeleteOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx=session.beginTransaction() ;

		Company c = (Company) session.load(Company.class, 1) ;
		
		session.delete(c) ;
		
		tx.commit() ;
	}
	
	@BeforeClass
	public static void beforeClass() {
//		new SchemaExport(new AnnotationConfiguration().configure())
//		.create(true, true) ;
		
		sessionFactory = new AnnotationConfiguration().configure()
		.buildSessionFactory() ;
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close() ;
	}

}

