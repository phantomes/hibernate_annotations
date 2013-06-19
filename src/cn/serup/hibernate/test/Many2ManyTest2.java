package cn.serup.hibernate.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.Role;
import cn.serup.model.Role2;
import cn.serup.model.User;
import cn.serup.model.User2;

public class Many2ManyTest2 {
	
	private static SessionFactory sessionFactory = null ;
	
	public void testSaveUR() {
		Role2 r1 = new Role2() ;
		r1.setRoleName("项目组长") ;
		
		Role2 r3 = new Role2() ;
		r3.setRoleName("项目经理") ;
		
		Role2 r2 = new Role2() ;
		r2.setRoleName("技术总监") ;
		
		
		User2 u1 = new User2() ;
		u1.setUsername("唐骏") ;

		User2 u2 = new User2() ;
		u2.setUsername("李开复") ;
		
		User2 u3 = new User2() ;
		u3.setUsername("柳传志") ;
		
		Set<Role2> s1 = new HashSet<Role2>() ;
		s1.add(r1) ;
		s1.add(r3) ;
		
		Set<Role2> s2 = new HashSet<Role2>() ;
		s2.add(r1) ;
		s2.add(r2) ;
		
		Set<Role2> s3 = new HashSet<Role2>() ;
		s3.add(r1) ;
		s3.add(r2) ;
		s3.add(r3) ;
		
		u1.setRole(s1) ;
		u2.setRole(s2) ;
		u3.setRole(s3) ;
 		
		Session session = sessionFactory.getCurrentSession() ;
		session.beginTransaction().begin() ;
		
		session.save(r1) ;
		session.save(r2) ;
		session.save(r3) ;
		
		session.save(u1) ;
		session.save(u2) ;
		session.save(u3) ;
		
		session.beginTransaction().commit() ;
	}
	
	@Test
	public void testLoadUR() {
		Session session = sessionFactory.getCurrentSession() ;
		session.beginTransaction().begin() ;
		
		User2 u = (User2) session.get(User2.class,3) ;
		
		System.out.println("用户："+u.getUsername()) ;
		
		Set<Role2> s1 = u.getRole() ;
		System.out.print("拥有职务：");
		for(Iterator<Role2> it = s1.iterator(); it.hasNext();) {
			Role2 r = (Role2) it.next() ;
			System.out.print("\t【"+r.getRoleName()+"】");
		}
		
		session.beginTransaction().commit() ;
	}
	
	@Test
	public void testLoadRU() {
		Session session = sessionFactory.getCurrentSession() ;
		session.beginTransaction().begin() ;
		
		Role2 r = (Role2) session.get(Role2.class,1) ;
		
		System.out.println("职务："+r.getRoleName()) ;
		
		Set<User2> s1 = r.getUser() ;
		System.out.print("谁拥有该职务：");
		for(Iterator<User2> it = s1.iterator(); it.hasNext();) {
			User2 u = (User2) it.next() ;
			System.out.print("\t【"+u.getUsername()+"】");
		}
		
		session.beginTransaction().commit() ;
	}
	
	
	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory() ;
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close() ;
	}

}

