package com.ziv.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "context")
public class ContextEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "auther")
	private String auther;
	@Column(name = "context")
	private String context;
	@Column(name = "create_time")
	private Date create_time;
	@Column(name = "update_time")
	private Date update_time;
}
