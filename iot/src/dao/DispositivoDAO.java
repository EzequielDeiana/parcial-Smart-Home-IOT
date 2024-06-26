package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;

public class DispositivoDAO {
	private static Session session;
	private Transaction transaction;
	private static DispositivoDAO instance;
	
	public static DispositivoDAO getInstance() {
		if(instance == null) {
			instance = new DispositivoDAO();
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
	
	public List<Dispositivo> traer(){
		List<Dispositivo> lista = null;
		
		try {
			iniciaOperacion();
			lista = session.createQuery("FROM Dispositivo d", Dispositivo.class).list();
			for (Dispositivo dispositivo : lista) {
				Hibernate.initialize(dispositivo.getEventos());
			}
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	public Dispositivo traer(String nombre) {
		Dispositivo objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Dispositivo) session.createQuery("from Dispositivo d where d.nombre=:nombre",Dispositivo.class)
					.setParameter("nombre", nombre)
					.uniqueResult();
			Hibernate.initialize(objeto.getEventos());
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura(){
		List<Dispositivo> lista = null;
		
		try {
			iniciaOperacion();
			lista = session.createQuery("From SensorTemperatura st", Dispositivo.class).list();
		} finally {
			session.close();
		}
		
		return lista;
	}
	
}
