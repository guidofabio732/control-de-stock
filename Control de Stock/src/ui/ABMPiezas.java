package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.CtrlTipoPieza;
import customException.MySqlError;
import entities.TipoPieza;

import java.awt.Color;
import java.awt.Font;

public class ABMPiezas extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdB;
	private JTextField txtnmbrePiezaB;
	private JTextField txtCantB;
	private JTextField txtCantM;
	private JTextField txtnmbrePiezaM;
	private JTextField txtIdM;
	private JTextField txtnmbrePiezaA;
	private JTextField txtCantA;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ABMPiezas() {
		setTitle("Gesti\u00F3n de Piezas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlta = new JLabel("Nueva Pieza");
		lblAlta.setFont(new Font("Consolas", Font.BOLD, 15));
		lblAlta.setBounds(73, 27, 92, 14);
		contentPane.add(lblAlta);
		
		JLabel lblBaja = new JLabel("Eliminar Pieza");
		lblBaja.setFont(new Font("Consolas", Font.BOLD, 15));
		lblBaja.setBounds(424, 27, 128, 14);
		contentPane.add(lblBaja);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel.setBounds(424, 72, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Nombre de la Pieza:");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Consolas", Font.PLAIN, 13));
		label.setBounds(424, 99, 133, 14);
		contentPane.add(label);
		
		txtIdB = new JTextField();
		txtIdB.setEditable(false);
		txtIdB.setColumns(10);
		txtIdB.setBounds(567, 72, 207, 20);
		contentPane.add(txtIdB);
		
		txtnmbrePiezaB = new JTextField();
		txtnmbrePiezaB.setEditable(false);
		txtnmbrePiezaB.setColumns(10);
		txtnmbrePiezaB.setBounds(567, 100, 207, 20);
		contentPane.add(txtnmbrePiezaB);
		
		JLabel label_1 = new JLabel("Cantidad:");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_1.setBounds(424, 126, 123, 14);
		contentPane.add(label_1);
		
		txtCantB = new JTextField();
		txtCantB.setEditable(false);
		txtCantB.setColumns(10);
		txtCantB.setBounds(567, 127, 108, 20);
		contentPane.add(txtCantB);
		
		JLabel label_2 = new JLabel("ID:");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_2.setBounds(235, 372, 46, 14);
		contentPane.add(label_2);
		
		JLabel lblModificacion = new JLabel("Modificar Pieza");
		lblModificacion.setFont(new Font("Consolas", Font.BOLD, 15));
		lblModificacion.setBounds(235, 326, 142, 14);
		contentPane.add(lblModificacion);
		
		JLabel label_4 = new JLabel("Nombre de la Pieza:");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_4.setBounds(235, 398, 142, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Cantidad:");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_5.setBounds(235, 423, 123, 14);
		contentPane.add(label_5);
		
		txtCantM = new JTextField();
		txtCantM.setEditable(false);
		txtCantM.setColumns(10);
		txtCantM.setBounds(387, 419, 122, 20);
		contentPane.add(txtCantM);
		
		txtnmbrePiezaM = new JTextField();
		txtnmbrePiezaM.setEditable(false);
		txtnmbrePiezaM.setColumns(10);
		txtnmbrePiezaM.setBounds(387, 394, 122, 20);
		contentPane.add(txtnmbrePiezaM);
		
		txtIdM = new JTextField();
		txtIdM.setColumns(10);
		txtIdM.setBounds(387, 368, 122, 20);
		contentPane.add(txtIdM);
		
		JLabel label_6 = new JLabel("Nombre de la Pieza:");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_6.setBounds(0, 72, 133, 14);
		contentPane.add(label_6);
		
		txtnmbrePiezaA = new JTextField();
		txtnmbrePiezaA.setColumns(10);
		txtnmbrePiezaA.setBounds(144, 72, 124, 20);
		contentPane.add(txtnmbrePiezaA);
		
		txtCantA = new JTextField();
		txtCantA.setColumns(10);
		txtCantA.setBounds(144, 99, 123, 20);
		contentPane.add(txtCantA);
		
		CtrlTipoPieza ctrl = new CtrlTipoPieza();
		
		JLabel label_7 = new JLabel("Cantidad:");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_7.setBounds(0, 99, 126, 14);
		contentPane.add(label_7);
		
		JButton button = new JButton("Atr\u00E1s");
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarStock ms = new ModificarStock();
				ms.setVisible(true);
			}
		});
		button.setBounds(10, 518, 155, 32);
		contentPane.add(button);
		
		JButton btnAceptarAlta = new JButton("Aceptar");
		btnAceptarAlta.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = ctrl.setPieza(txtnmbrePiezaA.getText(),Integer.parseInt(txtCantA.getText()));
				
				JOptionPane.showMessageDialog(rootPane, "Pieza agregada correctamente");
				limpiar();
			}
		});
		btnAceptarAlta.setBounds(282, 99, 89, 23);
		contentPane.add(btnAceptarAlta);
		
		JButton btnAceptarM = new JButton("Modificar");
		btnAceptarM.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoPieza p = new TipoPieza();
				p.setId(Integer.parseInt(txtIdM.getText()));
				p.setDescp(txtnmbrePiezaM.getText());
				p.setCant(Integer.parseInt(txtCantM.getText()));
				
				ctrl.actualizar(p);
				JOptionPane.showMessageDialog(rootPane, "Pieza modificada correctamente");
			}
		});
		btnAceptarM.setBounds(519, 419, 100, 23);
		contentPane.add(btnAceptarM);
		
		JButton btnBuscarEnStock = new JButton("Buscar en la tabla");
		btnBuscarEnStock.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscarEnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=2;
				StockXPieza sp = new StockXPieza(a);
				sp.setVisible(true);
				dispose();
				
			}
		});
		btnBuscarEnStock.setBounds(387, 322, 232, 23);
		contentPane.add(btnBuscarEnStock);
		
		JButton btnBuscarEnLa = new JButton("Buscar en la tabla");
		btnBuscarEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=1; 
				
				StockXPieza sp = new StockXPieza(a);
				sp.setVisible(true);
				dispose();
			}
		});
		btnBuscarEnLa.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscarEnLa.setBounds(542, 24, 232, 23);
		contentPane.add(btnBuscarEnLa);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpiar();
				
				
			}
		});
		btnLimpiar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnLimpiar.setBounds(605, 518, 155, 32);
		contentPane.add(btnLimpiar);

	}
	
	public ABMPiezas(int idRes, int a) {
		setTitle("Gesti\u00F3n de Piezas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlta = new JLabel("Nueva Pieza");
		lblAlta.setFont(new Font("Consolas", Font.BOLD, 15));
		lblAlta.setBounds(73, 27, 92, 14);
		contentPane.add(lblAlta);
		
		JLabel lblBaja = new JLabel("Eliminar Pieza");
		lblBaja.setFont(new Font("Consolas", Font.BOLD, 15));
		lblBaja.setBounds(424, 27, 128, 14);
		contentPane.add(lblBaja);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel.setBounds(424, 72, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Nombre de la Pieza:");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Consolas", Font.PLAIN, 13));
		label.setBounds(424, 99, 133, 14);
		contentPane.add(label);
		
		txtIdB = new JTextField();
		txtIdB.setColumns(10);
		txtIdB.setBounds(567, 72, 207, 20);
		contentPane.add(txtIdB);
		
		txtnmbrePiezaB = new JTextField();
		txtnmbrePiezaB.setEditable(false);
		txtnmbrePiezaB.setColumns(10);
		txtnmbrePiezaB.setBounds(567, 100, 207, 20);
		contentPane.add(txtnmbrePiezaB);
		
		JLabel label_1 = new JLabel("Cantidad:");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_1.setBounds(424, 126, 123, 14);
		contentPane.add(label_1);
		
		txtCantB = new JTextField();
		txtCantB.setEditable(false);
		txtCantB.setColumns(10);
		txtCantB.setBounds(567, 127, 108, 20);
		contentPane.add(txtCantB);
		
		JLabel label_2 = new JLabel("ID:");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_2.setBounds(235, 372, 46, 14);
		contentPane.add(label_2);
		
		JLabel lblModificacion = new JLabel("Modificar Pieza");
		lblModificacion.setFont(new Font("Consolas", Font.BOLD, 15));
		lblModificacion.setBounds(235, 326, 142, 14);
		contentPane.add(lblModificacion);
		
		JLabel label_4 = new JLabel("Nombre de la Pieza:");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_4.setBounds(235, 398, 142, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Cantidad:");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_5.setBounds(235, 423, 123, 14);
		contentPane.add(label_5);
		
		txtCantM = new JTextField();
		txtCantM.setEditable(false);
		txtCantM.setColumns(10);
		txtCantM.setBounds(387, 419, 122, 20);
		contentPane.add(txtCantM);
		
		txtnmbrePiezaM = new JTextField();
		txtnmbrePiezaM.setEditable(false);
		txtnmbrePiezaM.setColumns(10);
		txtnmbrePiezaM.setBounds(387, 394, 122, 20);
		contentPane.add(txtnmbrePiezaM);
		
		txtIdM = new JTextField();
		txtIdM.setColumns(10);
		txtIdM.setBounds(387, 368, 122, 20);
		contentPane.add(txtIdM);
		
		JLabel label_6 = new JLabel("Nombre de la Pieza:");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_6.setBounds(0, 72, 133, 14);
		contentPane.add(label_6);
		
		txtnmbrePiezaA = new JTextField();
		txtnmbrePiezaA.setColumns(10);
		txtnmbrePiezaA.setBounds(144, 72, 124, 20);
		contentPane.add(txtnmbrePiezaA);
		
		txtCantA = new JTextField();
		txtCantA.setColumns(10);
		txtCantA.setBounds(144, 99, 123, 20);
		contentPane.add(txtCantA);
		
		CtrlTipoPieza ctrl = new CtrlTipoPieza();
		
		JLabel label_7 = new JLabel("Cantidad:");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_7.setBounds(0, 99, 126, 14);
		contentPane.add(label_7);
		
		JButton btnAceptarM = new JButton("Modificar");
		btnAceptarM.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoPieza p = new TipoPieza();
				p.setId(Integer.parseInt(txtIdM.getText()));
				p.setDescp(txtnmbrePiezaM.getText());
				p.setCant(Integer.parseInt(txtCantM.getText()));
				
				ctrl.actualizar(p);
				JOptionPane.showMessageDialog(rootPane, "Pieza modificada correctamente");
			}
		});
		btnAceptarM.setBounds(519, 419, 100, 23);
		contentPane.add(btnAceptarM);
		
		JButton button = new JButton("Atr\u00E1s");
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarStock ms = new ModificarStock();
				ms.setVisible(true);
			}
		});
		button.setBounds(10, 518, 155, 32);
		contentPane.add(button);
		
		
		
		if(a==1){
		TipoPieza p = new TipoPieza();
		p=ctrl.getPiezaById(idRes);
		txtIdB.setText(String.valueOf(p.getId()));
		txtnmbrePiezaB.setText(p.getDescp());
		txtCantB.setText(String.valueOf(p.getCant()));}
		
		if(a==2){
			TipoPieza p = new TipoPieza();
			p=ctrl.getPiezaById(idRes);
			txtIdM.setText(String.valueOf(p.getId()));
			txtnmbrePiezaM.setText(p.getDescp());
			txtCantM.setText(String.valueOf(p.getCant()));
			txtnmbrePiezaM.setEditable(true);
			txtCantM.setEditable(true);
			
			}
		
		
		JButton btnAceptarAlta = new JButton("Aceptar");
		btnAceptarAlta.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = ctrl.setPieza(txtnmbrePiezaA.getText(),Integer.parseInt(txtCantA.getText()));
				
				JOptionPane.showMessageDialog(rootPane, "Pieza agregada correctamente");
			}
		});
		btnAceptarAlta.setBounds(282, 99, 89, 23);
		contentPane.add(btnAceptarAlta);
		
		JButton btnAceptarBaja = new JButton("Aceptar");
		btnAceptarBaja.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int op=JOptionPane.showConfirmDialog(rootPane, "¿Desea eliminar la pieza "+txtIdB.getText()+"?");
				if(op==0){
				try {
					ctrl.deletePieza(Integer.parseInt(txtIdB.getText()));
					JOptionPane.showMessageDialog(rootPane,"Pieza Eliminada correctamente.");
					limpiar();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MySqlError e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(rootPane, e.getMensajeDeError());
					limpiar();
				}
				}
				
			}
		});
		btnAceptarBaja.setBounds(685, 125, 89, 23);
		contentPane.add(btnAceptarBaja);
		
	

		
		JButton btnBuscarEnStock = new JButton("Buscar en la tabla");
		btnBuscarEnStock.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscarEnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a =2; 
				
				StockXPieza sp = new StockXPieza(a);
				sp.setVisible(true);
				//int pieza = sp.getPieza();
				//System.out.println(pieza);
				dispose();}
		});
		btnBuscarEnStock.setBounds(387, 322, 232, 23);
		contentPane.add(btnBuscarEnStock);
	
		
		
		

		JButton button_2 = new JButton("Buscar en la tabla");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a =1; 
				
				StockXPieza sp = new StockXPieza(a);
				sp.setVisible(true);
				//int pieza = sp.getPieza();
				//System.out.println(pieza);
				dispose();
			}
		});
		button_2.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_2.setBounds(542, 24, 232, 23);
		contentPane.add(button_2);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		limpiar();
				
				
			}
		});
		btnLimpiar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnLimpiar.setBounds(605, 518, 155, 32);
		contentPane.add(btnLimpiar);
	}
	protected void limpiar() {
		txtCantA.setText("");
		txtCantB.setText("");
		txtCantM.setText("");
		
		txtIdB.setText("");
		txtIdM.setText("");
		
		txtnmbrePiezaA.setText("");
		txtnmbrePiezaB.setText("");
		txtnmbrePiezaM.setText("");
		
	}
}
