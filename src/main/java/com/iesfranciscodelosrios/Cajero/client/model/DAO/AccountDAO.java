package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.utils.conexionBD;

public class AccountDAO extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String GUARDAR = "INSERT INTO account (balance, id_client) VALUES (?,?)";
	private final static String ELIMINAR = "DELETE FROM account WHERE id = ? ";
	private final static String CUENTAS = "SELECT * FROM account WHERE id_client=?";

	public AccountDAO(Long id, float balance, ClientBanco client) {
		super(id, balance, client);

	}

	public AccountDAO() {
		super();

	}

	public boolean guardarCuenta(float balance, int client_id) {
		boolean valid = false;
		int rs = 0;

		Connection conex = conexionBD.getConexion();

		if (conex != null) {
			try {
				PreparedStatement q = conex.prepareStatement(GUARDAR);
				q.setFloat(1, balance);
				q.setInt(2, client_id);
				rs = q.executeUpdate();
				valid = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return valid;
	}

	public boolean eliminarCuenta(int id) {
		boolean valid = false;
		int rs = 0;
		Connection conex = conexionBD.getConexion();

		if (conex != null) {
			try {
				PreparedStatement q = conex.prepareStatement(ELIMINAR);
				q.setInt(1, id);
				rs = q.executeUpdate();
				valid = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return valid;
	}
	
	public static List<Account> getContenido(ClientBanco c) {
		Connection conex= conexionBD.getConexion();
		
		List<Account> cuentas= new ArrayList<Account>();
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(CUENTAS);
				q.setInt(1, c.getId());
				ResultSet rs=q.executeQuery();
				
				while(rs.next()) {
					Account a = new Account();
					a.setId(rs.getLong("id"));
					a.setBalance(rs.getFloat("balance"));
					a.setClient(c);
					cuentas.add(a);
					System.out.println(cuentas);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
					
			return cuentas;
	}

}
