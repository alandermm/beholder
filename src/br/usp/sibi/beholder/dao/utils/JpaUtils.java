package br.usp.sibi.beholder.dao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils{
	public static EntityManager criarEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("beholder");
		return factory.createEntityManager();
	}
}