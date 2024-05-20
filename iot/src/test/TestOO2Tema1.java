package test;

import java.time.LocalDateTime;

import negocio.DispositivoABM;
import negocio.EventoABM;

public class TestOO2Tema1 {

	public static void main(String[] args) {
		System.out.println("\n1) " + DispositivoABM.getInstance().traer());

		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("Apertura de la cortina",
					DispositivoABM.getInstance().traer("cortina pieza"), LocalDateTime.of(2023, 4, 3, 9, 10)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("Cierre de la cortina",
					DispositivoABM.getInstance().traer("cortina pieza"), LocalDateTime.of(2023, 4, 3, 19, 05)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("Apertura de la cortina",
					DispositivoABM.getInstance().traer("cortina pieza"), LocalDateTime.of(2023, 4, 4, 9, 00)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("Cierre de la cortina",
					DispositivoABM.getInstance().traer("cortina pieza"), LocalDateTime.of(2023, 4, 4, 19, 01)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("23 grados. Prender aire acondicionado",
					DispositivoABM.getInstance().traer("temp pieza"), LocalDateTime.of(2023, 4, 4, 11, 30)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("20 grados. Apagar aire acondicionado",
					DispositivoABM.getInstance().traer("temp pieza"), LocalDateTime.of(2023, 4, 4, 12, 0)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("Apertura de Cortina",
					DispositivoABM.getInstance().traer("cortina pieza"), LocalDateTime.of(2023, 4, 5, 9, 5)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		try {
			System.out.println("\n2) " + EventoABM.getInstance().agregar("Cierre de la cortina",
					DispositivoABM.getInstance().traer("cortina pieza"), LocalDateTime.of(2023, 4, 5, 19, 5)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n3) " + EventoABM.getInstance().traer(LocalDateTime.of(2023, 4, 3, 12, 0),
				LocalDateTime.of(2023, 4, 5, 12, 0)));

		System.out.println("\n4) " + EventoABM.getInstance().traer(LocalDateTime.of(2023, 4, 3, 12, 0),
				LocalDateTime.of(2023, 4, 5, 12, 0), DispositivoABM.getInstance().traer("cortina pieza")));

		System.out.println("\n5) " + DispositivoABM.getInstance().traerTodosLosDispositivosSensorTemperatura());

	}

}
