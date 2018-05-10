package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import customException.MySqlError;
import entities.TipoMaquina;
import entities.TipoPieza;

public class DataTipoMaquina {

	public int setMaquina(String nombre) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		int id=0;
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into tipo_maquina(descp) VALUES (?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nombre );
			
			 stmt.executeUpdate();
			 keyResultSet=stmt.getGeneratedKeys();
			 if(keyResultSet!=null && keyResultSet.next()){
				  id =keyResultSet.getInt(1);
			 			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
        }
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();}
		return id;
		
	}

	public ArrayList<TipoMaquina> getMaquinas() {
		TipoMaquina maquina = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList <TipoMaquina> arrayMaquinas = new ArrayList <TipoMaquina>();	
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT * FROM control_de_stock.tipo_Maquina order by descp");
		
		rs = stmt.executeQuery();
			while (rs != null && rs.next()){
				maquina = new TipoMaquina();
				maquina.setId(rs.getInt("id"));
				maquina.setDescp(rs.getString("descp"));
				
				arrayMaquinas.add(maquina);
				
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return arrayMaquinas;
	}

	public String getMaquina(int id) {		
		String maquina = null;
		ResultSet rs = null;
PreparedStatement stmt = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select descp FROM tipo_maquina where id=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
			if (rs != null && rs.next()){
				
               	maquina=rs.getString("descp");
				
		
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return maquina;
	}

	public void deleteMaquina(int id) throws MySqlError{
PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from tipo_maquina where id=?");
			stmt.setInt(1, id );
			 stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new MySqlError("No se puede eliminar la máquina debido a que está relacionada con piezas.");
	    }
		
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
