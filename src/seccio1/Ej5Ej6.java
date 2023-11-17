package seccio1;

import java.io.File;

public class Ej5Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ej5-Ej6
		String directorio;
		File archivo;
		File[] archivos;

		if (args.length < 1 || args.length > 2) {
			System.out.println("No existen argumentos de entrada.");
			return;
		}

		directorio = args[0];
		archivo = new File(directorio);

		if (!archivo.exists() || !archivo.isDirectory()) {
			System.out.println("El directorio especificado no existe o no es un directorio válido.");
			return;
		}

		if (args.length == 2) {
			String extension = args[1];
			System.out.println("(Busqueda por extension)");
			FiltroExtensionV1 filtroExtension = new FiltroExtensionV1(extension);
			archivos = archivo.listFiles(filtroExtension);
		} else {
			System.out.println("(Todo el directorio)");
			archivos = archivo.listFiles();
		}

		if (archivos.length == 0) {
			System.out.println("No existe ningun archivo.");
		} else {
			System.out.println("Archivos encontrados:");
			for (File file : archivos) {
				System.out.println(file.getName());
			}
		}
	}

}
