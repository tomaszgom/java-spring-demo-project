package com.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="hr.P_ORDER")
public class POrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.P_ORDER_SEQ")
	@Column(name="ORDER_ID")
	private int order_id;
	
	@ManyToOne (cascade= {CascadeType.PERSIST, // No cascade DELETE
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH,
			})
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	
	//@Column(name="CLIENT_ID")
	//private int client_id;
	
	@Column(name="ORDER_VALUE")
	private double orderValue;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="ORDER_DATE")
	private Date porderDate;

	public POrder() {}
		
	public POrder(double orderValue, String productName) {
		this.orderValue = orderValue;
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "POrder [order_id=" + order_id + ", orderValue=" + orderValue
				+ ", productName=" + productName + ", orderDate=" + porderDate + "]";
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

	public Date getPorderDate() {
		return porderDate;
	}

	public void setPorderDate(Date orderDate) {
		this.porderDate = orderDate;
	}


}
