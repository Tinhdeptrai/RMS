package com.ptit.rms.repository;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.User;

public interface UserRepository {

  User findById(int id);

  User findByUsername(String sso);

  void save(User user);

  void deleteByUsername(String sso);

  List<User> findAllUsers();

  void updateUser(User user);

  List<User> getListUserByDate(Date date);

}
