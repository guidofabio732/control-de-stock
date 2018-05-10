package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import customException.MySqlError;
import entities.MaquinaPieza;
import entities.TipoPieza;

public class DataMaquinaPieza {

	public ArrayList<MaquinaPieza> getMaquinasPiezas(int id) {
		MaquinaPieza maqpieza = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList <MaquinaPieza> arrayMaqpieza = new ArrayList <MaquinaPieza>();	
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select mp.id_pieza,tp.descp,mp.cant from maquina_pieza mp inner join tipo_pieza tp on tp.id = mp.id_pieza where mp.id_maquina = ? order by descp");
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			while (rs != null && rs.next()){
				maqpieza = new MaquinaPieza();
				maqpieza.setIdPieza(rs.getInt("id_pieza"));
				maqpieza.setDescp(rs.getString("descp"));
				maqpieza.setCant(rs.getInt("cant"));
				arrayMaqpieza.add(maqpieza);							
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
		
		return arrayMaqpieza;
	}

	public void setMaquinaPieza(int idMaquina, int idPieza, int cant) {
		PreparedStatement stmt=null;		
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into maquina_pieza(id_maquina,id_pieza,cant) VALUES (?,?,?)");
			stmt.setInt(1,idMaquina);
			stmt.setInt(2,idPieza);
			stmt.setInt(3,cant);
			
			stmt.executeUpdate();		 
		} catch (SQLException e) {
			e.printStackTrace();
        }
		try {
		
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();}
	
		
	}

	public void deleteMaquinaPieza(int id,int idMaqui) {
PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from maquina_pieza where id_pieza=? and id_maquina=?");
			stmt.setInt(1, id );
			stmt.setInt(2, idMaqui);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
	    }
		
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
