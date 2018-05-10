package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar Stock");
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockXPieza s = new StockXPieza();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(238, 108, 316, 81);
		contentPane.add(btnNewButton);
		
		JButton btnModificarStock = new JButton("Modificar Stock");
		btnModificarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarStock ms = new ModificarStock();
				ms.setVisible(true);
				dispose();
			}
		});
		btnModificarStock.setFont(new Font("Consolas", Font.PLAIN, 22));
		btnModificarStock.setBounds(238, 284, 316, 81);
		contentPane.add(btnModificarStock);
		
		JButton btnActualizarStock = new JButton("Actualizar Stock ");
		btnActualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActualizarStockMaq m = new ActualizarStockMaq();
				m.setVisible(true);
				dispose();
			}
		});
		btnActualizarStock.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnActualizarStock.setBounds(586, 520, 155, 32);
		contentPane.add(btnActualizarStock);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnSalir.setBounds(10, 520, 155, 32);
		contentPane.add(btnSalir);
		
		JLabel lblGuidofabiogmailcom = new JLabel("guidofabio732@gmail.com");
		lblGuidofabiogmailcom.setForeground(new Color(255, 255, 255));
		lblGuidofabiogmailcom.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblGuidofabiogmailcom.setBounds(10, 0, 164, 14);
		contentPane.add(lblGuidofabiogmailcom);
	}
}
