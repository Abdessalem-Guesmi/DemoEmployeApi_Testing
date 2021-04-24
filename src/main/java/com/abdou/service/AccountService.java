package com.abdou.service;

import com.abdou.entities.AppRole;
import com.abdou.entities.AppUser;

public interface AccountService {
public AppUser saveUser(AppUser user);
public AppRole saveRole(AppRole role);
public void addRoleToUser(String username, String roleName);
public AppUser findUserByUsername(String username);


}
