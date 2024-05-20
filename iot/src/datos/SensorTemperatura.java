package datos;

public class SensorTemperatura extends Dispositivo{
	private double valorMinimo;
	private double valorMaximo;
	
	public SensorTemperatura() {}

	public SensorTemperatura(double valorMinimo, double valorMaximo, String nombre, boolean activo) {
		super(nombre, activo);
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	@Override
	public String toString() {
		return "SensorTemperatura [valorMinimo=" + valorMinimo + ", valorMaximo=" + valorMaximo + super.toString() +"]";
	};
	
	
	
}
