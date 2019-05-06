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
 * Product is in one-to-many relation with PurchaseOrder
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
	private PurchaseOrder purchaseOrder;
		
	@Column(name="NAME")
	private String name;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DATE_ADDED")
	private Date dateAdded;
	

	public Product() {}
		
	public Product(String name, Date dateAdded) {
		this.dateAdded = dateAdded;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [order_id=" + product_id + ", Name=" + name
				+ ", Product Status=" + status + ", Date Added=" + dateAdded + "]";
	}

	
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public int getPurchaseOrderID() {
		return purchaseOrder.getOrder_id();
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	

}
