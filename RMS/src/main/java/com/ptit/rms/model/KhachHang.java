package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "KhachHang")
public class KhachHang {

  private int idkhachHang;
  private TheUuDai theUuDai;
  private String tenKhachHang;
  private String diaChi;
  private String sdt;
  private String email;
  private Integer diemThuong;
  private String ghiChu;
  private boolean flagDelete;
  private Set<DatBan> datBans = new HashSet<DatBan>(0);
  private Set<HoaDon> hoaDons = new HashSet<HoaDon>(0);

  public KhachHang() {
  }

  public KhachHang(int idkhachHang, TheUuDai theUuDai, String tenKhachHang, String sdt, boolean flagDelete) {
    this.idkhachHang = idkhachHang;
    this.theUuDai = theUuDai;
    this.tenKhachHang = tenKhachHang;
    this.sdt = sdt;
    this.flagDelete = flagDelete;
  }

  public KhachHang(int idkhachHang, TheUuDai theUuDai, String tenKhachHang, String diaChi, String sdt, String email,
      Integer diemThuong, String ghiChu, boolean flagDelete, Set<DatBan> datBans, Set<HoaDon> hoaDons) {
    this.idkhachHang = idkhachHang;
    this.theUuDai = theUuDai;
    this.tenKhachHang = tenKhachHang;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.email = email;
    this.diemThuong = diemThuong;
    this.ghiChu = ghiChu;
    this.flagDelete = flagDelete;
    this.datBans = datBans;
    this.hoaDons = hoaDons;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDKhachHang", unique = true, nullable = false)
  public int getIdkhachHang() {
    return this.idkhachHang;
  }

  public void setIdkhachHang(int idkhachHang) {
    this.idkhachHang = idkhachHang;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDThe", nullable = false)
  public TheUuDai getTheUuDai() {
    return this.theUuDai;
  }

  public void setTheUuDai(TheUuDai theUuDai) {
    this.theUuDai = theUuDai;
  }

  @Column(name = "TenKhachHang", nullable = false)
  public String getTenKhachHang() {
    return this.tenKhachHang;
  }

  public void setTenKhachHang(String tenKhachHang) {
    this.tenKhachHang = tenKhachHang;
  }

  @Column(name = "DiaChi")
  public String getDiaChi() {
    return this.diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  @Column(name = "SDT", nullable = false)
  public String getSdt() {
    return this.sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  @Column(name = "Email")
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "DiemThuong")
  public Integer getDiemThuong() {
    return this.diemThuong;
  }

  public void setDiemThuong(Integer diemThuong) {
    this.diemThuong = diemThuong;
  }

  @Column(name = "GhiChu")
  public String getGhiChu() {
    return this.ghiChu;
  }

  public void setGhiChu(String ghiChu) {
    this.ghiChu = ghiChu;
  }

  @Column(name = "flagDelete", nullable = false)
  public boolean isFlagDelete() {
    return this.flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
  public Set<DatBan> getDatBans() {
    return this.datBans;
  }

  public void setDatBans(Set<DatBan> datBans) {
    this.datBans = datBans;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
  public Set<HoaDon> getHoaDons() {
    return this.hoaDons;
  }

  public void setHoaDons(Set<HoaDon> hoaDons) {
    this.hoaDons = hoaDons;
  }

}
