package com.ptit.rms.ultil;

import java.io.Serializable;

public enum UserProfileRole implements Serializable {
  USER("USER"), ADMIN("ADMIN");

  String userProfileRole;

  private UserProfileRole(String userProfileRole) {
    this.userProfileRole = userProfileRole;
  }

  public String getUserProfileRole() {
    return userProfileRole;
  }

}
