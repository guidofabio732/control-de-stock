package controlers;

import java.util.ArrayList;

import customException.MySqlError;
import data.DataTipoPieza;
import entities.TipoPieza;

public class CtrlTipoPieza {
	DataTipoPieza data = new DataTipoPieza();
	public ArrayList<TipoPieza> getPiezas() {
		ArrayList<TipoPieza> piezas = data.getPiezas();
		return piezas;
	}
	public ArrayList<TipoPieza> getPiezasFiltradas(String palabra) {
		ArrayList<TipoPieza> piezasFiltradas = data.getPiezasFiltradas(palabra);
		return piezasFiltradas;
	}
	public int setPieza(String text, int cant) {
		int id = data.setPieza(text,cant);
		return id;
	}
	public void deletePieza(int id) throws MySqlError {
		// TODO Auto-generated method stub
		data.deletePieza(id);
	}
	public TipoPieza getPiezaById(int id) {
		TipoPieza p = data.getPiezaById(id);
		return p;
	}
	public void actualizar(TipoPieza p) {
		data.actualizar(p);
		
	}

}
