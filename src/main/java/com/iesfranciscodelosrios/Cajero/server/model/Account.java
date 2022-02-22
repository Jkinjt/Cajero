package com.iesfranciscodelosrios.Cajero.server.model;

import java.util.Objects;

public class Account {
	private int id;
	private float balance;
	private ClientBanco client;
	/**
	 * @param id
	 * @param balance
	 * @param client
	 */
	public Account(int id, float balance, ClientBanco client) {
		super();
		this.id = id;
		this.balance = balance;
		this.client = client;
	}
	/**
	 * @param balance
	 * @param client
	 */
	public Account(float balance, ClientBanco client) {
		super();
		this.balance = balance;
		this.client = client;
	}
	/**
	 * 
	 */
	public Account() {
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
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}
	/**
	 * @return the client
	 */
	public ClientBanco getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(ClientBanco client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", client=" + client + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(balance, client, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Float.floatToIntBits(balance) == Float.floatToIntBits(other.balance)
				&& Objects.equals(client, other.client) && id == other.id;
	}
	
	

}
