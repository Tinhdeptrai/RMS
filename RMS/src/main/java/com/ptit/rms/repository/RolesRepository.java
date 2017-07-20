package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.Roles;

public interface RolesRepository {

  Roles findRoleByRoleName(String role);
  
  List<Roles> getAllRoles();

}
