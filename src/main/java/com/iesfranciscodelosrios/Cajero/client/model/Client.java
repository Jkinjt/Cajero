package com.iesfranciscodelosrios.Cajero.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Client implements Serializable {
	private final static long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="id")
	private String name;
	@Column(name="id")
	private String password;
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Account> acounts;
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public Client(int id, String name, String password, List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.acounts=accounts;
	}
	/**
	 * 
	 */
	public Client() {
		super();
	}
	/**
	 * @param name
	 * @param password
	 */
	public Client(String name, String password) {
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
	public Client(String name, String password, List<Account> acounts) {
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
		Client other = (Client) obj;
		return id == other.id;
	}
	
	

}
