package com.createvent.createvent.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

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
	
	@OneToMany(mappedBy = "festival", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Food> foods;
	
	@OneToMany(mappedBy = "festival", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<News> news;
	
	@OneToMany(mappedBy = "festival", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Performer> performers;
	
	@OneToMany(mappedBy = "festival", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<StageRoom> stageRoom;
	
	@Column(name = "event_name")
	private String name;
	
	@Column(name = "event_desc")
	private String eventDesc;
	
	@Column(name = "date_from")
	
	private Date dateFrom;
	
	@Column(name = "date_to")
	private Date dateTo;
	
	@Lob
	@Column(name = "logo_url")
	private byte[] logoUrl;
	
	@Column(name = "facebook")
	private String facebook;
	
	@Column(name = "twitter")
	private String twitter;

	@Column(name = "location")
	private String location;

}
