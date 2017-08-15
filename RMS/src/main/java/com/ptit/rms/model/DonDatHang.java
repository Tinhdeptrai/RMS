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
@Table(name = "DonDatHang")
public class DonDatHang {

  private int iddonDatHang;
  private NhaCungCap nhaCungCap;
  private NhanVien nhanVien;
  private Date ngayDatHang;
  private int trangThai;
  private boolean flagdelete;
  private Set<PhieuNhap> phieuNhaps = new HashSet<PhieuNhap>(0);
  private Set<Ctddh> ctddhs = new HashSet<Ctddh>(0);

  public DonDatHang() {
  }

  public DonDatHang(int iddonDatHang, NhaCungCap nhaCungCap, NhanVien nhanVien, Date ngayDatHang, int trangThai,
      boolean flagdelete) {
    this.iddonDatHang = iddonDatHang;
    this.nhaCungCap = nhaCungCap;
    this.nhanVien = nhanVien;
    this.ngayDatHang = ngayDatHang;
    this.trangThai = trangThai;
    this.flagdelete = flagdelete;
  }

  public DonDatHang(int iddonDatHang, NhaCungCap nhaCungCap, NhanVien nhanVien, Date ngayDatHang, int trangThai,
      boolean flagdelete, Set<PhieuNhap> phieuNhaps, Set<Ctddh> ctddhs) {
    this.iddonDatHang = iddonDatHang;
    this.nhaCungCap = nhaCungCap;
    this.nhanVien = nhanVien;
    this.ngayDatHang = ngayDatHang;
    this.trangThai = trangThai;
    this.flagdelete = flagdelete;
    this.phieuNhaps = phieuNhaps;
    this.ctddhs = ctddhs;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDDonDatHang", unique = true, nullable = false)
  public int getIddonDatHang() {
    return this.iddonDatHang;
  }

  public void setIddonDatHang(int iddonDatHang) {
    this.iddonDatHang = iddonDatHang;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDNhaCungCap", nullable = false)
  public NhaCungCap getNhaCungCap() {
    return this.nhaCungCap;
  }

  public void setNhaCungCap(NhaCungCap nhaCungCap) {
    this.nhaCungCap = nhaCungCap;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDNhanVien", nullable = false)
  public NhanVien getNhanVien() {
    return this.nhanVien;
  }

  public void setNhanVien(NhanVien nhanVien) {
    this.nhanVien = nhanVien;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "NgayDatHang", nullable = false, length = 10)
  public Date getNgayDatHang() {
    return this.ngayDatHang;
  }

  public void setNgayDatHang(Date ngayDatHang) {
    this.ngayDatHang = ngayDatHang;
  }

  @Column(name = "TrangThai", nullable = false)
  public int getTrangThai() {
    return this.trangThai;
  }

  public void setTrangThai(int trangThai) {
    this.trangThai = trangThai;
  }

  @Column(name = "flagdelete", nullable = false)
  public boolean isFlagdelete() {
    return this.flagdelete;
  }

  public void setFlagdelete(boolean flagdelete) {
    this.flagdelete = flagdelete;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "donDatHang")
  public Set<PhieuNhap> getPhieuNhaps() {
    return this.phieuNhaps;
  }

  public void setPhieuNhaps(Set<PhieuNhap> phieuNhaps) {
    this.phieuNhaps = phieuNhaps;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "donDatHang")
  public Set<Ctddh> getCtddhs() {
    return this.ctddhs;
  }

  public void setCtddhs(Set<Ctddh> ctddhs) {
    this.ctddhs = ctddhs;
  }

}
