package prueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pruebaradioboton {

	private JFrame frame;
	private JRadioButton seleccionarDiaS;
	private JRadioButton seleccionarDiaD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaradioboton window = new pruebaradioboton();
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
	public pruebaradioboton() {
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
		
		seleccionarDiaS = new JRadioButton("Sábado");
		seleccionarDiaS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				probandoRadio(seleccionarDiaS);
			}
		});
		seleccionarDiaS.setBounds(6, 44, 109, 23);
		frame.getContentPane().add(seleccionarDiaS);
		
		seleccionarDiaD = new JRadioButton("Domingo");
		seleccionarDiaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				probandoRadio(seleccionarDiaD);
			}
		});
		seleccionarDiaD.setBounds(6, 70, 109, 23);
		frame.getContentPane().add(seleccionarDiaD);
	}
	private void probandoRadio(JRadioButton jRadioButton) {
	
		String boton = jRadioButton.getText();

		switch (boton) {
		case "Prueba1":			
			
			seleccionarDiaD.setSelected(false);
			radio3.setSelected(false);
			break;
		case "Prueba2":			
			seleccionarDiaS.setSelected(false);
			radio3.setSelected(false);
			break;
		case "Prueba3":		
			seleccionarDiaS.setSelected(false);
			seleccionarDiaD.setSelected(false);
			break;
		
		}
	}
	
}
