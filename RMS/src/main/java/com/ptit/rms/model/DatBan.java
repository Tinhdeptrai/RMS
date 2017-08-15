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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DatBan")
public class DatBan {

  private int iddatBan;
  private Ban ban;
  private KhachHang khachHang;
  private Menu menu;
  private NhanVien nhanVien;
  private Integer slnguoi;
  private Date ngayGioDat;
  private int trangThai;
  private String ghiChu;
  private Boolean flagdelete;
  private Set<HoaDon> hoaDons = new HashSet<HoaDon>(0);

  public DatBan() {
  }

  public DatBan(int iddatBan, Ban ban, KhachHang khachHang, Menu menu, Date ngayGioDat, int trangThai) {
    this.iddatBan = iddatBan;
    this.ban = ban;
    this.khachHang = khachHang;
    this.menu = menu;
    this.ngayGioDat = ngayGioDat;
    this.trangThai = trangThai;
  }

  public DatBan(int iddatBan, Ban ban, KhachHang khachHang, Menu menu, NhanVien nhanVien, Integer slnguoi,
      Date ngayGioDat, int trangThai, String ghiChu, Boolean flagdelete, Set<HoaDon> hoaDons) {
    this.iddatBan = iddatBan;
    this.ban = ban;
    this.khachHang = khachHang;
    this.menu = menu;
    this.nhanVien = nhanVien;
    this.slnguoi = slnguoi;
    this.ngayGioDat = ngayGioDat;
    this.trangThai = trangThai;
    this.ghiChu = ghiChu;
    this.flagdelete = flagdelete;
    this.hoaDons = hoaDons;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDDatBan", unique = true, nullable = false)
  public int getIddatBan() {
    return this.iddatBan;
  }

  public void setIddatBan(int iddatBan) {
    this.iddatBan = iddatBan;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDBan", nullable = false)
  public Ban getBan() {
    return this.ban;
  }

  public void setBan(Ban ban) {
    this.ban = ban;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDKhachHang", nullable = false)
  public KhachHang getKhachHang() {
    return this.khachHang;
  }

  public void setKhachHang(KhachHang khachHang) {
    this.khachHang = khachHang;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDMenu", nullable = false)
  public Menu getMenu() {
    return this.menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDNhanVien")
  public NhanVien getNhanVien() {
    return this.nhanVien;
  }

  public void setNhanVien(NhanVien nhanVien) {
    this.nhanVien = nhanVien;
  }

  @Column(name = "SLNguoi")
  public Integer getSlnguoi() {
    return this.slnguoi;
  }

  public void setSlnguoi(Integer slnguoi) {
    this.slnguoi = slnguoi;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "NgayDat", nullable = false, length = 23)
  public Date getNgayGioDat() {
    return this.ngayGioDat;
  }

  public void setNgayGioDat(Date ngayGioDat) {
    this.ngayGioDat = ngayGioDat;
  }

  @Column(name = "TrangThai", nullable = false)
  public int getTrangThai() {
    return this.trangThai;
  }

  public void setTrangThai(int trangThai) {
    this.trangThai = trangThai;
  }

  @Column(name = "GhiChu")
  public String getGhiChu() {
    return this.ghiChu;
  }

  public void setGhiChu(String ghiChu) {
    this.ghiChu = ghiChu;
  }

  @Column(name = "flagdelete")
  public Boolean getFlagdelete() {
    return this.flagdelete;
  }

  public void setFlagdelete(Boolean flagdelete) {
    this.flagdelete = flagdelete;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "datBan")
  public Set<HoaDon> getHoaDons() {
    return this.hoaDons;
  }

  public void setHoaDons(Set<HoaDon> hoaDons) {
    this.hoaDons = hoaDons;
  }

}
