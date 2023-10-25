package seccio3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Ej3 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			String rutaDirectoriActual = System.getProperty("user.dir");
			rutaDirectoriActual += "\\src\\seccio3\\exemple.xml";

			Document document = dBuilder.parse(new File(rutaDirectoriActual));
			NodeList nodeList = document.getElementsByTagName("cancion");
			System.out.println("Numero de canciones: " + nodeList.getLength());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
