package com.createvent.createvent.entity;

import java.util.List;

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

import lombok.Data;

@Entity
@Table(name="timetable")
@Data
public class Timetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "room_stage_id", nullable = false)
	private StageRoom stageRoom;
	
	@OneToMany(mappedBy = "timetable", orphanRemoval = true, cascade = CascadeType.PERSIST)
	List<RunningOrder> runningOrder;
	
}
