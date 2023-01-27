package prueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Ejercicio5 {

	private JFrame frame;
	private JTable jTable;
	JButton buttonAñadir;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldApellidos;
	private JTextField jTextFieldDni;
	private JTextField jTextFieldTelefono;
	
	private String columnasDeLaTabla [] = {"ID", "Nombre","Apellidos","Dni", "Telefono"};
	private String datosTable [][];
	
	private static int MAX_CONTACTS = 5;
	private int numContacts = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 window = new Ejercicio5();
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
	public Ejercicio5() {
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

		buttonAñadir = new JButton("Añadir");
		buttonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirContacto();
			}
		});
		buttonAñadir.setBounds(10, 64, 89, 23);
		frame.getContentPane().add(buttonAñadir);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(10, 39, 46, 14);
		frame.getContentPane().add(lblApellido);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(253, 11, 46, 14);
		frame.getContentPane().add(lblDni);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(253, 39, 46, 14);
		frame.getContentPane().add(lblTelefono);

		jTextFieldNombre = new JTextField();
		jTextFieldNombre.setBounds(86, 8, 146, 20);
		frame.getContentPane().add(jTextFieldNombre);
		jTextFieldNombre.setColumns(10);

		jTextFieldApellidos = new JTextField();
		jTextFieldApellidos.setColumns(10);
		jTextFieldApellidos.setBounds(86, 36, 146, 20);
		frame.getContentPane().add(jTextFieldApellidos);

		jTextFieldDni = new JTextField();
		jTextFieldDni.setColumns(10);
		jTextFieldDni.setBounds(338, 8, 86, 20);
		frame.getContentPane().add(jTextFieldDni);

		jTextFieldTelefono = new JTextField();
		jTextFieldTelefono.setColumns(10);
		jTextFieldTelefono.setBounds(338, 36, 86, 20);
		frame.getContentPane().add(jTextFieldTelefono);
		
		// La Tabla.
		datosTable = new String[5][5]; // Es una Array que contiene Arrays 
		jTable = new JTable(datosTable, columnasDeLaTabla);
		jTable.setEnabled(false);
		jTable.setBounds(10, 98, 414, 152);
		frame.getContentPane().add(jTable);
	}

	private void aniadirContacto() {

		// Si se cumplen todas las condiciones...
		boolean proceder = true;
		if (!verificarNombre()) {
			JOptionPane.showMessageDialog(null, "Nombre erróneo", "Error", JOptionPane.ERROR_MESSAGE);
			proceder = false;
		}

		if (!verificarApellidos()) {
			JOptionPane.showMessageDialog(null, "Apellidos erróneo", "Error", JOptionPane.ERROR_MESSAGE);
			proceder = false;
		}
		if (!verificarDni()) {
			JOptionPane.showMessageDialog(null, "DNI erróneo", "Error", JOptionPane.ERROR_MESSAGE);
			proceder = false;
		}

		if (!verificarTelefono()) {
			JOptionPane.showMessageDialog(null, "Telefono erróneo", "Error", JOptionPane.ERROR_MESSAGE);
			proceder = false;
		} 

		if ((proceder) && (numContacts < MAX_CONTACTS)){
		
			// Quitamos la tabla vieja...
			frame.getContentPane().remove(jTable);

			// Volvemos a crear la Tabla con los datos metidos en datosTable
			// El primer [] de datosTable [][] son las filas
			// El segundo [] de datosTable [][] son las columnas de la fila
			
			datosTable [numContacts][0] = numContacts + ""; 			// La columna ID
			datosTable [numContacts][1] = jTextFieldNombre.getText();	// La columna Nombre
			datosTable [numContacts][2] = jTextFieldApellidos.getText();// La columna Apellidos
			datosTable [numContacts][3] = jTextFieldDni.getText();		// La columna Dni
			datosTable [numContacts][4] = jTextFieldTelefono.getText();	// La columna Telefono
			numContacts++;
			
			jTable = new JTable(datosTable, columnasDeLaTabla);
			jTable.setEnabled(false);
			jTable.setBounds(10, 98, 414, 152);
			frame.getContentPane().add(jTable);

			// Ponemos la nueva y repintamos...
			frame.getContentPane().add(jTable);
			((JPanel)frame.getContentPane()).updateUI();
			
			// Limpiamos...
			jTextFieldNombre.setText("");
			jTextFieldApellidos.setText("");
			jTextFieldDni.setText("");
			jTextFieldTelefono.setText("");
			
			if (numContacts >= 5)
				buttonAñadir.setEnabled(false);
		}
	}

	private boolean verificarNombre() {
		boolean ret = false;
		String nombre = jTextFieldNombre.getText();
		ret = validar("[a-z A-Z]{1,20}", nombre);
		return ret;
	}

	private boolean verificarApellidos() {
		boolean ret = false;
		String apellidos = jTextFieldApellidos.getText();
		ret = validar("[a-z A-Z]{1,30}", apellidos);
		return ret;
	}

	private boolean verificarDni() {
		boolean ret = false;
		String DNI = jTextFieldDni.getText();
		ret = validar("[0-9]{8}[a-zA-Z]", DNI);
		return ret;
	}

	private boolean verificarTelefono() {
		boolean ret = false;
		String telefono = jTextFieldTelefono.getText();
		ret = validar("[0-9]{9}", telefono);
		return ret;
	}

	private boolean validar(String pattern, String texto) {
		boolean ret = false;
		Pattern patron = Pattern.compile(pattern);
		Matcher mat = patron.matcher(texto);
		if (mat.matches())
			ret = true;
		return ret;
	}
}
