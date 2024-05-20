package negocio;

import java.util.List;

import dao.DispositivoDAO;
import datos.Dispositivo;

public class DispositivoABM {
	public static DispositivoABM instance;
	
	private DispositivoABM() {};
	
	public static DispositivoABM getInstance() {
		if(instance == null) {
			instance = new DispositivoABM();
		}
		return instance;
	}
	
	public List<Dispositivo> traer(){
		return DispositivoDAO.getInstance().traer();
	}
	
	public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura(){
		return DispositivoDAO.getInstance().traerTodosLosDispositivosSensorTemperatura();
	}
	
	public Dispositivo traer(String nombre) {
			return DispositivoDAO.getInstance().traer(nombre);
	}
	
}
