package seccio1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ej5-Ej6
		String directorio;
		File archivo;
		File[] archivosFinales;

		if (args.length < 1) {
			System.out.println("No existen argumentos de entrada.");
			return;
		}

		directorio = args[0];
		archivo = new File(directorio);

		if (!archivo.exists() || !archivo.isDirectory()) {
			System.out.println("El directorio especificado no existe o no es un directorio válido.");
			return;
		}

		if (args.length > 1) {
			List<String> extensiones = new ArrayList<String>();
			for (int i = 1; i < args.length; i++) {
				extensiones.add(args[i]);
			}
			System.out.println("(Busqueda por extension/es)");
			FiltroExtension filtroExtension = new FiltroExtension(extensiones);
			archivosFinales = archivo.listFiles(filtroExtension);
		} else {
			System.out.println("(Todo el directorio)");
			archivosFinales = archivo.listFiles();
		}

		if (archivosFinales.length == 0) {
			System.out.println("No existe ningun archivo.");
		} else {
			System.out.println("Archivos encontrados:");
			for (File archivoFinal : archivosFinales) {
				System.out.println(archivoFinal.getName());
			}
		}
	}

}
