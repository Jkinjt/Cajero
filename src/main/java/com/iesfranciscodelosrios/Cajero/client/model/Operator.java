package com.iesfranciscodelosrios.Cajero.client.model;

import java.io.Serializable;
import java.util.Objects;
public class Operator implements Serializable {
	
	
	private final static long serialVersionUID=1L;

	protected long id_operator;

	private String name;

	private String password;
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public Operator(int id, String name, String password) {
		super();
		this.id_operator = id;
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
	public long getId() {
		return id_operator;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id_operator = id;
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
		return "Operator [id=" + id_operator + ", name=" + name + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_operator);
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
		return id_operator == other.id_operator;
	}
	
	

}
