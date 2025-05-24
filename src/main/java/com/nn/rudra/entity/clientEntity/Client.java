package com.nn.rudra.entity.clientEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "client_detail")
public class Client {
	
	@Id
	private String client_id;
	
	@Column
	private String client_name;
	
	@Column
	private long phone_number;
	
	@Column
	private String address;

	public Client(String client_id, String client_name, long phone_number, String address) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.phone_number = phone_number;
		this.address = address;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
