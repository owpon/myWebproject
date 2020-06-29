package com.ziv.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "context")
@EntityListeners(AuditingEntityListener.class)
public class ContextEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "auther")
	private String auther;
	@Column(name = "title")
	private String title;
	@Column(name = "context")
	private String context;
	@Column(name = "create_time", updatable = false)
	@CreatedDate
	private Date createTime;
	@Column(name = "update_time")
	@LastModifiedDate
	private Date updateTime;
}
