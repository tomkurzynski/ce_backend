package com.createvent.createvent.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="event")
@Getter
@Setter
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = false)
	private Users user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private Set<Food> foods;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private Set<News> news;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private Set<Performer> performers;
	
	@Column(name = "event_name")
	private String name;
	
	@Column(name = "event_desc")
	private String eventDesc;
	
	@Column(name = "date_from")
	private Date dateFrom;
	
	@Column(name = "date_to")
	private Date dateTo;
	
	@Column(name = "logo_url")
	private String logoUrl;
	
	@Column(name = "facebook")
	private String facebook;
	
	@Column(name = "twitter")
	private String twitter;

	@Column(name = "location")
	private String location;
}
