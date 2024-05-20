package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;
import datos.Evento;

public class EventoDAO {
	private static Session session;
	private Transaction transaction;
	public static EventoDAO instance;

	public static EventoDAO getInstance() {
		if (instance == null) {
			instance = new EventoDAO();
		}
		return instance;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		transaction.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public List<Evento> traer() {
		List<Evento> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from Evento e", Evento.class).list();
			for (Evento evento : lista) {
				Hibernate.initialize(evento.getDispositivo());
			}
		} finally {
			session.close();
		}
		return lista;
	}


	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		Evento objeto = null;

		try {
			iniciaOperacion();
			objeto = (Evento) session.createQuery("FROM Evento e where e.dispositivo=:dispositivo AND e.fechaHora=:fechaHora")
					.setParameter("dispositivo", dispositivo).setParameter("fechaHora", fechaHora).uniqueResult();
		} finally {
			session.close();
		}

		return objeto;
	}

	public boolean agregar(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) throws Exception {
		int id = 0;
		if (traer(dispositivo, fechaHora) != null) {
			throw new Exception("error, esta repetido");
		}

		try {
			iniciaOperacion();
			id = (int)session.save(new Evento(descripcion, dispositivo, fechaHora));
			transaction.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		if(id == 0) {
			return false;
		}
		return true;
	}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta){
		List<Evento> lista = null;
		
		try {
			iniciaOperacion();
			lista = session.createQuery("from Evento e where e.fechaHora>=:fechaHoraDesde AND e.fechaHora<=:fechaHoraHasta", Evento.class)
					.setParameter("fechaHoraDesde", fechaHoraDesde)
					.setParameter("fechaHoraHasta", fechaHoraHasta)
					.list();
			for (Evento evento : lista) {
				Hibernate.initialize(evento.getDispositivo());
			}
		} finally {
			session.close();
		}
		
		return lista;
	}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo){
		List<Evento> lista = null;
		
		try {
			iniciaOperacion();
			lista = session.createQuery("from Evento e where e.fechaHora>=:fechaHoraDesde AND e.fechaHora<=:fechaHoraHasta AND e.dispositivo =:dispositivo", Evento.class)
					.setParameter("fechaHoraDesde", fechaHoraDesde)
					.setParameter("fechaHoraHasta", fechaHoraHasta)
					.setParameter("dispositivo", dispositivo)
					.list();
			for (Evento evento : lista) {
				Hibernate.initialize(evento.getDispositivo());
			}
		} finally {
			session.close();
		}
		
		return lista;
	}
	

}
