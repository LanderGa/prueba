package prueba;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio4 {

	private JFrame frmCarrusel;
	private JPanel jPanelImage;
	private JButton jButtonLeftAll;
	private JButton jButtonLeft;
	private JButton jButtonRight;
	private JButton jButtonRightAll;
	private JLabel jLabelImage;
	private ImageIcon[] arrayImagenes;
	private int posicionArray = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 window = new Ejercicio4();
					window.frmCarrusel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarrusel = new JFrame();
		frmCarrusel.setTitle("Carrusel");
		frmCarrusel.setResizable(false);
		frmCarrusel.setBounds(100, 100, 450, 300);
		frmCarrusel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarrusel.getContentPane().setLayout(null);

		jButtonLeftAll = new JButton("<<");
		jButtonLeftAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leftAll();
			}
		});
		jButtonLeftAll.setBounds(10, 227, 89, 23);
		frmCarrusel.getContentPane().add(jButtonLeftAll);

		jButtonLeft = new JButton("<");
		jButtonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				left();
			}
		});
		jButtonLeft.setBounds(109, 227, 89, 23);
		frmCarrusel.getContentPane().add(jButtonLeft);

		jButtonRightAll = new JButton(">>");
		jButtonRightAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rightAll();
			}
		});
		jButtonRightAll.setBounds(335, 227, 89, 23);
		frmCarrusel.getContentPane().add(jButtonRightAll);

		jButtonRight = new JButton(">");
		jButtonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				right();
			}
		});
		jButtonRight.setBounds(236, 227, 89, 23);
		frmCarrusel.getContentPane().add(jButtonRight);
	
		jPanelImage = new JPanel();
		jPanelImage.setBounds(10, 11, 414, 196);
		frmCarrusel.getContentPane().add(jPanelImage);
		
		// Las imagenes
		arrayImagenes = new ImageIcon[6];
		ImageIcon imageIcon1 = new ImageIcon(this.getClass().getResource("Image1.jpg"));
		Image image = imageIcon1.getImage().getScaledInstance(jPanelImage.getWidth(),jPanelImage.getHeight(),Image.SCALE_SMOOTH);
		imageIcon1.setImage(image);
		
		ImageIcon imageIcon2 = new ImageIcon(this.getClass().getResource("Image2.jpg"));
		image = imageIcon2.getImage().getScaledInstance(jPanelImage.getWidth(),jPanelImage.getHeight(),Image.SCALE_SMOOTH);
		imageIcon2.setImage(image);
		
		ImageIcon imageIcon3 = new ImageIcon(this.getClass().getResource("Image3.jpg"));
		image = imageIcon3.getImage().getScaledInstance(jPanelImage.getWidth(),jPanelImage.getHeight(),Image.SCALE_SMOOTH);
		imageIcon3.setImage(image);
		
		ImageIcon imageIcon4 = new ImageIcon(this.getClass().getResource("Image4.jpg"));
		image = imageIcon4.getImage().getScaledInstance(jPanelImage.getWidth(),jPanelImage.getHeight(),Image.SCALE_SMOOTH);
		imageIcon4.setImage(image);
		
		ImageIcon imageIcon5 = new ImageIcon(this.getClass().getResource("Image5.jpg"));
		image = imageIcon5.getImage().getScaledInstance(jPanelImage.getWidth(),jPanelImage.getHeight(),Image.SCALE_SMOOTH);
		imageIcon5.setImage(image);
		
		ImageIcon imageIcon6 = new ImageIcon(this.getClass().getResource("Image6.jpg"));
		image = imageIcon6.getImage().getScaledInstance(jPanelImage.getWidth(),jPanelImage.getHeight(),Image.SCALE_SMOOTH);
		imageIcon6.setImage(image);

		arrayImagenes [0] = imageIcon1;
		arrayImagenes [1] = imageIcon2;
		arrayImagenes [2] = imageIcon3;
		arrayImagenes [3] = imageIcon4;
		arrayImagenes [4] = imageIcon5;
		arrayImagenes [5] = imageIcon6;
		
		// Inicialmente, enseñamos arrayImagenes [0]
		
		jLabelImage = new JLabel();
		jLabelImage.setHorizontalAlignment(JLabel.CENTER);
		jLabelImage.setIcon(arrayImagenes [posicionArray]);
		jPanelImage.add(jLabelImage, JPanel.CENTER_ALIGNMENT);
		
		jButtonLeft.setEnabled(false);
		jButtonLeftAll.setEnabled(false);
		jButtonRight.setEnabled(true);
		jButtonRightAll.setEnabled(true);
	}

	private void leftAll() {
		posicionArray = 0;
		jLabelImage.setIcon(arrayImagenes [posicionArray]);
		
		jButtonLeft.setEnabled(false);
		jButtonLeftAll.setEnabled(false);
		jButtonRight.setEnabled(true);
		jButtonRightAll.setEnabled(true);
	}

	private void left() {
		posicionArray = posicionArray ==  0? 0 : posicionArray - 1;
		jLabelImage.setIcon(arrayImagenes [posicionArray]);
		
		if (posicionArray == 0) {
			jButtonLeft.setEnabled(false);
			jButtonLeftAll.setEnabled(false);
			jButtonRight.setEnabled(true);
			jButtonRightAll.setEnabled(true);
		} else {
			jButtonLeft.setEnabled(true);
			jButtonLeftAll.setEnabled(true);
			jButtonRight.setEnabled(true);
			jButtonRightAll.setEnabled(true);
		}
	}

	private void right() {
		posicionArray = posicionArray == 5? 5 : posicionArray  + 1;
		jLabelImage.setIcon(arrayImagenes [posicionArray]);
		
		if (posicionArray == 5) {
			jButtonLeft.setEnabled(true);
			jButtonLeftAll.setEnabled(true);
			jButtonRight.setEnabled(false);
			jButtonRightAll.setEnabled(false);
		} else {
			jButtonLeft.setEnabled(true);
			jButtonLeftAll.setEnabled(true);
			jButtonRight.setEnabled(true);
			jButtonRightAll.setEnabled(true);
		}
	}

	private void rightAll() {
		posicionArray = 5;
		jLabelImage.setIcon(arrayImagenes [posicionArray]);
		
		jButtonLeft.setEnabled(true);
		jButtonLeftAll.setEnabled(true);
		jButtonRight.setEnabled(false);
		jButtonRightAll.setEnabled(false);
	}
}
