package com.createvent.createvent.entity;

import java.util.List;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="performer")
@Getter
@Setter
public class Performer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="web_url")
	private String webUrl;
	
	@Column(name="youtube")
	private String youtube;
	
	@Column(name="facebook")
	private String facebook;
	
	@Column(name="twitter")
	private String twitter;
	
	@Column(name="spotify")
	private String spotify;
	
	@Lob
	@Column(name="photo")
	private byte[] photo;
	
	@ManyToOne
	@JoinColumn(name = "event_id", nullable = false)
	private Festival festival;
	
	@OneToMany(mappedBy = "performer")
	List<RunningOrder> runningOrder;

}
