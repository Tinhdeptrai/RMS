package com.ptit.rms.model.api;

public class KhachHangApi {
  private int idkhachHang;
  private String tenKhachHang;
  private String the;
  private String diaChi;
  private String sdt;
  private String email;
  private String diemThuong;
  private String ghiChu;
  private int chietkhau;

  public KhachHangApi(int idkhachHang, String tenkhachhang, String the, String diachi, String sdt, String email,
      String diemthuong, String ghichu, int chietkhau) {
    super();
    this.idkhachHang = idkhachHang;
    this.tenKhachHang = tenkhachhang;
    this.the = the;
    this.diaChi = diachi;
    this.sdt = sdt;
    this.email = email;
    this.diemThuong = diemthuong;
    this.ghiChu = ghichu;
    this.chietkhau = chietkhau;
  }

  public KhachHangApi(int idkhachHang, String tenkhachhang, String the, String diachi, String sdt, String email,
      String diemthuong, String ghichu) {
    super();
    this.idkhachHang = idkhachHang;
    this.tenKhachHang = tenkhachhang;
    this.the = the;
    this.diaChi = diachi;
    this.sdt = sdt;
    this.email = email;
    this.diemThuong = diemthuong;
    this.ghiChu = ghichu;
  }

  public KhachHangApi() {
    super();
  }

  public int getIdkhachHang() {
    return idkhachHang;
  }

  public void setId(int idkhachHang) {
    this.idkhachHang = idkhachHang;
  }

  public String getTenkhachhang() {
    return tenKhachHang;
  }

  public void setTenkhachhang(String tenkhachhang) {
    this.tenKhachHang = tenkhachhang;
  }

  public String getThe() {
    return the;
  }

  public void setThe(String the) {
    this.the = the;
  }

  public String getDiachi() {
    return diaChi;
  }

  public void setDiachi(String diachi) {
    this.diaChi = diachi;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDiemthuong() {
    return diemThuong;
  }

  public void setDiemthuong(String diemthuong) {
    this.diemThuong = diemthuong;
  }

  public String getGhichu() {
    return ghiChu;
  }

  public void setGhichu(String ghichu) {
    this.ghiChu = ghichu;
  }

  public int getChietkhau() {
    return chietkhau;
  }

  public void setChietkhau(int chietkhau) {
    this.chietkhau = chietkhau;
  }

}
