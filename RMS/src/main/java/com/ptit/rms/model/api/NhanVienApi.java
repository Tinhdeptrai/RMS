package com.ptit.rms.model.api;

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class NhanVienApi {
  private int id;
  private String taikhoan;
  private String matkhau;
  private String ho;
  private String ten;
  private String diachi;
  private String sdt;
  private String ngaylamviec;
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

  public String getMatkhau() {
    return matkhau;
  }

  public void setMatkhau(String matkhau) {
    this.matkhau = matkhau;
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

  public String getDiachi() {
    return diachi;
  }

  public void setDiachi(String diachi) {
    this.diachi = diachi;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  public String getNgaylamviec() {
    return ngaylamviec;
  }

  public void setNgaylamviec(Date ngaylamviec) {
    this.ngaylamviec = DateUtil.date2String(ngaylamviec, "MM-dd-yyyy");
  }

  public String getQuyen() {
    return quyen;
  }

  public void setQuyen(String quyen) {
    this.quyen = quyen;
  }

  public NhanVienApi(int id, String taikhoan, String matkhau, String ho, String ten, String diachi, String sdt,
      String ngaylamviec, String quyen) {
    super();
    this.id = id;
    this.taikhoan = taikhoan;
    this.matkhau = matkhau;
    this.ho = ho;
    this.ten = ten;
    this.diachi = diachi;
    this.sdt = sdt;
    this.ngaylamviec = ngaylamviec;
    this.quyen = quyen;
  }

  public NhanVienApi() {
    super();
  }

  public NhanVienApi(int id, String taikhoan, String matkhau, String ho, String ten, String diachi, String sdt,
      String quyen) {
    super();
    this.id = id;
    this.taikhoan = taikhoan;
    this.matkhau = matkhau;
    this.ho = ho;
    this.ten = ten;
    this.diachi = diachi;
    this.sdt = sdt;
    this.quyen = quyen;
  }

}
