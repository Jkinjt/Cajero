package com.iesfranciscodelosrios.Cajero.client.model.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iesfranciscodelosrios.Cajero.client.model.Operator;
import com.iesfranciscodelosrios.Cajero.utils.conexionBD;

public class OperatorDAO extends Operator {

	private final static String SELECTBYNAME = "SELECT * FROM operario WHERE nombre=?";
		
		
		
		public OperatorDAO(){
			
		}
		
		public OperatorDAO(String usuario,String password){
			super(usuario,password);
		}
		
		
public static Operator buscarUser(String usuario) {
			
			Operator o=new Operator();
			
		Connection conex= conexionBD.getConexion();
			
			
			if(conex!=null) {
				try {
					PreparedStatement q=conex.prepareStatement(SELECTBYNAME);
					q.setString(1, usuario);
					ResultSet rs=q.executeQuery();
					
					if(rs.next()) {
						o= new Operator();
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
