package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "GROUPS" )
public class Group {

	@Id
	@Column( name = "GROUP_NAME")
	@JsonProperty
	private String name;
	
	@Column( name = "COURSE")
	@JsonProperty
	private String course;
	
	@Column( name = "SPECIALIZATION")
	@JsonProperty
	private String specialization;
	
}
