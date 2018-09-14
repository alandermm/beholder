package br.usp.sibi.beholder.dao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils{
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("beholder");
	}	
	public static EntityManager createEntityManagerBeholder() { 
		return factory.createEntityManager();
	}
}