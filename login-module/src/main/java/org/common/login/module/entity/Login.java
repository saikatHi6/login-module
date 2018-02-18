package org.common.login.module.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator",
		parameters = {
			@Parameter(
				name = "uuid_gen_strategy_class",
				value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
			)
		}
	)
	@Column(name = "ID", updatable = false, nullable = false,columnDefinition = "BINARY(16)")
	private UUID id;
	
	@Column(name="LOGIN_NAME",unique=true)
	private String loginName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Embedded
	private BaseEntity baseEntity;
	
	@OneToOne(fetch=FetchType.LAZY)
	//@MapsId
	@JoinColumn(name="LOGIN_ID")
	private User userId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROLE_ID")
	private Role roleId;
	
	@ManyToMany
	@JoinTable(name="LOGIN_GROUP",joinColumns={@JoinColumn(name="LOGIN_ID")},inverseJoinColumns={@JoinColumn(name="GROUP_ID")})
	private List<Group> listOfGroup = new ArrayList<>();
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CREATED_BY")
	private Login createdBy;
	
	@OneToMany(mappedBy="createdBy")
	private Set<Login> users = new HashSet<Login>();*/
	
	public BaseEntity getBaseEntity() {
		return baseEntity;
	}
	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}
	public String getUserName() {
		return loginName;
	}
	public void setUserName(String userName) {
		this.loginName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Role getRoleId() {
		return roleId;
	}
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	public List<Group> getListOfGroup() {
		return listOfGroup;
	}
	public void setListOfGroup(List<Group> listOfGroup) {
		this.listOfGroup = listOfGroup;
	}
	
	
	
	
}
