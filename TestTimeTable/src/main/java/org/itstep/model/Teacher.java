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
@Table( name = "TEACHERS")
public class Teacher {
	
	@Id
	@Column(name = "LOGIN")
	@JsonProperty
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "SECONDNAME")
	@JsonProperty
	private String secondName;
	
	@ManyToOne(targetEntity = Subject.class)
	private Subject subject;
}
