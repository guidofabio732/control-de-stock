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
public class StockXPiezaFiltrada extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String pal;
	
	public void setPalabra(String text) {
		pal=text;
		
	}
	public StockXPiezaFiltrada(String text,int a) {
		setTitle("Consulta de stock por nombre de pieza");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CtrlTipoPieza ctrlP = new CtrlTipoPieza();
		this.setPalabra(text);
		
		
		ArrayList<TipoPieza> piezas2 = ctrlP.getPiezasFiltradas(pal);
		
	
		
		Object nombreColumnas[] = { "Id Pieza" , "Descripción", "Cantidad"};
		Object datos[][] = new String[piezas2.size()][nombreColumnas.length]; 
		
for (int x = 0; x < piezas2.size(); x++) {
			
			datos [x][0] = String.valueOf(piezas2.get(x).getId());
			
			datos [x][1] = String.valueOf(piezas2.get(x).getDescp());
			
			datos [x][2] = String.valueOf(piezas2.get(x).getCant());
}
		
	JScrollPane txt = new JScrollPane();
		txt.setBounds(0, 11, 784, 496);
		contentPane.add(txt);
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		txt.setViewportView(table);
		
		JButton btnAtrás = new JButton("Atr\u00E1s");
		btnAtrás.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
			}
		});
		btnAtrás.setBounds(10, 518, 155, 32);
		contentPane.add(btnAtrás);
	}

	public StockXPiezaFiltrada(String text) {
		setTitle("Consulta de stock por nombre de pieza");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CtrlTipoPieza ctrlP = new CtrlTipoPieza();
		this.setPalabra(text);
		
		
		ArrayList<TipoPieza> piezas2 = ctrlP.getPiezasFiltradas(pal);
		
	
		
		Object nombreColumnas[] = { "Id Pieza" , "Descripción", "Cantidad"};
		Object datos[][] = new String[piezas2.size()][nombreColumnas.length]; 
		
for (int x = 0; x < piezas2.size(); x++) {
			
			datos [x][0] = String.valueOf(piezas2.get(x).getId());
			
			datos [x][1] = String.valueOf(piezas2.get(x).getDescp());
			
			datos [x][2] = String.valueOf(piezas2.get(x).getCant());
}
		
	JScrollPane txt = new JScrollPane();
		txt.setBounds(0, 11, 784, 496);
		contentPane.add(txt);
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		txt.setViewportView(table);
		
		JButton btnAtrás = new JButton("Atr\u00E1s");
		btnAtrás.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StockXPieza s = new StockXPieza();
				s.setVisible(true);
				dispose();
			}
		});
		btnAtrás.setBounds(10, 518, 155, 32);
		contentPane.add(btnAtrás);
	}
}
