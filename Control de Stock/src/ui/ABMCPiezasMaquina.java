package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.CtrlMaquinaPieza;
import controlers.CtrlTipoMaquina;
import controlers.CtrlTipoPieza;
import entities.MaquinaPieza;
import entities.TipoMaquina;
import entities.TipoPieza;

import javax.swing.JScrollPane;

public class ABMCPiezasMaquina extends JFrame {

	private JPanel contentPane;
	private JTextField txtPieza;
	private JTextField txtCant;
	private JTable table;
	TipoMaquina maq2 = null;

	
	
	public ABMCPiezasMaquina() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Consolas", Font.PLAIN, 13));
		comboBox.setBounds(208, 33, 167, 20);
		contentPane.add(comboBox);
		
		CtrlTipoMaquina ctrl = new CtrlTipoMaquina();
		ArrayList<TipoMaquina> maquinas = ctrl.getMaquinas();
		comboBox.addItem("Seleccione Máquina:");
		for (TipoMaquina m : maquinas) {
			comboBox.addItem(m.getDescp());
		}
		
		JLabel lblMquina = new JLabel("M\u00E1quina:");
		lblMquina.setForeground(new Color(255, 255, 255));
		lblMquina.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblMquina.setBounds(119, 35, 72, 18);
		contentPane.add(lblMquina);
		
		JLabel lblPieza = new JLabel("Pieza:");
		lblPieza.setForeground(new Color(255, 255, 255));
		lblPieza.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPieza.setBounds(404, 38, 49, 18);
		contentPane.add(lblPieza);
		
		txtPieza = new JTextField();
		txtPieza.setEditable(false);
		txtPieza.setBounds(460, 35, 86, 20);
		contentPane.add(txtPieza);
		txtPieza.setColumns(10);
		
		CtrlMaquinaPieza ctrlMP = new CtrlMaquinaPieza();
		
