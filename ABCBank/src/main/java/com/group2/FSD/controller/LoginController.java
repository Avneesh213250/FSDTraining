package com.group2.FSD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group2.FSD.Service.LoginService;
import com.group2.FSD.domain.Officer;
import com.group2.FSD.domain.User;

@RestController
@CrossOrigin
public class LoginController {
	 
		@Autowired
		LoginService loginService;
		
		@GetMapping("getUserByIdCheck/{userid}/{password}")
		public ResponseEntity<User> getUserByIdCheck(@PathVariable Integer userid, @PathVariable String password) {
			System.out.println(userid+"  ======== "+password);
			return ResponseEntity.ok(loginService.findByUseridAndPassword(userid, password));
		}
		@PutMapping("updateUser/{userid}")
		public ResponseEntity<User> updateById(@RequestBody User user ,@PathVariable Integer userid){
			return ResponseEntity.ok(loginService.updateById(userid, user));
		}
		@GetMapping("getUserById/{userid}")
		public ResponseEntity<Officer> getUserById(@PathVariable Integer userid) {
			return ResponseEntity.ok(loginService.findById(userid));
		}
		@GetMapping("getAllUserById/")
		public List<User> getAllUser() {
			return loginService.findAll();
		}
}
