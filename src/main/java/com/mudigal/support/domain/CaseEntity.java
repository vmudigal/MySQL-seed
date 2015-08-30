package com.mudigal.support.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "CASES")
public class CaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8586146401282980590L;
	
	@Id
	@Column(name = "CASE_ID")
	@GeneratedValue
	private Integer caseId;
	
	@Column(name = "GAME_ID")
	private Integer gameId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "LOCALE")
	private String locale;
	
	@OneToMany(cascade = CascadeType.ALL)
    @Cascade(value = {org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    @Column (name = "COMMENTS_ID")
    private Collection<CaseCommentsEntity> comments;
	
	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Collection<CaseCommentsEntity> getComments() {
		return comments;
	}

	public void setComments(Collection<CaseCommentsEntity> comments) {
		this.comments = comments;
	}
}
