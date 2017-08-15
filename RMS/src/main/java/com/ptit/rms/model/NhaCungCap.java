package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {

  private int idnhaCungCap;
  private String tenNcc;
  private String diaChi;
  private String sdt;
  private String email;
  private Date ngayBd;
  private Date ngayKt;
  private boolean flagDelete;
  private Set<DonDatHang> donDatHangs = new HashSet<DonDatHang>(0);

  public NhaCungCap() {
  }

  public NhaCungCap(int idnhaCungCap, String tenNcc, String diaChi, String sdt, String email, Date ngayBd,
      boolean flagDelete) {
    this.idnhaCungCap = idnhaCungCap;
    this.tenNcc = tenNcc;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.email = email;
    this.ngayBd = ngayBd;
    this.flagDelete = flagDelete;
  }

  public NhaCungCap(int idnhaCungCap, String tenNcc, String diaChi, String sdt, String email, Date ngayBd, Date ngayKt,
      boolean flagDelete, Set<DonDatHang> donDatHangs) {
    this.idnhaCungCap = idnhaCungCap;
    this.tenNcc = tenNcc;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.email = email;
    this.ngayBd = ngayBd;
    this.ngayKt = ngayKt;
    this.flagDelete = flagDelete;
    this.donDatHangs = donDatHangs;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDNhaCungCap", unique = true, nullable = false)
  public int getIdnhaCungCap() {
    return this.idnhaCungCap;
  }

  public void setIdnhaCungCap(int idnhaCungCap) {
    this.idnhaCungCap = idnhaCungCap;
  }

  @Column(name = "TenNCC", nullable = false)
  public String getTenNcc() {
    return this.tenNcc;
  }

  public void setTenNcc(String tenNcc) {
    this.tenNcc = tenNcc;
  }

  @Column(name = "DiaChi", nullable = false)
  public String getDiaChi() {
    return this.diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  @Column(name = "sdt", nullable = false)
  public String getSdt() {
    return this.sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  @Column(name = "email", nullable = false)
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "NgayBD", nullable = false, length = 10)
  public Date getNgayBd() {
    return this.ngayBd;
  }

  public void setNgayBd(Date ngayBd) {
    this.ngayBd = ngayBd;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "NgayKT", length = 10)
  public Date getNgayKt() {
    return this.ngayKt;
  }

  public void setNgayKt(Date ngayKt) {
    this.ngayKt = ngayKt;
  }

  @Column(name = "flagDelete", nullable = false)
  public boolean isFlagDelete() {
    return this.flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "nhaCungCap")
  public Set<DonDatHang> getDonDatHangs() {
    return this.donDatHangs;
  }

  public void setDonDatHangs(Set<DonDatHang> donDatHangs) {
    this.donDatHangs = donDatHangs;
  }

}
