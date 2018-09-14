package br.usp.sibi.beholder.dao;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import br.usp.sibi.beholder.models.Service;
import br.usp.sibi.beholder.dao.utils.JpaUtils;

public class ServiceDao {
	public static List<Service> all() {
		List<Service> services = null;
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		try {
			TypedQuery<Service> q = em.createQuery("SELECT serv FROM Service serv", Service.class);
			services = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return services;
	}

	public static Service byId(int id) {
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		Service service = null;
		try {
			service = em.find(Service.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return service;
	}

	public static Service byName(String name) {
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		Service service = null;
		try {
			TypedQuery<Service> q = em.createQuery("SELECT serv FROM Service serv WHERE serv.name=:name",
					Service.class);
			q.setParameter("name", name);
			service = q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return service;
	}

	public static Integer getIdByName(String name) {
		Service service = null;
		try {
			service = byName(name);
			if (service == null)
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service.getId();
	}

	public static Integer insert(Service service) {
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		Integer serviceId = null;
		try {
			em.getTransaction().begin();
			em.persist(service);
			em.getTransaction().commit();
			serviceId = getIdByName(service.getName());
		} catch (RollbackException e) {
			serviceId = -1;
			System.out.println("Erro na inserção");
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			serviceId = null;
			System.out.println("Objeto Nulo");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return serviceId;
	}

	public static boolean update(Service service) {
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		Integer id = null;
		if(service.getId()<=0) {
			id = getIdByName(service.getName());
			if(id > 0) {
				service.setId(id);
			}else {
				return false;
			}
		}
		try {
			em.getTransaction().begin();
			service = em.merge(service);
			em.persist(service);
			em.getTransaction().commit();
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return true;
	}

	public static boolean delete(int id) {
		EntityManager em = JpaUtils.createEntityManagerBeholder();
		Service service = null;
		try {
			service = em.find(Service.class, id);
			em.getTransaction().begin();
			service = em.merge(service);
			em.remove(service);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return true;
	}

	public static boolean deleteByName(String name) {
		Boolean deleted = false;
		try {
			deleted = delete(getIdByName(name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
}