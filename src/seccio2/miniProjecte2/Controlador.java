package seccio2.miniProjecte2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador {
	private Model Model;
	private Vista Vista;
	private ActionListener actionListenerBtnBuscar;
	private ActionListener actionListenerBtnRemplazar;

	Controlador(Vista Vista, Model Model) {
		this.Vista = Vista;
		this.Model = Model;
		Control();
	}

	public void Control() {
		String contingutFitxerPrincipal = Model.getContingutFitxer(Model.getFitxer());
		Vista.getTextAreaContingut().setText(contingutFitxerPrincipal);

		actionListenerBtnBuscar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String paraula = Vista.getTextFieldBuscar().getText();
				String resultat = Model.BuscarCoincidencias(paraula);
				JOptionPane.showMessageDialog(null, resultat, "Buscador Coincidencias",
						JOptionPane.INFORMATION_MESSAGE);
			}
		};
		Vista.getBtnBuscar().addActionListener(actionListenerBtnBuscar);

		actionListenerBtnRemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paraula = Vista.getTextFieldBuscar().getText();
				String paraulaNova = Vista.getTextFieldRemplazar().getText();
				Boolean funcioRealitzada = Model.NouFitxerRemplazaParaula(paraula, paraulaNova);

				if (funcioRealitzada) {
					JOptionPane.showMessageDialog(null, "Accio realitzada correctament", "Nou archiu",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se ha pogut crear el archiu", "Nou archiu",
							JOptionPane.ERROR_MESSAGE);
				}
				String contingutFitxerNou = Model.getContingutFitxer(Model.getNouFitxer());
				Vista.getTextAreaNou().setText(contingutFitxerNou);
			}

		};
		Vista.getBtnRemplazar().addActionListener(actionListenerBtnRemplazar);

	}

}