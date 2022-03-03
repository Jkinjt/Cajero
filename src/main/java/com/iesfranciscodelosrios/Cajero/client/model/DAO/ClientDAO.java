package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.model.Operator;
import com.iesfranciscodelosrios.Cajero.utils.conexionBD;

public class ClientDAO extends ClientBanco {
	
	
	public ClientDAO() {
		
	}
	
	
	public ClientDAO(int id, String name,String password) {
		super(id,name,password);
	}
	
	public ClientDAO(String name,String password) {
		super(name,password);
	}
	
	
	private final static String GUARDAR = "INSERT INTO clientbanco (nombre, password) VALUES (?,?)";

	private final static String SELECTBYNAME="SELECT * FROM clientbanco WHERE nombre=?";
	

	public boolean guardarCliente(String usuario, String password) {
		boolean valid = false;
		int rs = 0;

		Connection conex = conexionBD.getConexion();

		if (conex != null) {
			try {
				PreparedStatement q = conex.prepareStatement(GUARDAR);
				q.setString(1, usuario);
				q.setString(2, password);
				rs = q.executeUpdate();
				valid = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return valid;
	}
	
	
	public static ClientBanco buscarUser(String usuario) {
		
		ClientBanco o=new ClientBanco();
		
	Connection conex= conexionBD.getConexion();
		
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(SELECTBYNAME);
				q.setString(1, usuario);
				ResultSet rs=q.executeQuery();
				
				if(rs.next()) {
					o= new ClientBanco();
					o.setId(rs.getInt("id"));
					o.setName(rs.getString("nombre"));
					o.setPassword(rs.getString("password"));
					System.out.println(o);
				 }else {
					 throw new SQLException();
				 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}	
				
		return o;
		
	}
	

}
