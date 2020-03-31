package com.createvent.createvent.entity;

import java.util.Date;
import java.util.List;
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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="event")
@Data
public class Festival {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = false)
	private Users user;
	
	@OneToMany(mappedBy = "festival")
	private List<Food> foods;
	
	@OneToMany(mappedBy = "festival")
	private List<News> news;
	
	@OneToMany(mappedBy = "festival")
	private List<Performer> performers;
	
	@OneToMany(mappedBy = "festival")
	private List<StageRoom> stageRoom;
	
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
