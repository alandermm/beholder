package br.usp.sibi.beholder.dao;

import javax.persistence.TypedQuery;
import javax.servlet.jsp.JspException;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.usp.sibi.beholder.models.Servico;
import br.usp.sibi.beholder.dao.utils.JpaUtils;

public class ServicoDao {
	public static List<Servico> todos() {
		List<Servico> servicos = null;
		EntityManager em = null;
		try {
			em = JpaUtils.criarEntityManager();
			TypedQuery<Servico> q = em.createQuery("SELECT serv FROM Servico serv", Servico.class);
			servicos = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return servicos;
	}

	public static Servico porId(int id) {
		EntityManager em = null;
		Servico servico = null;
		try {
			em = JpaUtils.criarEntityManager();
			servico = em.find(Servico.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return servico;
	}

	public static void inserir(Servico servico) {
		EntityManager em = null;
		try {
			em = JpaUtils.criarEntityManager();
			em.getTransaction().begin();
			em.persist(servico);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void atualizar(Servico servico) {
		EntityManager em = null;
		try {
			em = JpaUtils.criarEntityManager();
			em.getTransaction().begin();
			servico = em.merge(servico);
			em.persist(servico);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void excluir(int id) {
		EntityManager em = null;
		Servico servico = null;
		try {
			em = JpaUtils.criarEntityManager();
			servico = em.find(Servico.class, id);
			em.getTransaction().begin();
			servico = em.merge(servico);
			em.remove(servico);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}