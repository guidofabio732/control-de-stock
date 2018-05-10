package controlers;

import java.util.ArrayList;

import javax.swing.JTextField;

import customException.MySqlError;
import data.DataTipoMaquina;
import entities.TipoMaquina;

public class CtrlTipoMaquina {
	DataTipoMaquina data = new DataTipoMaquina();
	public int setMaquina(String nombre) {
		int id=data.setMaquina(nombre);
		return id;
	}
	public ArrayList<TipoMaquina> getMaquinas() {
		ArrayList<TipoMaquina> maquinas = data.getMaquinas();
		return maquinas;
	}
	public String getMaquina(int id) {
		String nombre=data.getMaquina(id);
		return nombre;
	}
	public void deleteMaquina(int id) throws MySqlError {
		data.deleteMaquina(id);
		
	}


}
