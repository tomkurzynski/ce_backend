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

import lombok.Data;

@Entity
@Table(name="timetable_has_performer")
@Data
public class RunningOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime;
	
	@ManyToOne
	@JoinColumn(name = "timetable_id", nullable = false)
	private Timetable timetable;
	
	@ManyToOne
	@JoinColumn(name = "performer_id", nullable = false)
	private Performer performer;
}
