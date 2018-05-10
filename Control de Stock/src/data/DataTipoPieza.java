package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import customException.MySqlError;
import entities.MaquinaPieza;
import entities.TipoPieza;

public class DataTipoPieza {

	public ArrayList<TipoPieza> getPiezas() {
		

		TipoPieza pieza = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList <TipoPieza> arrayPiezas = new ArrayList <TipoPieza>();	
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT id,descp,cant FROM control_de_stock.tipo_pieza order by descp");
		
		rs = stmt.executeQuery();
			while (rs != null && rs.next()){
				pieza = new TipoPieza();
				pieza.setId(rs.getInt("id"));
				pieza.setDescp(rs.getString("descp"));
				pieza.setCant(rs.getInt("cant"));
				arrayPiezas.add(pieza);
				
				
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
		
		return arrayPiezas;
	}

	public ArrayList<TipoPieza> getPiezasFiltradas(String palabra) {
		// TODO Auto-generated method stub
		TipoPieza pieza = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList <TipoPieza> arrayPiezasFiltradas = new ArrayList <TipoPieza>();	
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from tipo_pieza where descp like ? order by descp");
			stmt.setString(1,palabra + "%");
		rs = stmt.executeQuery();
			while (rs != null && rs.next()){
				pieza = new TipoPieza();
				pieza.setId(rs.getInt("id"));
				pieza.setDescp(rs.getString("descp"));
				pieza.setCant(rs.getInt("cant"));
				arrayPiezasFiltradas.add(pieza);
				
				
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
		
		return arrayPiezasFiltradas;}

	public int setPieza(String text, int cant) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		int id=0;
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into tipo_pieza(descp, cant ) VALUES (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, text );
			stmt.setInt(2, cant );
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

	public void deletePieza(int id) throws MySqlError {
		// TODO Auto-generated method stub
PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from tipo_pieza where id=?");
			stmt.setInt(1, id );
			 stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new MySqlError("No se puede eliminar pieza debido a que esta relacionada con una máquina.");
	    }
		
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TipoPieza getPiezaById(int id) {
		TipoPieza pieza = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * FROM tipo_pieza where id=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
			if (rs != null && rs.next()){
				pieza = new TipoPieza();
				
				pieza.setId(rs.getInt("id"));
				
				pieza.setDescp(rs.getString("descp"));
				
				pieza.setCant(rs.getInt("cant"));
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
		
		return pieza;
	}

	public void actualizar(TipoPieza p) {
PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update tipo_pieza set  descp = ?, cant=? WHERE id = ?");
			stmt.setString(1, p.getDescp());
			
			stmt.setInt(2, p.getCant());
			stmt.setInt(3, p.getId());
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

	public void actualizarStock(ArrayList<MaquinaPieza> maquinasPiezas2) {
		for (MaquinaPieza mp : maquinasPiezas2) {
			PreparedStatement stmt=null;
			
			try{
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update tipo_pieza set cant=(cant-?) where id=?");
				stmt.setInt(1, mp.getCant() );
				stmt.setInt(2, mp.getIdPieza() );
			
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
	
}
