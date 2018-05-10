package customException;

public class MySqlError extends Exception{
	private String mensajeDeError;
	public MySqlError(String sms){
		setMensajeDeError(sms);
	}
	
	private void setMensajeDeError(String sms) {
		mensajeDeError=sms;
		
	}
	public String getMensajeDeError(){
		return mensajeDeError;
	}
}
