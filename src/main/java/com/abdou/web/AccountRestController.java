package com.abdou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdou.entities.AppUser;
import com.abdou.service.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
public AppUser Register(@RequestBody RegisterForm registerform){
		if(!registerform.getRepass().equals(registerform.getPassword()))
			throw new RuntimeException("you must confirm your password");
		AppUser user = accountService.findUserByUsername(registerform.getUsername());
		if(user!=null)	throw new RuntimeException("this "+"" + registerform.getUsername() +" "+"already exist" );

		
		AppUser appuser = new AppUser();
		appuser.setUsername(registerform.getUsername());
		appuser.setPassword(registerform.getPassword());
		
		
		//AppUser user = new AppUser(registerform.getUsername(), registerform.getPassword(), roles);
		
		return accountService.saveUser(appuser);
	}
	
}
 