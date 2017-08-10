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
@Table(name = "NhanVien")
public class NhanVien {

  private Integer idnhanVien;
  private Quyen quyen;
  private String ho;
  private String ten;
  private String matKhau;
  private String taiKhoan;
  private String diaChi;
  private String sdt;
  private boolean flagDelete;
  private Set<DonDatHang> donDatHangs = new HashSet<DonDatHang>(0);
  private Set<DatBan> datBans = new HashSet<DatBan>(0);
  private Set<HoaDon> hoaDons = new HashSet<HoaDon>(0);
  private Set<PhieuNhap> phieuNhaps = new HashSet<PhieuNhap>(0);

  public NhanVien() {
  }

  public NhanVien(int idnhanVien, Quyen quyen, String ho, String ten, String matKhau, String diaChi, String sdt,
      boolean flagDelete) {
    this.idnhanVien = idnhanVien;
    this.quyen = quyen;
    this.ho = ho;
    this.ten = ten;
    this.matKhau = matKhau;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.flagDelete = flagDelete;
  }

  public NhanVien(int idnhanVien, Quyen quyen, String ho, String ten, String matKhau, String taiKhoan, String diaChi,
      String sdt, boolean flagDelete, Set<DonDatHang> donDatHangs, Set<DatBan> datBans, Set<HoaDon> hoaDons,
      Set<PhieuNhap> phieuNhaps) {
    this.idnhanVien = idnhanVien;
    this.quyen = quyen;
    this.ho = ho;
    this.ten = ten;
    this.matKhau = matKhau;
    this.taiKhoan = taiKhoan;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.flagDelete = flagDelete;
    this.donDatHangs = donDatHangs;
    this.datBans = datBans;
    this.hoaDons = hoaDons;
    this.phieuNhaps = phieuNhaps;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDNhanVien", unique = true, nullable = false)
  public Integer getIdnhanVien() {
    return this.idnhanVien;
  }

  public void setIdnhanVien(int idnhanVien) {
    this.idnhanVien = idnhanVien;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDQuyen", nullable = false)
  public Quyen getQuyen() {
    return this.quyen;
  }

  public void setQuyen(Quyen quyen) {
    this.quyen = quyen;
  }

  @Column(name = "Ho", nullable = false)
  public String getHo() {
    return this.ho;
  }

  public void setHo(String ho) {
    this.ho = ho;
  }

  @Column(name = "Ten", nullable = false)
  public String getTen() {
    return this.ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  @Column(name = "MatKhau", nullable = false)
  public String getMatKhau() {
    return this.matKhau;
  }

  public void setMatKhau(String matKhau) {
    this.matKhau = matKhau;
  }

  @Column(name = "TaiKhoan", nullable = false)
  public String getTaiKhoan() {
    return this.taiKhoan;
  }

  public void setTaiKhoan(String taiKhoan) {
    this.taiKhoan = taiKhoan;
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

  @Column(name = "flagDelete", nullable = false)
  public boolean isFlagDelete() {
    return this.flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVien")
  public Set<DonDatHang> getDonDatHangs() {
    return this.donDatHangs;
  }

  public void setDonDatHangs(Set<DonDatHang> donDatHangs) {
    this.donDatHangs = donDatHangs;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVien")
  public Set<DatBan> getDatBans() {
    return this.datBans;
  }

  public void setDatBans(Set<DatBan> datBans) {
    this.datBans = datBans;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVien")
  public Set<HoaDon> getHoaDons() {
    return this.hoaDons;
  }

  public void setHoaDons(Set<HoaDon> hoaDons) {
    this.hoaDons = hoaDons;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVien")
  public Set<PhieuNhap> getPhieuNhaps() {
    return this.phieuNhaps;
  }

  public void setPhieuNhaps(Set<PhieuNhap> phieuNhaps) {
    this.phieuNhaps = phieuNhaps;
  }

}
