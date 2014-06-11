package myhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public final class hibernateUitl {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	private  hibernateUitl(){
		
	}
	static{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory=cfg.buildSessionFactory();
		

        //serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
       // sessionFactory = cfg.buildSessionFactory(serviceRegistry);
    }

		
		

	public static SessionFactory getSessionFactory() {
		return sessionFactory;		
	}
	public static Session getSession(){
		return sessionFactory.openSession();
		
	}
}
