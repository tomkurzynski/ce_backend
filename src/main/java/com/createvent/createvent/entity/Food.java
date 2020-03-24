package com.createvent.createvent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="food")
@Getter
@Setter
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
	@Column(name="food_logo_url", length = 1000)
	private byte[] logoUrl;
	
	@Column(name="food_facebook")
	private String facebook;
	
	
	@ManyToOne()
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
}
