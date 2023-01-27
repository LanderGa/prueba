package prueba;

import java.awt.EventQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 {

	private JFrame frame;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldApellido1;
	private JTextField jTextFieldApellido2;
	private JTextField jTextFieldEdad;
	private JTextField jTextFieldDNINIE;
	private JTextField jTexxtFieldResumen;
	private JComboBox<String> jComboBox;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 window = new Ejercicio3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblApellido);

		JLabel lblNewLabel_1 = new JLabel("Apellido 2");
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Edad");
		lblNewLabel_2.setBounds(10, 86, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		jTextFieldNombre = new JTextField();
		jTextFieldNombre.setBounds(70, 8, 86, 20);
		frame.getContentPane().add(jTextFieldNombre);
		jTextFieldNombre.setColumns(10);

		jTextFieldApellido1 = new JTextField();
		jTextFieldApellido1.setBounds(70, 33, 86, 20);
		frame.getContentPane().add(jTextFieldApellido1);
		jTextFieldApellido1.setColumns(10);

		jTextFieldApellido2 = new JTextField();
		jTextFieldApellido2.setBounds(70, 58, 86, 20);
		frame.getContentPane().add(jTextFieldApellido2);
		jTextFieldApellido2.setColumns(10);

		jTextFieldEdad = new JTextField();
		jTextFieldEdad.setBounds(70, 83, 86, 20);
		frame.getContentPane().add(jTextFieldEdad);
		jTextFieldEdad.setColumns(10);

		jComboBox = new JComboBox<String>();
		jComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jComboBox.addItem("DNI");
		jComboBox.addItem("NIE");
		jComboBox.setBounds(10, 111, 46, 22);
		frame.getContentPane().add(jComboBox);

		jTextFieldDNINIE = new JTextField();
		jTextFieldDNINIE.setColumns(10);
		jTextFieldDNINIE.setBounds(70, 112, 86, 20);
		frame.getContentPane().add(jTextFieldDNINIE);

		JButton jButtonAceptar = new JButton("Aceptar");
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarDniNie();
			}
		});
		jButtonAceptar.setBounds(70, 172, 89, 23);
		frame.getContentPane().add(jButtonAceptar);

		jTexxtFieldResumen = new JTextField();
		jTexxtFieldResumen.setBounds(232, 33, 171, 130);
		frame.getContentPane().add(jTexxtFieldResumen);
		jTexxtFieldResumen.setColumns(10);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(280, 172, 89, 23);
		frame.getContentPane().add(btnLimpiar);
	}

	// ----------------------------------------------------------//

	private void verificarDniNie() {

		if (((String) jComboBox.getSelectedItem()).equals("DNI")) {
			// Es in DNI
			boolean isDNI = validar("[0-9]{8}[a-zA-Z]", jTextFieldDNINIE.getText());
			if (isDNI) {
				// Han metido un DNI
				jTexxtFieldResumen.setText(jTextFieldNombre.getText() + jTextFieldApellido1.getText()
						+ jTextFieldApellido2.getText() + jTextFieldEdad.getText() + jTextFieldDNINIE.getText());
			} else {
				// No han metido un DNI
				JOptionPane.showMessageDialog(null, "No es un DNI", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			// Es un NIE
			jTexxtFieldResumen.setText(jTextFieldNombre.getText() + jTextFieldApellido1.getText()
					+ jTextFieldApellido2.getText() + jTextFieldEdad.getText() + jTextFieldDNINIE.getText());
		}
	}

	private void limpiarCampos() {
		jTexxtFieldResumen.setText("");
		jTextFieldNombre.setText("");
		jTextFieldApellido1.setText("");
		jTextFieldApellido2.setText("");
		jTextFieldEdad.setText("");
		jTextFieldDNINIE.setText("");
	}

	public static boolean validar(String pattern, String texto) {
		boolean ret = false;
		Pattern patron = Pattern.compile(pattern);
		Matcher mat = patron.matcher(texto);
		if (mat.matches())
			ret = true;
		return ret;
	}
}
