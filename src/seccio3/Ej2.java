package seccio3;

import java.io.*;

public class Ej2 {
	public static void main(String[] args) {
		try {
			String rutaDirectoriActual = System.getProperty("user.dir");
			rutaDirectoriActual += "\\src\\seccio3\\exemple.xml";

			BufferedReader br = new BufferedReader(new FileReader(new File(rutaDirectoriActual)));
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea + "\n");
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
