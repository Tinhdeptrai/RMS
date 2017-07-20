package com.ptit.rms.model.api;

public class TokenInforAPI {
  private String token;

  public TokenInforAPI(String token) {
    super();
    this.token = token;
  }

  public TokenInforAPI() {
    super();
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
