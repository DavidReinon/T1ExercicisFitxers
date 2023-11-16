package seccio2.miniProjecte2;

public class Principal {

	public static void main(String[] args) {
		Model Model = new Model();
		Vista Vista = new Vista();
		Controlador Controlador = new Controlador(Vista, Model);
	}

}
