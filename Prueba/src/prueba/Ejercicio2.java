package prueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 {

	private JFrame frmMejorJuego;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 window = new Ejercicio2();
					window.frmMejorJuego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio2() {
		initialize();
	}

	private void initialize() {
		frmMejorJuego = new JFrame();
		frmMejorJuego.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Ejercicio2.class.getResource("/vistas/Fallout.jpg")));
		frmMejorJuego.setTitle("Mejor Juego");
		frmMejorJuego.setBounds(100, 100, 450, 300);
		frmMejorJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMejorJuego.getContentPane().setLayout(null);

		JLabel jLabel = new JLabel("¿Cuál es el mejor juego?");
		jLabel.setBounds(10, 11, 149, 31);
		frmMejorJuego.getContentPane().add(jLabel);

		jRadioButton1 = new JRadioButton("Fallout 3");
		jRadioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// --------------------------
				// Delegamos la tarea...
				// --------------------------
				seleccionarVideojuego(jRadioButton1);
			}
		});
		jRadioButton1.setBounds(10, 49, 149, 23);
		frmMejorJuego.getContentPane().add(jRadioButton1);

		jRadioButton2 = new JRadioButton("Fallout New Vegas");
		jRadioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// --------------------------
				// Delegamos la tarea...
				// --------------------------
				seleccionarVideojuego(jRadioButton2);
			}
		});
		jRadioButton2.setBounds(10, 74, 149, 23);
		frmMejorJuego.getContentPane().add(jRadioButton2);

		jRadioButton3 = new JRadioButton("Fallout 4");
		jRadioButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// --------------------------
				// Delegamos la tarea...
				// --------------------------
				seleccionarVideojuego(jRadioButton3);
			}
		});
		jRadioButton3.setBounds(10, 100, 149, 23);
		frmMejorJuego.getContentPane().add(jRadioButton3);

		jRadioButton4 = new JRadioButton("Fallout 76");
		jRadioButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// --------------------------
				// Delegamos la tarea...
				// --------------------------
				seleccionarVideojuego(jRadioButton4);
			}
		});
		jRadioButton4.setBounds(10, 126, 149, 23);
		frmMejorJuego.getContentPane().add(jRadioButton4);
	}

	private void seleccionarVideojuego(JRadioButton jRadioButton) {

		String boton = jRadioButton.getText();

		switch (boton) {
		case "Fallout 3":			
			jRadioButton2.setSelected(false);
			jRadioButton3.setSelected(false);
			jRadioButton4.setSelected(false);
			break;
		case "Fallout New Vegas":			
			jRadioButton1.setSelected(false);
			jRadioButton3.setSelected(false);
			jRadioButton4.setSelected(false);
			break;
		case "Fallout 4":		
			jRadioButton1.setSelected(false);
			jRadioButton2.setSelected(false);
			jRadioButton4.setSelected(false);
			break;
		case "Fallout 76":
			jRadioButton1.setSelected(false);
			jRadioButton2.setSelected(false);
			jRadioButton3.setSelected(false);
			break;
		}
	}
}
