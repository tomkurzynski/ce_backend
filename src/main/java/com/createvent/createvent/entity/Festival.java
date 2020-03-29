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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="event")
@Getter
@Setter
public class Festival {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = false)
	private Users user;
	
	@OneToMany(mappedBy = "festival")
	private Set<Food> foods;
	
	@OneToMany(mappedBy = "festival")
	private Set<News> news;
	
	@OneToMany(mappedBy = "festival")
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
	
	
	
	public Festival(String name2, String eventDesc2, Date dateFrom2, Date dateTo2, String facebook2, String twitter2,
			String twitter3, String location2, Long long1) {
		
	}



	public Festival() {
	}

}
