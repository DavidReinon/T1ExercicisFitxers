package seccio3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Ej4 {
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
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i); //Lista de un item (Por eso dentro del bucle)
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node; //Elemento abstracto que hay que crear para llamar las propiedades
					System.out.println("ID canço : " + eElement.getAttribute("id"));
					System.out.println("Titol : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
					System.out
							.println("Artista : " + eElement.getElementsByTagName("artista").item(0).getTextContent());
					System.out
							.println("Duraçio : " + eElement.getElementsByTagName("duracion").item(0).getTextContent());
					System.out.println("Any : " + eElement.getElementsByTagName("anyo").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
