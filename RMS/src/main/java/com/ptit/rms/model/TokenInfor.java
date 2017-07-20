package com.ptit.rms.model;

public class TokenInfor {

  private String userName;
  private String firstName1;
  private String lastName1;
  private String firstName2;
  private String lastName2;

  public TokenInfor() {
    super();
  }

  public TokenInfor(String userName, String firstName1, String lastName1, String firstName2, String lastName2) {
    super();
    this.userName = userName;
    this.firstName1 = firstName1;
    this.lastName1 = lastName1;
    this.firstName2 = firstName2;
    this.lastName2 = lastName2;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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

  public String getFirstName2() {
    return firstName2;
  }

  public void setFirstName2(String firstName2) {
    this.firstName2 = firstName2;
  }

  public String getLastName2() {
    return lastName2;
  }

  public void setLastName2(String lastName2) {
    this.lastName2 = lastName2;
  }

  @Override
  public String toString() {
    return "TokenInfor [userName=" + userName + ", firstName1=" + firstName1 + ", lastName1=" + lastName1
        + ", firstName2=" + firstName2 + ", lastName2=" + lastName2 + "]";
  }

}