		JButton btnBuscar = new JButton("Buscar ID");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = "3";
				StockXPieza sp = new StockXPieza(a);
				sp.setVisible(true);	
				
				
			}
		});
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscar.setBounds(404, 66, 136, 23);
		contentPane.add(btnBuscar);
		
		
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane txt = new JScrollPane();
				txt.setBounds(10, 100, 764, 408);
				contentPane.add(txt);
				TipoMaquina maq=null;
				if("Seleccione Máquina:".equals(comboBox.getSelectedItem())){
				
					JOptionPane.showMessageDialog(rootPane,
						    "No selecciono ningun tipo", 
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else{
				for (TipoMaquina m : maquinas) {
					if(m.getDescp().equals(comboBox.getSelectedItem())){
						maq = m;
						
						
					}
				}
				maq2=maq;
				ArrayList<MaquinaPieza> maquinaPiezas = ctrlMP.getMaquinaPiezas(maq.getId());
				Object nombreColumnas[] = { "Id Pieza" , "Descripción", "Cantidad"};
				Object datos[][] = new String[maquinaPiezas.size()][nombreColumnas.length]; 
				
		for (int x = 0; x < maquinaPiezas.size(); x++) {
					
					datos [x][0] = String.valueOf(maquinaPiezas.get(x).getIdPieza());
					
					datos [x][1] = String.valueOf(maquinaPiezas.get(x).getDescp());
					
					datos [x][2] = String.valueOf(maquinaPiezas.get(x).getCant());
		}
				table = new JTable();
				table.setModel(
						new DefaultTableModel(datos,nombreColumnas));
				txt.setViewportView(table);
				
				comboBox.setEnabled(false);
				btnNewButton_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				txtPieza.setEditable(true);
				txtCant.setEditable(true);
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnNewButton_1.setBounds(119, 66, 256, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(new Color(255, 255, 255));
		lblCantidad.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblCantidad.setBounds(560, 38, 72, 18);
		contentPane.add(lblCantidad);
		
		txtCant = new JTextField();
		txtCant.setEditable(false);
		txtCant.setBounds(633, 35, 86, 20);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoMaquina maq2=null;
				for (TipoMaquina m : maquinas) {
					if(m.getDescp().equals(comboBox.getSelectedItem())){
						maq2 = m;
					}
				}
				ctrlMP.setMaquinaPieza(maq2.getId(),Integer.parseInt(txtPieza.getText()),Integer.parseInt(txtCant.getText()));
				dispose();
				ABMCPiezasMaquina a = new ABMCPiezasMaquina();
				a.setVisible(true);
			}
		});
		btnIngresar.setBackground(new Color(50, 205, 50));
		btnIngresar.setFont(new Font("Consolas", Font.BOLD, 13));
		btnIngresar.setBounds(559, 65, 96, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblbuscarIdDe = new JLabel("*Buscar ID de pieza en la tabla");
		lblbuscarIdDe.setForeground(new Color(255, 255, 255));
		lblbuscarIdDe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblbuscarIdDe.setBounds(394, 11, 146, 14);
		contentPane.add(lblbuscarIdDe);
		
		JButton button = new JButton("Atr\u00E1s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarStock ms = new ModificarStock();
				ms.setVisible(true);
			}
		});
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.setBounds(10, 518, 155, 32);
		contentPane.add(button);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setEnabled(true);
				btnNewButton_1.setEnabled(true);
				btnBuscar.setEnabled(false);
				txtPieza.setEditable(false);
				txtCant.setEditable(false);
			}
		});
		btnLimpiar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnLimpiar.setBounds(590, 518, 155, 32);
		contentPane.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TipoMaquina maq3=null;
				for (TipoMaquina m : maquinas) {
					if(m.getDescp().equals(comboBox.getSelectedItem())){
						maq3 = m;
					}
				}
				
				boolean existe = ctrlMP.deleteMP(Integer.parseInt(txtPieza.getText()),maq3.getId());
				if(existe==false){
					JOptionPane.showMessageDialog(rootPane, "El id no corresponde a una pieza de la máquina");
				}
				if(existe){
					JOptionPane.showMessageDialog(rootPane, "Se ha eliminado la asociación de la pieza con la máquina");
					dispose();
					ABMCPiezasMaquina a = new ABMCPiezasMaquina();
					a.setVisible(true);
				}
			}
		});
		btnEliminar.setFont(new Font("Consolas", Font.BOLD, 13));
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setBounds(661, 65, 96, 23);
		contentPane.add(btnEliminar);
		
		
	}



		public ABMCPiezasMaquina(int idRes) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,82,5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Consolas", Font.PLAIN, 13));
		comboBox.setBounds(208, 33, 167, 20);
		contentPane.add(comboBox);
		
		CtrlTipoMaquina ctrl = new CtrlTipoMaquina();
		ArrayList<TipoMaquina> maquinas = ctrl.getMaquinas();
		comboBox.addItem("Seleccione Máquina:");
		for (TipoMaquina m : maquinas) {
			comboBox.addItem(m.getDescp());
		}
		
		JLabel lblMquina = new JLabel("M\u00E1quina:");
		lblMquina.setForeground(new Color(255, 255, 255));
		lblMquina.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblMquina.setBounds(119, 35, 72, 18);
		contentPane.add(lblMquina);
		
		JLabel lblPieza = new JLabel("Pieza:");
		lblPieza.setForeground(new Color(255, 255, 255));
		lblPieza.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPieza.setBounds(404, 38, 49, 18);
		contentPane.add(lblPieza);
		
		txtPieza = new JTextField();
		txtPieza.setEditable(false);
		txtPieza.setBounds(460, 35, 86, 20);
		contentPane.add(txtPieza);
		txtPieza.setColumns(10);
		
		CtrlMaquinaPieza ctrlMP = new CtrlMaquinaPieza();
		CtrlTipoPieza ctrl1 = new CtrlTipoPieza();
		TipoPieza p = new TipoPieza();
		p=ctrl1.getPiezaById(idRes);
		txtPieza.setText(p.getDescp());
		JButton btnBuscar = new JButton("Buscar ID");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = "3";
				StockXPieza sp = new StockXPieza(a);
				sp.setVisible(true);	
			}
		});
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnBuscar.setBounds(404, 66, 136, 23);
		contentPane.add(btnBuscar);
		
		
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane txt = new JScrollPane();
				txt.setBounds(10, 100, 764, 408);
				contentPane.add(txt);
				TipoMaquina maq=null;
				if("Seleccione Máquina:".equals(comboBox.getSelectedItem())){
				
					JOptionPane.showMessageDialog(rootPane,
						    "No selecciono ningun tipo", 
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else{
				for (TipoMaquina m : maquinas) {
					if(m.getDescp().equals(comboBox.getSelectedItem())){
						maq = m;
						
					}
				}
				
				ArrayList<MaquinaPieza> maquinaPiezas = ctrlMP.getMaquinaPiezas(maq.getId());
				Object nombreColumnas[] = { "Id Pieza" , "Descripción", "Cantidad"};
				Object datos[][] = new String[maquinaPiezas.size()][nombreColumnas.length]; 
				
		for (int x = 0; x < maquinaPiezas.size(); x++) {
					
					datos [x][0] = String.valueOf(maquinaPiezas.get(x).getIdPieza());
					
					datos [x][1] = String.valueOf(maquinaPiezas.get(x).getDescp());
					
					datos [x][2] = String.valueOf(maquinaPiezas.get(x).getCant());
		}
				table = new JTable();
				table.setModel(
						new DefaultTableModel(datos,nombreColumnas));
				txt.setViewportView(table);
				
				comboBox.setEnabled(false);
				btnNewButton_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				txtPieza.setEditable(true);
				txtCant.setEditable(true);
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnNewButton_1.setBounds(119, 66, 256, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(new Color(255, 255, 255));
		lblCantidad.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblCantidad.setBounds(560, 38, 72, 18);
		contentPane.add(lblCantidad);
		
		txtCant = new JTextField();
		txtCant.setEditable(false);
		txtCant.setBounds(633, 35, 86, 20);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoMaquina maq2=null;
				for (TipoMaquina m : maquinas) {
					if(m.getDescp().equals(comboBox.getSelectedItem())){
						maq2 = m;
					}
				}
				ctrlMP.setMaquinaPieza(maq2.getId(),Integer.parseInt(txtPieza.getText()),Integer.parseInt(txtCant.getText()));
				dispose();
				ABMCPiezasMaquina a = new ABMCPiezasMaquina();
				a.setVisible(true);
			}
		});
		btnIngresar.setBackground(new Color(50, 205, 50));
		btnIngresar.setFont(new Font("Consolas", Font.BOLD, 13));
		btnIngresar.setBounds(559, 65, 96, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblbuscarIdDe = new JLabel("*Buscar ID de pieza en la tabla");
		lblbuscarIdDe.setForeground(new Color(255, 255, 255));
		lblbuscarIdDe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblbuscarIdDe.setBounds(394, 11, 146, 14);
		contentPane.add(lblbuscarIdDe);
		
		JButton button = new JButton("Atr\u00E1s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarStock ms = new ModificarStock();
				ms.setVisible(true);
			}
		});
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.setBounds(10, 518, 155, 32);
		contentPane.add(button);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setEnabled(true);
				btnNewButton_1.setEnabled(true);
				btnBuscar.setEnabled(false);
				txtPieza.setEditable(false);
				txtCant.setEditable(false);
			}
		});
		btnLimpiar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnLimpiar.setBounds(590, 518, 155, 32);
		contentPane.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TipoMaquina maq3=null;
				for (TipoMaquina m : maquinas) {
					if(m.getDescp().equals(comboBox.getSelectedItem())){
						maq3 = m;
					}
				}
				
				boolean existe = ctrlMP.deleteMP(Integer.parseInt(txtPieza.getText()),maq3.getId());
				if(existe==false){
					JOptionPane.showMessageDialog(rootPane, "El id no corresponde a una pieza de la máquina");
				}
				if(existe){
					JOptionPane.showMessageDialog(rootPane, "Se ha eliminado la asociación de la pieza con la máquina");
					dispose();
					ABMCPiezasMaquina a = new ABMCPiezasMaquina();
					a.setVisible(true);
				}
			}
		});
		btnEliminar.setFont(new Font("Consolas", Font.BOLD, 13));
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setBounds(661, 65, 96, 23);
		contentPane.add(btnEliminar);
		
		
	}
		
}
