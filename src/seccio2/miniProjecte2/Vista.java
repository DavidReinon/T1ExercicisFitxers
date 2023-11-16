package seccio2.miniProjecte2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textAreaContingut;
	private JButton btnBuscar;
	private JTextField textFieldBuscar;
	private JButton btnRemplazar;
	private JTextField textFieldRemplazar;
	private JTextArea textAreaNou;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaContingut = new JTextArea();
		textAreaContingut.setEditable(false);
		textAreaContingut.setBounds(10, 23, 580, 154);
		contentPane.add(textAreaContingut);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(198, 201, 93, 23);
		contentPane.add(btnBuscar);

		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(30, 202, 158, 20);
		contentPane.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		textFieldRemplazar = new JTextField();
		textFieldRemplazar.setBounds(325, 202, 150, 20);
		textFieldRemplazar.setColumns(10);
		contentPane.add(textFieldRemplazar);

		btnRemplazar = new JButton("Remplazar");
		btnRemplazar.setBounds(485, 201, 105, 23);
		contentPane.add(btnRemplazar);

		textAreaNou = new JTextArea();
		textAreaNou.setBounds(10, 245, 580, 154);
		contentPane.add(textAreaNou);

		setVisible(true);
	}

	public JTextArea getTextAreaContingut() {
		return textAreaContingut;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTextField getTextFieldBuscar() {
		return textFieldBuscar;
	}
	public JTextArea getTextAreaNou() {
		return textAreaNou;
	}
	public JButton getBtnRemplazar() {
		return btnRemplazar;
	}

	public JTextField getTextFieldRemplazar() {
		return textFieldRemplazar;
	}
	
}