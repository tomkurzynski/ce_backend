package com.createvent.createvent.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "news")
@Data
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "date_created")
	@CreationTimestamp
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date dateCreated;
	
	@Column(name = "last_updated")
	@UpdateTimestamp
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date lastUpdated;
	
	@Column(name = "news_body")
	private String newsBody;
	
	@ManyToOne
	@JoinColumn(name = "event_id", referencedColumnName="id", nullable = false)
	private Festival festival;
}
