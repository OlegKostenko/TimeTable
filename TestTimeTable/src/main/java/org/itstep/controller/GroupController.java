package org.itstep.controller;

import java.util.List;

import org.itstep.model.Group;
import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/group")
public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	@PostMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	ResponseEntity<Group> save(@RequestBody Group group) {
		if(groupService.save(group) != null) {
			return new ResponseEntity<Group>(group, HttpStatus.OK);
		}
		return new ResponseEntity<Group>(HttpStatus.METHOD_NOT_ALLOWED);
	
	}
	
	@PutMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
	ResponseEntity<Group> update(@RequestBody Group group) {
		if(groupService.update(group) != null) {
			return new ResponseEntity<Group>(HttpStatus.OK);
		}
		return new ResponseEntity<Group>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping( path = "/get-one", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
	ResponseEntity<Lesson> getOne(@RequestBody String name) {
		Group group = groupService.get(name);
		if( group != null) {
			return new ResponseEntity(group, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping (consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	ResponseEntity<Group> delete(@RequestBody Group group) {
		groupService.delete(group);
		return new ResponseEntity<Group>(HttpStatus.OK);
	}
	
	@GetMapping( path = "/get-by-course", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
	ResponseEntity<List<Group>> findAllByCourse(@RequestBody String course)
	{
		List<Group> groups = groupService.findAllByCourse(course);
		if(groups != null) {
			return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
		}
			return new ResponseEntity<List<Group>>(HttpStatus.BAD_REQUEST);
	}
	
}
