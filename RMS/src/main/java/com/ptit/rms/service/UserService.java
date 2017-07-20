package com.ptit.rms.service;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.Roles;
import com.ptit.rms.model.User;
import com.ptit.rms.model.api.UsersAPI;

public interface UserService {

  User findById(int id);

  User findByUsername(String username);

  void saveUser(User user);

  void updateUser(User user);

  void deleteUserByUsername(String username);

  List<User> findAllUsers();
  
  List<Roles> getRoles();

  boolean isUserUsernameUnique(Integer id, String username);

  List<User> getListUserByDate(Date date);

  Roles findRoleByRoleName(String role);

  List<UsersAPI> convertUserToJson(List<User> list);

}
