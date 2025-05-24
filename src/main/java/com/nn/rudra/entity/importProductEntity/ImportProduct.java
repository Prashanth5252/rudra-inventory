package com.nn.rudra.entity.importProductEntity;


import java.sql.Date;

import org.postgresql.util.PGmoney;

import jakarta.persistence.*;

@Entity
@Table(name = "import_product_detail")
public class ImportProduct {

	@Id
	private String 	import_id;
	
	@Column(nullable = false)
	private String product_id;
	
	@Column(nullable = false)
	private String dealer_id;
	
	@Column
	private Date import_date;
	
	@Column
	private Integer quantity;
	
	@Column
	private PGmoney cost_per_unit;

	public ImportProduct(String import_id, String product_id, String dealer_id, Date import_date, Integer quantity,
			PGmoney cost_per_unit) {
		super();
		this.import_id = import_id;
		this.product_id = product_id;
		this.dealer_id = dealer_id;
		this.import_date = import_date;
		this.quantity = quantity;
		this.cost_per_unit = cost_per_unit;
	}

	public String getImport_id() {
		return import_id;
	}

	public void setImport_id(String import_id) {
		this.import_id = import_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public Date getImport_date() {
		return import_date;
	}

	public void setImport_date(Date import_date) {
		this.import_date = import_date;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public PGmoney getCost_per_unit() {
		return cost_per_unit;
	}

	public void setCost_per_unit(PGmoney cost_per_unit) {
		this.cost_per_unit = cost_per_unit;
	}
	
	
	
}
