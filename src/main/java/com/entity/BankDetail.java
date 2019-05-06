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
 * BankDetails ORM object, mapped with database, used to handle managing data within application
 *
 */

@Entity
@Table(name="hr.BANKDETAIL")
public class BankDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.BANKDETAIL_SEQ")
	@Column(name="BANKDETAIL_ID")
	private int order_id;
	
	@ManyToOne (fetch = FetchType.LAZY,
				cascade= {CascadeType.ALL})
	@JoinColumn(name="CLIENT_ID", nullable=false)
	private Client client;
	

	
	
	
	@Column(name="ORDER_VALUE")
	private double orderValue;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;

	public BankDetail() {}
		
	public BankDetail(double orderValue, String productName) {
		this.orderValue = orderValue;
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [order_id=" + order_id + ", orderValue=" + orderValue
				+ ", productName=" + productName + ", orderDate=" + orderDate + "]";
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
