package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import controlers.CtrlTipoPieza;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import entities.TipoPieza;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
public class StockXPieza extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtFiltrar;
	int pieza=0;

	public StockXPieza() {
		setTitle("Consulta de stock por nombre de pieza");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CtrlTipoPieza ctrlP = new CtrlTipoPieza();
		ArrayList<TipoPieza> piezas = ctrlP.getPiezas();
		
	
		
		Object nombreColumnas[] = { "Id Pieza" , "Descripción", "Cantidad"};
		Object datos[][] = new String[piezas.size()][nombreColumnas.length]; 
		
for (int x = 0; x < piezas.size(); x++) {
			
			datos [x][0] = String.valueOf(piezas.get(x).getId());
			
			datos [x][1] = String.valueOf(piezas.get(x).getDescp());
			
			datos [x][2] = String.valueOf(piezas.get(x).getCant());
}
		
	JScrollPane txt = new JScrollPane();
		txt.setBounds(0, 36, 784, 468);
		contentPane.add(txt);
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		txt.setViewportView(table);
		
		JLabel label = new JLabel("Filtrar:");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Consolas", Font.PLAIN, 13));
		label.setBounds(10, 11, 61, 14);
		contentPane.add(label);
		
		txtFiltrar = new JTextField();
		txtFiltrar.setColumns(10);
		txtFiltrar.setBounds(81, 7, 136, 20);
		contentPane.add(txtFiltrar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StockXPiezaFiltrada sf=new StockXPiezaFiltrada(txtFiltrar.getText());			
				sf.setVisible(true);
				dispose();
			}
		});
		btnAceptar.setBounds(227, 7, 136, 23);
		contentPane.add(btnAceptar);
		
		JButton button = new JButton("Atr\u00E1s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		button.setBounds(0, 515, 155, 32);
		contentPane.add(button);
	}
	
	
	
	
	
	
	
	
	
	
	
	public StockXPieza(int a) {
		setTitle("Consulta de stock por nombre de pieza");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CtrlTipoPieza ctrlP = new CtrlTipoPieza();
		ArrayList<TipoPieza> piezas = ctrlP.getPiezas();
		
	
		
		Object nombreColumnas[] = { "Id Pieza" , "Descripción", "Cantidad"};
		Object datos[][] = new String[piezas.size()][nombreColumnas.length]; 
		
for (int x = 0; x < piezas.size(); x++) {
			
			datos [x][0] = String.valueOf(piezas.get(x).getId());
			
			datos [x][1] = String.valueOf(piezas.get(x).getDescp());
			
			datos [x][2] = String.valueOf(piezas.get(x).getCant());
}
		
	JScrollPane txt = new JScrollPane();
		txt.setBounds(0, 36, 784, 468);
		contentPane.add(txt);
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		txt.setViewportView(table);
		

		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row;
				row=table.getSelectedRow();
				int idRes;
				idRes=Integer.parseInt((String) table.getModel().getValueAt(row,0));
				
				ABMPiezas ab = new ABMPiezas(idRes,a);
				ab.setVisible(true);
				dispose();
				
			}

			
		});
		btnSeleccionar.setBounds(604, 515, 155, 32);
		contentPane.add(btnSeleccionar);
	}
	public StockXPieza(String h) {
		setTitle("Consulta de stock por nombre de pieza");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CtrlTipoPieza ctrlP = new CtrlTipoPieza();
		ArrayList<TipoPieza> piezas = ctrlP.getPiezas();
		
	
		
		Object nombreColumnas[] = { "Id Pieza" , "Descripción", "Cantidad"};
		Object datos[][] = new String[piezas.size()][nombreColumnas.length]; 
		
for (int x = 0; x < piezas.size(); x++) {
			
			datos [x][0] = String.valueOf(piezas.get(x).getId());
			
			datos [x][1] = String.valueOf(piezas.get(x).getDescp());
			
			datos [x][2] = String.valueOf(piezas.get(x).getCant());
}
		
	JScrollPane txt = new JScrollPane();
		txt.setBounds(0, 36, 784, 468);
		contentPane.add(txt);
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		txt.setViewportView(table);
		
		JLabel label = new JLabel("Filtrar:");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Consolas", Font.PLAIN, 13));
		label.setBounds(10, 11, 61, 14);
		contentPane.add(label);
		
		txtFiltrar = new JTextField();
		txtFiltrar.setColumns(10);
		txtFiltrar.setBounds(81, 7, 136, 20);
		contentPane.add(txtFiltrar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a= 1;
				StockXPiezaFiltrada sf=new StockXPiezaFiltrada(txtFiltrar.getText(),a);			
				sf.setVisible(true);
				dispose();
			}
		});
		btnAceptar.setBounds(227, 7, 136, 23);
		contentPane.add(btnAceptar);
		
		JButton button = new JButton("Atr\u00E1s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		button.setBounds(0, 515, 155, 32);
		contentPane.add(button);
	}
}
