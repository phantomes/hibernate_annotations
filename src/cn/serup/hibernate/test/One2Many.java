package cn.serup.hibernate.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.Company2;
import cn.serup.model.Organization2;

public class One2Many {
	
	private static SessionFactory sessionFactory ;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSaveOne2One() {
		Organization2 o = new Organization2() ;
		o.setOrgName("谷度培训机构") ;

		Company2 c = new Company2() ;
		c.setCompayName("广州分公司") ;
		
		Company2 c1 = new Company2() ;
		c1.setCompayName("成都分公司") ;
		
		Company2 c2 = new Company2() ;
		c2.setCompayName("天津分公司") ;
		
		Set set = new HashSet() ;
		set.add(c) ;
		set.add(c1) ;
		set.add(c2) ;
		
		o.setCompany2(set) ;
 		
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx=session.beginTransaction() ;
		
		session.save(o) ;
		session.save(c) ;
		session.save(c1) ;
		session.save(c2) ;
		
		tx.commit() ;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testLoadOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx=session.beginTransaction() ;
		
		Organization2 o = (Organization2)session.load(Organization2.class, 1) ;
		
		System.out.println(o.getId()+" "+o.getOrgName()) ;
		
		Set list = o.getCompany2() ;
		
		for(Iterator it = list.iterator(); it.hasNext();) {
			Company2 c = (Company2)it.next() ;
			System.out.println(c.getId()+" "+c.getCompayName());
		}
		
		tx.commit() ;
	}
	
	@Test
	public void testDeleteOne2One() {
		Session session = sessionFactory.getCurrentSession() ;
		Transaction tx=session.beginTransaction() ;

		//Company2 c = (Company2) session.load(Company2.class, 1) ;
		
		//session.delete(c) ;
		
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

