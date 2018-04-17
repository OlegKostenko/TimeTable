//package org.itstep.controller;
//
//import org.itstep.model.Group;
//import org.itstep.model.Lesson;
//import org.itstep.service.GroupService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping(path = "group")
//public class GroupController {
//	
//	@Autowired
//	GroupService groupService;
//	
//	@PostMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//	ResponseEntity<Group> save(@RequestParam Group group) {
//		if(groupService.save(group) != null) {
//			return new ResponseEntity<Group>(group, HttpStatus.OK);
//		}
//		return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
//	
//	}
//	
//	@PutMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
//	ResponseEntity update(@RequestParam Group group) {
//		if(groupService.update(group) != null) {
//			return new ResponseEntity(HttpStatus.OK);
//		}
//		return new ResponseEntity(HttpStatus.BAD_REQUEST);
//	}
//	
//	@GetMapping( path = "/get-one", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
//	ResponseEntity<Lesson> getOne(@RequestParam String name) {
//		Group group = groupService.get(name);
//		if( group != null) {
//			return new ResponseEntity(group, HttpStatus.OK);
//		}
//		return new ResponseEntity(HttpStatus.BAD_REQUEST);
//	}
//	
//}
