package cn.serup.hibernate.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.Company3;
import cn.serup.model.Organization3;

public class Many2One {
	
	private static SessionFactory sessionFactory ;
	
	@Test
	public void testSaveOne2One() {
		Organization3 o = new Organization3() ;
		o.setOrgName("谷度培训机构") ;

		Company3 c = new Company3() ;
		c.setCompayName("广州分公司") ;
		c.setOrg(o) ;
		
		Company3 c1 = new Company3() ;
		c1.setCompayName("成都分公司") ;
		c1.setOrg(o) ;
		
		Company3 c2 = new Company3() ;
		c2.setCompayName("天津分公司") ;
		c2.setOrg(o) ;
		
		
 		
		Session session = sessionFactory.getCurrentSession() ;
		session.beginTransaction() ;
		
		session.save(o) ;
		session.save(c) ;
		session.save(c1) ;
		session.save(c2) ;
		
		session.beginTransaction().commit() ;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testLoadOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		session.beginTransaction() ;
		
		Organization3 o = (Organization3)session.load(Organization3.class, 1) ;
		
		System.out.println(o.getId()+" "+o.getOrgName()) ;
		
		Set set = o.getCompany3() ;
		
		for(Iterator it = set.iterator(); it.hasNext();) {
			Company3 c = (Company3)it.next() ;
			System.out.println(c.getId()+" "+c.getCompayName());
		}
		
		session.beginTransaction().commit() ;
	}
	
	@Test
	public void testDeleteOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		session.beginTransaction() ;

		//Company3 c = (Company3) session.load(Company3.class, 1) ;
		
		//session.delete(c) ;
		
		session.beginTransaction().commit() ;
	}
	
	@BeforeClass
	public static void beforeClass() {
		new SchemaExport(new AnnotationConfiguration().configure())
		.create(true, true) ;
		
		sessionFactory = new AnnotationConfiguration().configure()
		.buildSessionFactory() ;
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close() ;
	}

}

