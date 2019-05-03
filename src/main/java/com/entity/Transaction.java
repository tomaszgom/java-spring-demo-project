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
 * Transaction ORM object, used to handle managing transactional, payment data
 *
 */


//@Entity
//@Table(name="hr.TRANSACTION")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.TRANSACTION_SEQ")
	@Column(name="TRANSACTION_ID")
	private int transaction_id;
	
	@ManyToOne (fetch = FetchType.LAZY, cascade= {CascadeType.ALL})
	@JoinColumn(name="CLIENT_ID", nullable=false)
	private Client client;
	
	// @Column(name="CLIENT_ID")
	// private int client_id;
	
	@Column(name="ORDER_VALUE")
	private double orderValue;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;

	public Transaction() {}
		
	public Transaction(double orderValue, String productName) {
		this.orderValue = orderValue;
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [transaction_id=" + transaction_id + ", orderValue=" + orderValue
				+ ", productName=" + productName + ", orderDate=" + orderDate + "]";
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int order_id) {
		this.transaction_id = order_id;
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
