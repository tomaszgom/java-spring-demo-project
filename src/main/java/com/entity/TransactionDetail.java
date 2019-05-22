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
public class TransactionDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.TRANSACTION_SEQ")
	@Column(name="TRANSACTION_ID")
	private int transaction_id;
	
	@ManyToOne (fetch = FetchType.LAZY, cascade= {CascadeType.ALL})
	@JoinColumn(name="TRANSACTION_ID", nullable=false)
	private PurchaseOrder purchaseOrder;
	
	@Column(name="NET")
	private double net;
	
	@Column(name="VAT")
	private double vat;
	
	@Column(name="GROSS")
	private double gross;
	
	@Column(name="DESC")
	private String desc;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="DATE_CREATED")
	private Date dateCreated;

	public TransactionDetail() {}
		
		
	public TransactionDetail(int transaction_id, PurchaseOrder purchaseOrder, String type, Date dateCreated) {
		this.transaction_id = transaction_id;
		this.purchaseOrder = purchaseOrder;
		this.type = type;
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", desc=" + desc + ", status=" + status + ", type="
				+ type + "]";
	}


	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}


	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}


	public double getNet() {
		return net;
	}


	public void setNet(double net) {
		this.net = net;
	}


	public double getVat() {
		return vat;
	}


	public void setVat(double vat) {
		this.vat = vat;
	}


	public double getGross() {
		return gross;
	}


	public void setGross(double gross) {
		this.gross = gross;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

}
