package org.common.login.module.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Role {
	
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
	@Column(name = "ROLE_ID", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@Embedded
	private BaseEntity baseEntity;
	
	@OneToMany(mappedBy="roleId")
	private List<Login> listOfUsers = new ArrayList<Login>();
	
	@OneToMany(mappedBy="roleId")
	private List<Group> listOfGroup = new ArrayList<Group>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}

	public List<Login> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<Login> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public List<Group> getListOfGroup() {
		return listOfGroup;
	}

	public void setListOfGroup(List<Group> listOfGroup) {
		this.listOfGroup = listOfGroup;
	}
	
	
	
}
