package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.CtrlMaquinaPieza;
import controlers.CtrlTipoMaquina;
import controlers.CtrlTipoPieza;
import entities.TipoMaquina;
import entities.TipoPieza;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class ActualizarStockMaq extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ActualizarStockMaq() {
		setTitle("Gesti\u00F3n de Piezas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CtrlTipoMaquina ctrl= new CtrlTipoMaquina();
		ArrayList<TipoMaquina> maquinas = ctrl.getMaquinas();
		CtrlTipoPieza ctrltp = new CtrlTipoPieza();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(379, 112, 124, 20);
		contentPane.add(comboBox);
		
		for (TipoMaquina ma : maquinas) {
			comboBox.addItem(ma.getDescp());
		}
		
		JLabel lblAlta = new JLabel("Actualizar Stock");
		lblAlta.setFont(new Font("Consolas", Font.BOLD, 15));
		lblAlta.setBounds(293, 87, 283, 14);
		contentPane.add(lblAlta);
		
		JLabel lblMaquina = new JLabel("Maquina:");
		lblMaquina.setForeground(new Color(255, 255, 255));
		lblMaquina.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblMaquina.setBounds(220, 116, 133, 14);
		contentPane.add(lblMaquina);
		
		
		
		JButton button = new JButton("Atr\u00E1s");
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		button.setBounds(10, 518, 155, 32);
		contentPane.add(button);
		
		JButton btnAceptarAlta = new JButton("Aceptar");
		btnAceptarAlta.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoMaquina tm = new TipoMaquina();
				for (TipoMaquina t : maquinas) {
					if(comboBox.getSelectedItem().equals(t.getDescp())){
						tm=t;
					}
				}
			CtrlMaquinaPieza ctrlmp= new CtrlMaquinaPieza();
			boolean haySt=ctrlmp.getDisp(tm.getId());
			if(haySt){
				JOptionPane.showMessageDialog(rootPane, "No se puede realizar la operación debido a que faltan piezas requeridas");
			}
			if(!haySt){
				ctrlmp.actualizarStock(tm.getId());
				JOptionPane.showMessageDialog(rootPane, "Actualización exitosa");
			}
			}
		});
		btnAceptarAlta.setBounds(379, 143, 124, 23);
		contentPane.add(btnAceptarAlta);
		
		
	}
}
