package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
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
	private final static String ALLOPERARIOS = "SELECT * FROM clientbanco";
	private final static String SELECTBYNAME="SELECT * FROM clientbanco WHERE nombre=?";
	private final static String SELECTBYID="SELECT * FROM clientbanco WHERE id=?";
	private static final String INSERT="INSERT INTO clientbanco (nombre,password) VALUES (?,?)";
	

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
	
	public static List<ClientBanco> todosClientes() {
		
		List<ClientBanco> o=new ArrayList<ClientBanco>();
		
		
	    Connection conex= conexionBD.getConexion();
		
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(ALLOPERARIOS);
				ResultSet rs=q.executeQuery();
				
				while(rs.next()) {
					ClientBanco operador= new ClientBanco();
					operador.setId(rs.getInt("id"));
					operador.setName(rs.getString("nombre"));
					operador.setPassword(rs.getString("password"));
					o.add(operador);
				}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}	
				System.out.println(o);
		return o;
		
	}
	
	
public static ClientBanco buscarUserxID(int id) {
		
		ClientBanco o=new ClientBanco();
		
	Connection conex= conexionBD.getConexion();
		
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(SELECTBYID);
				q.setInt(1, id);
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

public static ClientBanco add(ClientBanco a) {
	Connection conex= conexionBD.getConexion();
	PreparedStatement ps=null;
	ResultSet rs=null;
	if(conex!=null) {
		try {
			ps=conex.prepareStatement(INSERT,ps.RETURN_GENERATED_KEYS);
			ps.setString(1,a.getName());
			ps.setString(2,a.getPassword());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if(rs.next()) {
				a.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	return a;
}

}
