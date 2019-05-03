package com.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Tomasz Gomoradzki
 * Client ORM object, mapped with database, used to handle managing data within application
 *
 */

@Entity
@Table(name="hr.CLIENT")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.CLIENT_SEQ")
	@Column(name="CLIENT_ID")
	private int client_id;
	
	@NotNull(message="First Name is required")
	@Size(min=1, message="First Name is required")
	@Column(name="FIRST_NAME")
	private String firstName;
		
	@NotNull(message="Last Name is required")
	@Size(min=1, message="Last Name is required")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="POINTS")
	private Integer points;
	
	@Column(name="LAST_LOGIN_DATE")
	private Date lastLoginDate;
	
	@OneToMany(mappedBy="client", // reference to Client field in Purchase Order class
				cascade= {CascadeType.ALL,	 
							//CascadeType.PERSIST, // Cascade save operations
							//CascadeType.REMOVE, // Removes all related entities association with this setting when the owning entity is deleted.
							//CascadeType.MERGE,
							//CascadeType.DETACH,
							//CascadeType.REFRESH,
							},orphanRemoval = true)//@JoinColumn( name="CLIENT_ID")
	private List<PurchaseOrder> purchaseOrders;

	public Client() {}
	
	// Bi-directional relationship method
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		if(purchaseOrders == null) {
			purchaseOrders = new ArrayList<>();
		}
		
		purchaseOrders.add(purchaseOrder);
		purchaseOrder.setClient(this);
	}
	
	// Bi-directional relationship method
	public void removePurchaseOrder(PurchaseOrder purchaseOrder) {
		if(purchaseOrders == null) {
			return;
		}
		
		purchaseOrders.remove(purchaseOrder);
		purchaseOrder.setClient(this);
	}
	
	@Override
	public String toString() {
		return "Client [Client_id=" + client_id + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", points=" + points + ", lastLoginDate=" + lastLoginDate + "]";
	}
	
	public List<PurchaseOrder> getPurchaseOrders(){
		return purchaseOrders;
	}
	
	public void setPOrsers(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int cl_id) {
		client_id = cl_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPoints() {
		if(points == null) {
			return 0;
		}else{
			return points;			
		}
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


}
