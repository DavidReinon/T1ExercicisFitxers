package seccio1;

import java.io.*;
import java.util.Scanner;

public class ej8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce el nom del archivo a copiar: ");
		String nomArchivoOriginal = scanner.nextLine();

		File archivoOriginal = new File(nomArchivoOriginal);

		if (archivoOriginal.exists()) {
			String nomArchivoCopia = "copia_" + archivoOriginal.getName();
			File archivoCopia = new File(nomArchivoCopia);

			try (FileReader fileReader = new FileReader(archivoOriginal);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					FileWriter fileWriter = new FileWriter(archivoCopia);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
				String linea;
				while ((linea = bufferedReader.readLine()) != null) {
					bufferedWriter.write(linea + '\n');
				}
				System.out.println("Archivo copiado como: " + nomArchivoCopia);

				if (archivoOriginal.delete()) {
					System.out.println("Archivo original borrado: " + nomArchivoOriginal);
				} else {
					System.out.println("No se pudo borrar el archivo original: " + nomArchivoOriginal);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El archivo original no existe.");
		}
		scanner.close();
	}
}
