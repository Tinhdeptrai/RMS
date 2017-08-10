package com.ptit.rms.model.api;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class NhaCungCapApi {

  private int idnhaCungCap;
  private String tenNcc;
  private String diaChi;
  private String sdt;
  private String email;
  private String ngayBd;
  private String ngayKt;
  private boolean flagDelete;

  public NhaCungCapApi(int idnhaCungCap, String tenNcc, String diaChi, String sdt, String email, String ngayBd,
      String ngayKt, boolean flagDelete) {
    super();
    this.idnhaCungCap = idnhaCungCap;
    this.tenNcc = tenNcc;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.email = email;
    this.ngayBd = ngayBd;
    this.ngayKt = ngayKt;
    this.flagDelete = flagDelete;
  }

  public NhaCungCapApi(int idnhaCungCap, String tenNcc, String diaChi, String sdt, String email, boolean flagDelete) {
    super();
    this.idnhaCungCap = idnhaCungCap;
    this.tenNcc = tenNcc;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.email = email;
    this.flagDelete = flagDelete;
  }

  public int getIdnhaCungCap() {
    return idnhaCungCap;
  }

  public void setIdnhaCungCap(int idnhaCungCap) {
    this.idnhaCungCap = idnhaCungCap;
  }

  public String getTenNcc() {
    return tenNcc;
  }

  public void setTenNcc(String tenNcc) {
    this.tenNcc = tenNcc;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
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

  public String getNgayBd() {
    return ngayBd;
  }

  public void setNgayBd(Date ngayBd) {
    this.ngayBd = DateUtil.date2String(ngayBd, "MM-dd-yyyy");
  }

  public String getNgayKt() {
    return ngayKt;
  }

  public void setNgayKt(Date ngayKt) {
    this.ngayKt = DateUtil.date2String(ngayKt, "MM-dd-yyyy");
  }

  public boolean isFlagDelete() {
    return flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }
}
