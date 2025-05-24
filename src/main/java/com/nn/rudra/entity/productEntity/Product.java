package com.nn.rudra.entity.productEntity;

import org.postgresql.util.PGmoney;

import jakarta.persistence.*;

@Entity
@Table(name = "product_details")
public class Product {

	@Id
	private String product_id;
	
	@Column
	private String product_name;
	
	@Column
	private double product_sgst;
	
	@Column
	private double product_cgst;

	@Column
	private double profit;
	
	@Column
	private double discount;
	
	@Column
	private Integer stocks_count;
	
	@Column
	private PGmoney cost_per_unit;

	public Product(String product_id, String product_name, double product_sgst, double product_cgst, double profit,
			double discount, Integer stocks_count, PGmoney cost_per_unit) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_sgst = product_sgst;
		this.product_cgst = product_cgst;
		this.profit = profit;
		this.discount = discount;
		this.stocks_count = stocks_count;
		this.cost_per_unit = cost_per_unit;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_sgst() {
		return product_sgst;
	}

	public void setProduct_sgst(double product_sgst) {
		this.product_sgst = product_sgst;
	}

	public double getProduct_cgst() {
		return product_cgst;
	}

	public void setProduct_cgst(double product_cgst) {
		this.product_cgst = product_cgst;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Integer getStocks_count() {
		return stocks_count;
	}

	public void setStocks_count(Integer stocks_count) {
		this.stocks_count = stocks_count;
	}

	public PGmoney getCost_per_unit() {
		return cost_per_unit;
	}

	public void setCost_per_unit(PGmoney cost_per_unit) {
		this.cost_per_unit = cost_per_unit;
	}
	
}
