package com.ssd.hqlexample1;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ssd.dto.Dept;
import com.ssd.dto.DnameAvgSalDto;
import com.ssd.dto.EmpMgrLocation;

public class HibUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ssd-emp?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "asdf1234");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				
				
				settings.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
				settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
				settings.put(Environment.CACHE_PROVIDER_CONFIG, "net.sf.ehcache.hibernate.EhCacheProvider");
			
		
				

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(Dept.class);
				configuration.addAnnotatedClass(DnameAvgSalDto.class);
				configuration.addAnnotatedClass(EmpMgrLocation.class);
				

				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
