package com.iesfranciscodelosrios.Cajero.client.model;

import java.util.Objects;

public class Operator {

	private int id;
	private String name;
	private String password;
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public Operator(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	/**
	 * @param name
	 * @param password
	 */
	public Operator(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	/**
	 * 
	 */
	public Operator() {
		super();
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
		return "Operator [id=" + id + ", name=" + name + ", password=" + password + "]";
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
		Operator other = (Operator) obj;
		return id == other.id;
	}
	
	

}
