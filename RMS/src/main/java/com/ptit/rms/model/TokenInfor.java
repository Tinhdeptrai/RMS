package com.ptit.rms.model;

public class TokenInfor {

  private String taiKhoan;
  private String ho;
  private String ten;
  private String quyen;

  public TokenInfor() {
    super();
  }

  public TokenInfor(String taiKhoan, String ho, String ten, String quyen) {
    super();
    this.taiKhoan = taiKhoan;
    this.ho = ho;
    this.ten = ten;
    this.quyen = quyen;
  }

  public String getTaiKhoan() {
    return taiKhoan;
  }

  public void setTaiKhoan(String taiKhoan) {
    this.taiKhoan = taiKhoan;
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

  public String getQuyen() {
    return quyen;
  }

  public void setQuyen(String quyen) {
    this.quyen = quyen;
  }

}
