package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class Ejercicio6 {

	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton jButtonPanel1;
	private JButton jButtonPanel2;
	private JButton jButtonPanel3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 window = new Ejercicio6();
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
	public Ejercicio6() {
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
		
		jButtonPanel1 = new JButton("Panel 1");
		jButtonPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e);
			}
		});
		jButtonPanel1.setBounds(42, 213, 89, 23);
		frame.getContentPane().add(jButtonPanel1);

		jButtonPanel2 = new JButton("Panel 2");
		jButtonPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e);
			}
		});
		jButtonPanel2.setBounds(162, 213, 89, 23);
		frame.getContentPane().add(jButtonPanel2);

		jButtonPanel3 = new JButton("Panel 3");
		jButtonPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e);
			}
		});
		jButtonPanel3.setBounds(293, 213, 89, 23);
		frame.getContentPane().add(jButtonPanel3);

		initializePanel1(); // Creamos el panel...
		frame.getContentPane().add(panel1);
		
		initializePanel2(); // Creamos el panel...
		frame.getContentPane().add(panel2);

		initializePanel3(); // Creamos el panel...
		frame.getContentPane().add(panel3);
		
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
	}

	// Podemos hacer cada panel de forma independiente...
	public void initializePanel1() {
		panel1 = new JPanel();
		panel1.setBounds(26, 21, 356, 156);
		panel1.setBackground(Color.red);
	}
	
	// Podemos hacer cada panel de forma independiente...
	public void initializePanel2() {
		panel2 = new JPanel();
		panel2.setBounds(26, 21, 356, 156);
		panel2.setBackground(Color.blue);
	}

	// Podemos hacer cada panel de forma independiente...
	public void initializePanel3() {
		panel3 = new JPanel();
		panel3.setBounds(26, 21, 356, 156);
		panel3.setBackground(Color.green);
	}

	// Cambio de un panel a otro...
	private void cambiarPanel(ActionEvent e) {
		if (e.getSource() == jButtonPanel1) {
			System.out.println("GoTO -> Panel 1");
			panel1.setVisible(true);
			panel2.setVisible(false);
			panel3.setVisible(false);
		}
		if (e.getSource() == jButtonPanel2) {
			System.out.println("GoTO -> Panel 2");
			panel1.setVisible(false);
			panel2.setVisible(true);
			panel3.setVisible(false);
		}
		if (e.getSource() == jButtonPanel3) {
			System.out.println("GoTO -> Panel 3");
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
	}
}
