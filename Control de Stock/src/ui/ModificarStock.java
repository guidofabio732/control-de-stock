package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class ModificarStock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ModificarStock() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Atr\u00E1s");
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		button.setBounds(10, 520, 155, 32);
		contentPane.add(button);
		
		JButton btnGestionarMaq = new JButton("Gestionar M\u00E1quinas");
		btnGestionarMaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ABMCMaquinas maq = new ABMCMaquinas();
				maq.setVisible(true);
				dispose();
			}
		});
		btnGestionarMaq.setFont(new Font("Consolas", Font.PLAIN, 22));
		btnGestionarMaq.setBounds(205, 204, 395, 81);
		contentPane.add(btnGestionarMaq);
		
		JButton btnGestionarPiezasDe = new JButton("Gestionar Piezas de M\u00E1quinas");
		btnGestionarPiezasDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ABMCPiezasMaquina am = new ABMCPiezasMaquina();
				am.setVisible(true);
				dispose();
			}
		});
		btnGestionarPiezasDe.setFont(new Font("Consolas", Font.PLAIN, 22));
		btnGestionarPiezasDe.setBounds(205, 310, 395, 81);
		contentPane.add(btnGestionarPiezasDe);
		
		JButton btnGestionarPiezas = new JButton("Gestionar Piezas");
		btnGestionarPiezas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMPiezas ap = new ABMPiezas();
				ap.setVisible(true);
				dispose();
			}
			
		});
		btnGestionarPiezas.setFont(new Font("Consolas", Font.PLAIN, 22));
		btnGestionarPiezas.setBounds(205, 99, 395, 81);
		contentPane.add(btnGestionarPiezas);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{button}));
	}

}
