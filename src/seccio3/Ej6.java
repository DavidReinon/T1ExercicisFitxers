package seccio3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ej6 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			String rutaDirectoriActual = System.getProperty("user.dir");
			rutaDirectoriActual += "\\src\\seccio3\\exemple.xml";

			Document document = dBuilder.parse(new File(rutaDirectoriActual));
			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");

			NodeList nodeList = document.getElementsByTagName("cancion");
			List<Cancion> canciones = new ArrayList<>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;

					Cancion cancion = new Cancion();
					cancion.setId(Integer.parseInt(eElement.getAttribute("id")));
					cancion.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
					cancion.setArtista(eElement.getElementsByTagName("artista").item(0).getTextContent());
					cancion.setDuracion(eElement.getElementsByTagName("duracion").item(0).getTextContent());
					cancion.setAnyo(Integer.parseInt(eElement.getElementsByTagName("anyo").item(0).getTextContent()));

					canciones.add(cancion);
				}
			}

			for (Cancion cancion : canciones) {
				System.out.println(cancion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
