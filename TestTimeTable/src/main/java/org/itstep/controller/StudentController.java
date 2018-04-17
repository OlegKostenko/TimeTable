//package org.itstep.controller;
//
//import org.itstep.model.Student;
//import org.itstep.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping(path = "/student")
//public class StudentController {
//
//	@Autowired
//	StudentService studentService;
//	
//	@PostMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}  )
//	ResponseEntity<Student> save(@RequestBody Student student) {
//		if(studentService.save(student) != null) {
//			return new ResponseEntity<Student>(student, HttpStatus.OK);
//		}
//		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
//	}
//	
//	@PutMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
//	ResponseEntity<Student> update(@RequestBody Student student) {
//		if(studentService.update(student) != null) {
//			return new ResponseEntity<Student>(HttpStatus.OK);
//		}
//		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
//	}
//	
//	@GetMapping( path = "/get-one", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
//	ResponseEntity<Student> getOne(@RequestBody String login) {
//		Student student = studentService.get(login);
//		if( student != null) {
//			return new ResponseEntity<Student>(student, HttpStatus.OK);
//		}
//		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
//	}
//}
