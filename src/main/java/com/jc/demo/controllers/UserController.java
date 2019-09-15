package com.jc.demo.controllers;



import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc.demo.ui.UserRest;
import com.jc.demo.ui.userRequestModel;

@RestController
@RequestMapping("users")
public class UserController {
	@GetMapping()
	public String getUsers(@RequestParam(value="page",required=false) String page,@RequestParam(value="limit",required=false) String limit) {
		return  "get users is called with page ="+page+" and limit ="+limit;
	}
	
	@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest userRest=new UserRest();
		userRest.setFirstName("j");
		userRest.setLastName("c");
		userRest.setEmail("jc@test.com");
		return new ResponseEntity<>(userRest,HttpStatus.BAD_REQUEST);
	}
	

	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody userRequestModel userDetails) {
		UserRest userRest=new UserRest();
		userRest.setFirstName(userDetails.getFirstName());
		userRest.setLastName(userDetails.getLastName());
		userRest.setEmail(userDetails.getEmail());
		return new ResponseEntity<>(userRest,HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user is called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user is called";
	}
}
