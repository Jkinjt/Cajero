package com.iesfranciscodelosrios.Cajero.server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientBanco {
	private int id;
	private String name;
	private String password;
	private List<Account> acounts;
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public ClientBanco(int id, String name, String password, List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.acounts=accounts;
	}
	/**
	 * 
	 */
	public ClientBanco() {
		super();
	}
	/**
	 * @param name
	 * @param password
	 */
	public ClientBanco(String name, String password) {
		super();
		this.id=-1;
		this.name = name;
		this.password = password;
		this.acounts=new ArrayList<>();
	}
	
	
	/**
	 * @param name
	 * @param password
	 * @param acounts
	 */
	public ClientBanco(String name, String password, List<Account> acounts) {
		super();
		this.name = name;
		this.password = password;
		this.acounts = acounts;
	}
	
	
	/**
	 * @return the acounts
	 */
	public List<Account> getAcounts() {
		return acounts;
	}
	/**
	 * @param acounts the acounts to set
	 */
	public void setAcounts(List<Account> acounts) {
		this.acounts = acounts;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientBanco other = (ClientBanco) obj;
		return id == other.id;
	}
	
	

}
