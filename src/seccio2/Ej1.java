package seccio2;

import java.io.File;
import java.io.IOException;

public class Ej1 {

	public static void main(String[] args) {
		// Ficheros s1
		File prueba = new File("prueba");
		File dir = new File("dir");
		try {
			prueba.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prueba.delete();
		dir.mkdir(); // Directori

		File otro = new File("otro");
		prueba.renameTo(otro);

		// Streams s2

		// int valor = br.read();
		// (char)valor //Caractre a caracter

		//Thread.sleep(1000) //1seg dormir proceso
		
		// string linea = br.readline(); //Linea a linea

		// System.in.read(); //Esperar tecla del usuario para seguir ejecución

		//Hora exacta con formato
		// String timespan = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new java.util.Date());

	}

}
