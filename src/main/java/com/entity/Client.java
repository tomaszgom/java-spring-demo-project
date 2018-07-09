package com.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="hr.CLIENT")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.CLIENT_SEQ")
	@Column(name="CLIENT_ID")
	private int client_id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="POINTS")
	private Integer points;
	
	@Column(name="LAST_LOGIN_DATE")
	private Date lastLoginDate;

	
	@Override
	public String toString() {
		return "Client [Client_id=" + client_id + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", points=" + points + ", lastLoginDate=" + lastLoginDate + "]";
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
		return points;
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


	public Client() {}

}
