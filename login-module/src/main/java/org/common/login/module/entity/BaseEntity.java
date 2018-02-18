package org.common.login.module.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class BaseEntity {
	
	
	
	
	@Column(name="CREATE_DATE")
	private Instant createDate;
	
	@Column(name="UPDATE_DATE")
	private Instant updateDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CREATED_BY",foreignKey=@ForeignKey(name="CREATED_BY_USER_NAME"),referencedColumnName="LOGIN_NAME")
	private Login createdBy;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UPDATED_BY",foreignKey=@ForeignKey(name="UPDATED_BY_USER_NAME"),referencedColumnName="LOGIN_NAME")
	private Login updatedBy;
	
	
	@Transient
	private LocalDateTime testLocaleDate;
	
	@Transient
	private OffsetDateTime testOffsetDate;
	
	
	
	public Instant getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}
	public Instant getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}
	public LocalDateTime getTestLocaleDate() {
		return testLocaleDate;
	}
	public void setTestLocaleDate(LocalDateTime testLocaleDate) {
		this.testLocaleDate = testLocaleDate;
	}
	public OffsetDateTime getTestOffsetDate() {
		return testOffsetDate;
	}
	public void setTestOffsetDate(OffsetDateTime testOffsetDate) {
		this.testOffsetDate = testOffsetDate;
	}
	public Login getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Login createdBy) {
		this.createdBy = createdBy;
	}
	
	public Login getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Login updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	

}
