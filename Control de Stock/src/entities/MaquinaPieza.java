package entities;

public class MaquinaPieza {
	private int idPieza;
	private int cant;
	private int idMaquina;
	private String descp;
	
	public int getIdPieza() {
		return idPieza;
	}
	public void setIdPieza(int idPieza) {
		this.idPieza = idPieza;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public int getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
}
