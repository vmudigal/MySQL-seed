package com.mudigal.support.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CASE_COMMENTS")
public class CaseCommentsEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -435326767151618351L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer Id;
	
	@Column(name = "BODY")
	private String body;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
