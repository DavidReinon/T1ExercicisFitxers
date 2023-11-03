package seccio3;

public class Cancion {
	private int id;
	private String nombre;
	private String artista;
	private String duracion;
	private int anyo;

	public Cancion() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", nombre=" + nombre + ", artista=" + artista + ", duracion=" + duracion
				+ ", anyo=" + anyo + "]";
	}
}
