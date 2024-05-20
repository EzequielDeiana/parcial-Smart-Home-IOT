package datos;

import java.util.Set;

public abstract class Dispositivo {
	protected int idDispositivo;
	protected String nombre;
	protected boolean activo;
	protected Set<Evento> eventos;
	
	
	public Dispositivo() {}

	public Dispositivo(String nombre, boolean activo) {
		super();
		this.nombre = nombre;
		this.activo = activo;
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public String toString() {
		return "Dispositivo [idDispositivo=" + idDispositivo + ", nombre=" + nombre + ", activo=" + activo + "]";
	}
	
	
	
}
