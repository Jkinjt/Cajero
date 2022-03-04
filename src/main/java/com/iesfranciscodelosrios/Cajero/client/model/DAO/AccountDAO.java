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
	private static final String INSERT="INSERT INTO account (balance,id_client) VALUES (?,?)";
	private final static String EDITAR="UPDATE account SET balance=balance+? WHERE id=?";
	private final static String RETIRAR="UPDATE account SET balance=balance-? WHERE id=?";
	private static final String DELETE="DELETE FROM account WHERE id=?";
	private final static String ELIMINAR = "DELETE FROM account WHERE id = ? ";
	private final static String CUENTASxCLIENTE = "SELECT * FROM account WHERE id_client=?";
	private final static String TODAS = "SELECT * FROM account";

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
	
	
	public static boolean eliminar (Long id) {
		boolean valid=false;
		int rs=0;
		Connection conex= conexionBD.getConexion();

		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(DELETE);
				q.setLong(1, id);
				rs=q.executeUpdate();
				valid=true;
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
				PreparedStatement q=conex.prepareStatement(CUENTASxCLIENTE);
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
	
	public static List<Account> todas() {
		Connection conex= conexionBD.getConexion();
		
		List<Account> cuentas= new ArrayList<Account>();
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(TODAS);
				ResultSet rs=q.executeQuery();
				
				while(rs.next()) {
					Account a = new Account();
					a.setId(rs.getLong("id"));
					a.setBalance(rs.getFloat("balance"));
					a.setClient(ClientDAO.buscarUserxID(rs.getInt("id")));
					cuentas.add(a);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(cuentas);
			return cuentas;
	}
	
	public static Account add(Account a) {
		Connection conex= conexionBD.getConexion();
		PreparedStatement ps=null;
		ResultSet rs=null;
		if(conex!=null) {
			try {
				ps=conex.prepareStatement(INSERT,ps.RETURN_GENERATED_KEYS);
				ps.setFloat(1,a.getBalance());
				ps.setInt(2,a.getClient().getId());
				ps.executeUpdate();
				rs=ps.getGeneratedKeys();
				if(rs.next()) {
					a.setId(rs.getLong(1));
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
	
	
	public static boolean INGRESAR(Account id) {
		boolean valid=false;
		int rs=0;
		
	Connection conex= conexionBD.getConexion();
		
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(EDITAR);
				q.setFloat(1, id.getBalance());
				q.setFloat(2, id.getId());
				rs=q.executeUpdate();
				valid=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return valid;
	}
	
	public static boolean retirar(Float cantidad,Account a) {
		boolean valid=false;
		int rs=0;
		
	Connection conex= conexionBD.getConexion();
		
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(RETIRAR);
				q.setFloat(1, cantidad);
				q.setLong(2, a.getId());
				rs=q.executeUpdate();
				valid=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return valid;
	}

}
