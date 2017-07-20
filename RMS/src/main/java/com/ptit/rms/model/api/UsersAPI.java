package com.ptit.rms.model.api;

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class UsersAPI {

  private Integer id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String firstName1;
  private String lastName1;
  private boolean isDeleted;
  private String role;
  private String createdAt;
  private String updatedAt;
  private Integer createdBy;
  private Integer updatedBy;

  public UsersAPI() {
    super();
  }

  public UsersAPI(Integer id, String username, String password, String firstName, String lastName, String firstName1,
      String lastName1, boolean isDeleted, String role, String createdAt, String updatedAt, Integer createdBy,
      Integer updatedBy) {
    super();
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.firstName1 = firstName1;
    this.lastName1 = lastName1;
    this.isDeleted = isDeleted;
    this.role = role;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public UsersAPI(Integer id, String username, String password, String firstName, String lastName, String firstName1,
      String lastName1, boolean isDeleted, String role, Integer createdBy, Integer updatedBy) {
    super();
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.firstName1 = firstName1;
    this.lastName1 = lastName1;
    this.isDeleted = isDeleted;
    this.role = role;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName1() {
    return firstName1;
  }

  public void setFirstName1(String firstName1) {
    this.firstName1 = firstName1;
  }

  public String getLastName1() {
    return lastName1;
  }

  public void setLastName1(String lastName1) {
    this.lastName1 = lastName1;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = DateUtil.date2String(createdAt, "MM-dd-yyyy HH:mm:ss");
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = DateUtil.date2String(updatedAt, "MM-dd-yyyy HH:mm:ss");

  }

  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public Integer getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

}
