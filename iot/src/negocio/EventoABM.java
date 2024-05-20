package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.EventoDAO;
import datos.Dispositivo;
import datos.Evento;

public class EventoABM {
	public static EventoABM instance;
	
	private EventoABM() {};
	
	public static EventoABM getInstance() {
		if(instance == null) {
			instance = new EventoABM();
		}
		return instance;
	}
	
	public List<Evento> traer(){
		return EventoDAO.getInstance().traer();
	}
	
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora){
		return EventoDAO.getInstance().traer(dispositivo, fechaHora);
	}
	
	public boolean agregar(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) throws Exception{
		return EventoDAO.getInstance().agregar(descripcion, dispositivo, fechaHora);
	}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta){
		return EventoDAO.getInstance().traer(fechaHoraDesde, fechaHoraHasta);
	}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo){
		return EventoDAO.getInstance().traer(fechaHoraDesde, fechaHoraHasta, dispositivo);
	}
	
}
