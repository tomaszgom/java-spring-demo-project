package com.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Tomasz Gomoradzki
 * Product ORM object, mapped with database, used to handle managing data within application
 * Product is in one to many relation with PurchaseOrder
 *
 */

@Entity
@Table(name="hr.PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.PRODUCT_SEQ")
	@Column(name="PRODUCT_ID")
	private int product_id;
	
	@ManyToOne (fetch = FetchType.LAZY, cascade= {CascadeType.ALL})
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Client client;
	
	// @Column(name="CLIENT_ID")
	// private int client_id;
	
	@Column(name="ORDER_VALUE")
	private double orderValue;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;

	public Product() {}
		
	public Product(double orderValue, String productName) {
		this.orderValue = orderValue;
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [order_id=" + product_id + ", orderValue=" + orderValue
				+ ", productName=" + productName + ", orderDate=" + orderDate + "]";
	}

	public int getOrder_id() {
		return product_id;
	}

	public void setOrder_id(int order_id) {
		this.product_id = order_id;
	}

	public Client getClient() {
		return client;
	}
	public int getClientID() {
		return client.getClient_id();
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


}
