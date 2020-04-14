package com.createvent.createvent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="food")
@Data
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="food_name")
	private String foodName;
	
	@Column(name="food_type")
	private String foodType;
	
	@Lob
	@Column(name="food_logo_url")
	private byte[] logoUrl;
	
	@Column(name="food_facebook")
	private String facebook;
	
	
	@ManyToOne()
	@JoinColumn(name = "event_id", nullable = false)
	private Festival festival;
}
