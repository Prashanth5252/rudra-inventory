package com.nn.rudra.entity.dealerEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "dealer_detail")
public class Dealer {

	@Id
	private String dealer_id;
	
	@Column
	private String dealer_name;
	
	@Column
	private long phone_number;
	
	@Column
	private String address;

	public Dealer(String dealer_id, String dealer_name, long phone_number, String address) {
		super();
		this.dealer_id = dealer_id;
		this.dealer_name = dealer_name;
		this.phone_number = phone_number;
		this.address = address;
	}

	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public String getDealer_name() {
		return dealer_name;
	}

	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
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
