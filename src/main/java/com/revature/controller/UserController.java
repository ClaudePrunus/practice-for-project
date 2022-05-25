package com.revature.controller;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ClientMessage;
import com.revature.model.User;
import com.revature.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	
	@Autowired
	private UserService userv;
	
	@ApiOperation(value="Find user by id number", notes="Provide an id to look u a specific user from the API", response = User.class)
	@GetMapping(path = "/user")
	public @ResponseBody User getById(@RequestParam(value="id", name="id") int id) {
		System.out.println("TEST: " + userv.findUsernameById(id));
		return userv.findUsernameById(id);
	}
	
	@GetMapping("/users")
	@ApiOperation("create new user entity")
	public @ResponseBody ClientMessage createAccount(@RequestBody User user) {
		return userv.createAccount(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}

	@PostMapping("/user")
	@ApiOperation("update new user entity")
	public @ResponseBody ClientMessage editUser(@RequestBody User user) {
		return userv.editUser(user) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}

	@DeleteMapping("/user")
	@ApiOperation("delete user entity")
	public @ResponseBody ClientMessage deleteUser(@RequestBody User user) {
		return userv.deleteUser(user) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}

}
