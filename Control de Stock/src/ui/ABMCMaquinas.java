package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.CtrlTipoMaquina;
import customException.MySqlError;
import entities.TipoMaquina;

import javax.swing.JScrollPane;
import java.awt.Color;

public class ABMCMaquinas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreN;
	private JTextField txtNombreE;
	private JTextField txtIdE;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ABMCMaquinas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevaMquina = new JLabel("Nueva M\u00E1quina");
		lblNuevaMquina.setForeground(new Color(0, 0, 0));
		lblNuevaMquina.setBackground(new Color(0, 0, 0));
		lblNuevaMquina.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNuevaMquina.setBounds(73, 49, 113, 14);
		contentPane.add(lblNuevaMquina);
		
		JLabel lblNombreDeLa = new JLabel("Nombre:");
		lblNombreDeLa.setForeground(new Color(255, 255, 255));
		lblNombreDeLa.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNombreDeLa.setBounds(10, 94, 133, 14);
		contentPane.add(lblNombreDeLa);
		
		txtNombreN = new JTextField();
		txtNombreN.setColumns(10);
		txtNombreN.setBounds(154, 94, 124, 20);
		contentPane.add(txtNombreN);
		
		CtrlTipoMaquina ctrl = new CtrlTipoMaquina();
		ArrayList<TipoMaquina> maquinas = ctrl.getMaquinas();
		
		Object nombreColumnas[] = { "Id" , "Nombre"};
		Object datos[][] = new String[maquinas.size()][nombreColumnas.length]; 
		
for (int x = 0; x < maquinas.size(); x++) {
			
			datos [x][0] = String.valueOf(maquinas.get(x).getId());
			
			datos [x][1] = String.valueOf(maquinas.get(x).getDescp());}
		
		JButton AceptarN = new JButton("Aceptar");
		AceptarN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=ctrl.setMaquina(txtNombreN.getText());
				if(id==0){
					JOptionPane.showMessageDialog(rootPane, "No fue posible agregar la máquina");
				}
				else{
				
				dispose();
				ABMCMaquinas am = new ABMCMaquinas();
				am.setVisible(true);
				
				}
			}
		});
		AceptarN.setFont(new Font("Consolas", Font.PLAIN, 13));
		AceptarN.setBounds(288, 94, 89, 23);
		contentPane.add(AceptarN);
		
		JLabel lblEliminarMquina = new JLabel("Eliminar M\u00E1quina");
		lblEliminarMquina.setForeground(new Color(0, 0, 0));
		lblEliminarMquina.setFont(new Font("Consolas", Font.BOLD, 15));
		lblEliminarMquina.setBounds(480, 49, 128, 14);
		contentPane.add(lblEliminarMquina);
		
		JLabel label_5 = new JLabel("ID:");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Consolas", Font.PLAIN, 13));
		label_5.setBounds(424, 94, 133, 14);
		contentPane.add(label_5);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNombre.setBounds(424, 121, 133, 14);
		contentPane.add(lblNombre);
		
		txtNombreE = new JTextField();
		txtNombreE.setEditable(false);
		txtNombreE.setColumns(10);
		txtNombreE.setBounds(567, 122, 108, 20);
		contentPane.add(txtNombreE);
		
		txtIdE = new JTextField();
		txtIdE.setColumns(10);
		txtIdE.setBounds(567, 90, 108, 24);
		contentPane.add(txtIdE);
		
		JButton AceptarE = new JButton("Aceptar");
		AceptarE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int op=JOptionPane.showConfirmDialog(rootPane, "Desea Eliminar la Máquina");
				if(op==0){
				try {
					ctrl.deleteMaquina(Integer.parseInt(txtIdE.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MySqlError e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(rootPane, e.getMensajeDeError());
				}
				dispose();
				ABMCMaquinas am = new ABMCMaquinas();
				am.setVisible(true);}
			
				
				
				
				
			}
		});
		AceptarE.setFont(new Font("Consolas", Font.PLAIN, 13));
		AceptarE.setBounds(685, 121, 89, 23);
		contentPane.add(AceptarE);
		
		JButton button_4 = new JButton("Atr\u00E1s");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarStock ms = new ModificarStock();
				ms.setVisible(true);
			}
		});
		button_4.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_4.setBounds(10, 518, 155, 32);
		contentPane.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 188, 526, 303);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
	
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre;
				nombre=ctrl.getMaquina(Integer.parseInt(txtIdE.getText()));
				txtNombreE.setText(nombre);
			}
		});
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscar.setBounds(685, 90, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblelIdSe = new JLabel("*El ID se autogenera");
		lblelIdSe.setForeground(new Color(255, 255, 255));
		lblelIdSe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblelIdSe.setBounds(0, 11, 146, 14);
		contentPane.add(lblelIdSe);
	}
}
