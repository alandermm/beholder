package br.usp.sibi.beholder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.jpa.rs.util.ResourceLocalTransactionWrapper;

import br.usp.sibi.beholder.dao.utils.JpaUtils;
import br.usp.sibi.beholder.models.Status;

public class StatusDao {
	public static List<Status> getAll() {
		List<Status> statuses = null;
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		try {
			TypedQuery<Status> q = em.createQuery("SELECT stat FROM Status stat", Status.class);
			statuses = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return statuses;
	}
	
	public static Status getById(int id) {
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		Status status = null;
		try {
			em.find(Status.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return status;
	}
	
	public static Status getByName(String name) {
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		Status status = null;
		try {
			TypedQuery<Status> q = em.createQuery("SELECT stat FROM Status stat WHERE stat.name=:name",
					Status.class);
			q.setParameter("name", name);
			status = q.getSingleResult();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return status;
	}
	
	public static Integer getIdByName(String name) {
		Status status = null;
		try {
			status = getByName(name);
			if(status.equals(null)) {
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status.getId();
	}
	

}
