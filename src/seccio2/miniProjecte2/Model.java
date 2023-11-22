package seccio2.miniProjecte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.midi.SysexMessage;

import org.w3c.dom.UserDataHandler;

public class Model {

	private File fitxer;
	private File nouFitxer;

	Model() {
		String rutaFitxer = System.getProperty("user.dir");
		rutaFitxer += "\\archiuMP2.txt";
		fitxer = new File(rutaFitxer);
	}

	public File getFitxer() {
		return fitxer;
	}

	public File getNouFitxer() {
		return nouFitxer;
	}

	public String getContingutFitxer(File unFitxer) {
		StringBuilder contingut = new StringBuilder();
		try {
			FileReader fr = new FileReader(unFitxer);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				contingut.append(linea + "\n");
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contingut.toString();
	}

	public String BuscarCoincidencias(String stringBuscado) {
		String resultado = "";
		int coincidencias = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {
			String linea;
			int indice = -1;

			while ((linea = br.readLine()) != null) {
				indice = linea.indexOf(stringBuscado);
				while (indice >= 0) {
					coincidencias++;
					indice = linea.indexOf(stringBuscado, (indice + 1));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		resultado = fitxer.getName() + " => " + coincidencias + " coincidencia/es";
		return resultado;
	}

	public boolean NouFitxerRemplazaParaula(String paraulaARemplazar, String paraulaNova) {
		paraulaARemplazar = paraulaARemplazar.toLowerCase(); // Convertir a minúsculas
		String nom = paraulaARemplazar + "-" + paraulaNova + ".txt";
		String rutaActual = System.getProperty("user.dir");
		nouFitxer = new File(rutaActual, nom);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nouFitxer))) {
			try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					String lineaMinusculas = linea.toLowerCase();
					paraulaARemplazar = paraulaARemplazar.toLowerCase();
					paraulaNova = paraulaNova.toLowerCase();

					lineaMinusculas = lineaMinusculas.replaceAll(paraulaARemplazar, paraulaNova);
					bw.write(lineaMinusculas);
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
