package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "STUDENTS")
public class Student {

	@Id
	@Column(name = "LOGIN")
	@JsonProperty
	private String login;
	
	@Column(name = "PASSWORD")
	@JsonProperty
	private String password;
	
	@Column(name = "FIRS_TNAME")
	@JsonProperty
	private String firstName;
	
	@Column(name = "SECOND_NAME")
	@JsonProperty
	private String secondName;
	
	@ManyToOne(targetEntity = Group.class)
	private Group group;
}
