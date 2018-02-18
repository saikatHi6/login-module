package org.common.login.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBUtilityFactory {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	private DBUtilityFactory(){
		
	}

	public static SessionFactory getSessionFacotry(){

		if(sessionFactory==null){
			try{
				//create registry
				registry = new StandardServiceRegistryBuilder().configure().build();

				//create Metadata Source
				MetadataSources sources = new MetadataSources(registry);

				//create metadata

				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.buildSessionFactory();
			}
			catch(Exception e){
				e.printStackTrace();
				if(registry!=null){
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
			
		}
		
		return sessionFactory;
	}

	public static void shutDown(){
		if(registry!=null){
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
