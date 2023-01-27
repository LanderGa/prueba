package prueba;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Una ventana de Login sencilla.
 */
public class Ejercicio1 {

	private JFrame frame;
	private JTextField jTextLogin;
	private JTextField jTextPass;
	private JLabel jLabelLogin;
	private JLabel jLabelPass;

	// Tambien podemos añadir cosas a nuestra bola si las necesitamos...
	private static final String USER_ADMIN = "admin";
	private static final String CLAVE_ADMIN = "admin";

	// No hay que tocarlo... Lo crea solo el plugin
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 window = new Ejercicio1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// No hay que tocarlo... Lo crea solo el plugin
	public Ejercicio1() {
		initialize();
	}

	// Aquí el plugin va poniendo el codigo de la ventana
	// A vecess hay que cambiar el orden de los elementos
	// pero en general, no hay que tocar mucho...
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jTextLogin = new JTextField();
		jTextLogin.setBounds(170, 79, 86, 20);
		frame.getContentPane().add(jTextLogin);
		jTextLogin.setColumns(10);

		jTextPass = new JTextField();
		jTextPass.setColumns(10);
		jTextPass.setBounds(170, 126, 86, 20);
		frame.getContentPane().add(jTextPass);

		jLabelLogin = new JLabel();
		jLabelLogin.setText("LOGIN");
		jLabelLogin.setBounds(122, 79, 38, 20);
		frame.getContentPane().add(jLabelLogin);

		jLabelPass = new JLabel();
		jLabelPass.setText("PASSWORD");
		jLabelPass.setBounds(103, 126, 57, 20);
		frame.getContentPane().add(jLabelPass);
		
		JButton btnNewButton = new JButton("Saludo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//--------------------------
				// Delegamos la tarea...
				//--------------------------

				comprobarUserYPassword();
				
			}

		});
		btnNewButton.setBounds(170, 171, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	private void comprobarUserYPassword() {
		if (
				(null != jTextLogin.getText()) && 
				(!jTextLogin.getText().isEmpty()) &&
				(jTextLogin.getText().equalsIgnoreCase(USER_ADMIN)) && 
				
				(null != jTextPass.getText()) && 
				(!jTextPass.getText().isEmpty()) &&
				(jTextPass.getText().equalsIgnoreCase(CLAVE_ADMIN))
			
			) {

			JOptionPane.showMessageDialog(null, "Bienvenido a la app...", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			
		}else {
			
			JOptionPane.showMessageDialog(null, "Usuario o pass desconocido", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println("Click!");
	
	}
}
