package controlers;

import java.util.ArrayList;

import data.DataMaquinaPieza;
import data.DataTipoPieza;
import entities.MaquinaPieza;
import entities.TipoPieza;

public class CtrlMaquinaPieza {
	DataMaquinaPieza data = new DataMaquinaPieza();
	DataTipoPieza datatp= new DataTipoPieza();
	public ArrayList<MaquinaPieza> getMaquinaPiezas(int id) {
		ArrayList<MaquinaPieza> maquinasPiezas = data.getMaquinasPiezas(id);
		
		return maquinasPiezas;
	}
	public void setMaquinaPieza(int idMaquina, int idPieza, int cant) {
		data.setMaquinaPieza(idMaquina,idPieza,cant);
		
	}
	public boolean getDisp(int id) {
		//aca agarrar las piezas que necesita la maquina, agarrar las piezas , y comparar cantidades devolver el boolean 
		//correspondiente
		ArrayList<MaquinaPieza> maquinasPiezas2 = data.getMaquinasPiezas(id);
		ArrayList<TipoPieza> piezas = datatp.getPiezas();
		boolean flag=false;
		for (MaquinaPieza mp : maquinasPiezas2) {
			for (TipoPieza p : piezas) {
				if(p.getId()==mp.getIdPieza()){
					if(p.getCant()<mp.getCant()){
						flag=true;
					}
				}
			}
		}
		
		return flag;
	}
	public void actualizarStock(int id) {
		ArrayList<MaquinaPieza> maquinasPiezas2 = data.getMaquinasPiezas(id);
		datatp.actualizarStock(maquinasPiezas2);
		
		
		
	}
	public boolean deleteMP(int id,int idMaqui) {
		boolean existe=false;
		ArrayList<TipoPieza> piezas = datatp.getPiezas();
		for (TipoPieza tp : piezas) {
			if(tp.getId()==id){
				existe=true;
				break;
			}
		}
		if(existe){
			data.deleteMaquinaPieza(id,idMaqui);
		}
		
		return existe;
	}


}
