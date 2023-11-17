package seccio1;

import java.io.File;

public class ej1ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File(args[0]);
		String name = archivo.getName();
		System.out.println("nom archivo: " + name);

		String ruta = archivo.getPath();
		System.out.println("Ruta del archivo: " + ruta);

		boolean puedeLeer = archivo.canRead();
		System.out.println("Se puede leer: " + puedeLeer);

		boolean puedeEscribir = archivo.canWrite();
		System.out.println("Se puede escribir:" + puedeEscribir);

		// Ej4
		if (archivo.exists()) {
			System.out.println("El archvio existe");
		} else
			System.out.println("El archvio NO existe");
	}

}
