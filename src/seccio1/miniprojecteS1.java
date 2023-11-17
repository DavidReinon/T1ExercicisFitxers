package seccio1;

import java.io.File;
import java.util.Date;

public class miniprojecteS1 {

	public static void main(String[] args) {
		// ADV: Haurà d’haver una gestió d’errors (como a mínim, controlar que
		// existisca)
		directori = new File(args[0]);
		if (directori.exists()) {
			System.out.println("No existe este directorio");
			return;
		}
	}

	private static File directori;

	private String getInformacio(File file) {
		String nom = file.getName();
		String tipus = file.isDirectory() ? "Directori" : "Archivo";
		String ubicacio = file.getAbsolutePath();
		Date fechaUltimaModificacion = new Date(file.lastModified());
		String ocult = file.isHidden() ? "Si" : "No";
		String mostrar = (": " + nom + " Tipus: " + tipus + " Ruta:" + ubicacio + "\nUltima modificació: "
				+ fechaUltimaModificacion + " Ocult: " + ocult);
		return mostrar;
		// • Mostrar el , tipus (si es fitxer o directori), la ubicació (ruta
		// completa), la data de l’última modificació en format data i si és
		// ocult o no.
		// • Si és un fitxer haurà de mostrar la seua grandària en bytes.
		// • Si és un directori haurà de mostrar el nom d’elements que
		// conté, espai lliure, espai disponible i espai total.

	}

	private void crearCarpeta() {
		// Crear una carpeta en directori local.
	}

	private void creaFitxer() {
		// Crear un fitxer en la carpeta creada.

	}

	private void elimina() {
		// Eliminar fitxers/carpetes.
	}

	private void reena() {
		// Reena fitxers/carpetes
	}
}
