package seccio3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ...

public class Ej7Ej8 {
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

			Scanner scanner = new Scanner(System.in);
			System.out.println("Introduce los valores de la nueva canción:");
			System.out.print("ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();

			System.out.print("Artista: ");
			String artista = scanner.nextLine();

			System.out.print("Duración: ");
			String duracion = scanner.nextLine();

			System.out.print("Año: ");
			int anyo = scanner.nextInt();

			scanner.close();
			Cancion nuevaCancion = new Cancion();
			nuevaCancion.setId(id);
			nuevaCancion.setNombre(nombre);
			nuevaCancion.setArtista(artista);
			nuevaCancion.setDuracion(duracion);
			nuevaCancion.setAnyo(anyo);

			canciones.add(nuevaCancion);

			System.out.println("Lista de canciones actualizada:");
			for (Cancion cancion : canciones) {
				System.out.println(cancion);
			}

			DocumentBuilderFactory dbFactoryNew = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilderNew = dbFactoryNew.newDocumentBuilder();
			Document documentNew = dBuilderNew.newDocument();
			Element rootElement = documentNew.createElement("canciones");
			documentNew.appendChild(rootElement);

			for (Cancion cancion : canciones) {
				Element cancionElement = documentNew.createElement("cancion");
				cancionElement.setAttribute("id", String.valueOf(cancion.getId()));

				Element nombreElement = documentNew.createElement("nombre");
				nombreElement.appendChild(documentNew.createTextNode(cancion.getNombre()));
				cancionElement.appendChild(nombreElement);

				Element artistaElement = documentNew.createElement("artista");
				artistaElement.appendChild(documentNew.createTextNode(cancion.getArtista()));
				cancionElement.appendChild(artistaElement);

				Element duracionElement = documentNew.createElement("duracion");
				duracionElement.appendChild(documentNew.createTextNode(cancion.getDuracion()));
				cancionElement.appendChild(duracionElement);

				Element anyoElement = documentNew.createElement("anyo");
				anyoElement.appendChild(documentNew.createTextNode(String.valueOf(cancion.getAnyo())));
				cancionElement.appendChild(anyoElement);

				rootElement.appendChild(cancionElement);
			}

			// Guardar el documento XML en un archivo
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Formatear el resultado
			DOMSource source = new DOMSource(documentNew);

			// Especificar el nombre del archivo de salida
			String archivoSalida = "canciones_actualizadas.xml";

			StreamResult result = new StreamResult(new FileOutputStream(archivoSalida));
			transformer.transform(source, result);

			System.out.println("Lista de canciones guardada en el archivo: " + archivoSalida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
