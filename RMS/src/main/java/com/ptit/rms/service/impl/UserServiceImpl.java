package com.ptit.rms.service.impl;

import com.ptit.rms.model.Roles;
import com.ptit.rms.model.User;
import com.ptit.rms.model.api.UsersAPI;
import com.ptit.rms.repository.RolesRepository;
import com.ptit.rms.repository.UserRepository;
import com.ptit.rms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private RolesRepository rolesRepository;

  public User findById(int id) {
    return this.userRepository.findById(id);
  }

  public User findByUsername(String username) {
    User user = this.userRepository.findByUsername(username);
    return user;
  }

  public void saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    this.userRepository.save(user);
  }

  public List<Roles> getRoles() {
    return this.rolesRepository.getAllRoles();
  }

  public void updateUser(User user) {
    this.userRepository.updateUser(user);
  }

  public void deleteUserByUsername(String username) {
    this.userRepository.deleteByUsername(username);
  }

  public List<User> findAllUsers() {
    return this.userRepository.findAllUsers();
  }

  public boolean isUserUsernameUnique(Integer id, String username) {
    User user = findByUsername(username);
    return (user == null || ((id != null) && (user.getId() == id)));
  }

  @Override
  public List<User> getListUserByDate(Date date) {
    return this.userRepository.getListUserByDate(date);
  }

  @Override
  public Roles findRoleByRoleName(String role) {
    return this.rolesRepository.findRoleByRoleName(role);
  }

  @Override
  public List<UsersAPI> convertUserToJson(List<User> list) {
    List<UsersAPI> usersAPIs = new ArrayList<>();
    for (User user : list) {
      UsersAPI usersAPI = new UsersAPI(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(),
          user.getLastName(), user.getFirstName1(), user.getLastName1(), user.isDeleted(), user.getRole().getRole(),
          user.getCreatedBy(), user.getUpdatedBy());
      usersAPI.setCreatedAt(user.getCreatedAt());
      usersAPI.setUpdatedAt(user.getUpdatedAt());
      usersAPIs.add(usersAPI);
    }
    return usersAPIs;
  }

}
