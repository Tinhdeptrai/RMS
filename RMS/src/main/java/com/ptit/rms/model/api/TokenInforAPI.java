package com.ptit.rms.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenInforAPI {
  
  @JsonProperty("id")
  private int id;
  @JsonProperty("taikhoan")
  private String taikhoan;
  @JsonProperty("ho")
  private String ho;
  @JsonProperty("ten")
  private String ten;
  @JsonProperty("token")
  private String token;
  @JsonProperty("quyen")
  private String quyen;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTaikhoan() {
    return taikhoan;
  }

  public void setTaikhoan(String taikhoan) {
    this.taikhoan = taikhoan;
  }

  public String getHo() {
    return ho;
  }

  public void setHo(String ho) {
    this.ho = ho;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getQuyen() {
    return quyen;
  }

  public void setQuyen(String quyen) {
    this.quyen = quyen;
  }

  public TokenInforAPI(int id, String taikhoan, String ho, String ten, String token, String quyen) {
    super();
    this.id = id;
    this.taikhoan = taikhoan;
    this.ho = ho;
    this.ten = ten;
    this.token = token;
    this.quyen = quyen;
  }

  public TokenInforAPI() {
    super();
  }

}
