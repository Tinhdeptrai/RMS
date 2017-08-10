package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PhieuNhap")
public class PhieuNhap {

  private int idphieuNhap;
  private DonDatHang donDatHang;
  private NhanVien nhanVien;
  private Date nhayNhap;
  private boolean flagDelete;
  private Set<CtphieuNhap> ctphieuNhaps = new HashSet<CtphieuNhap>(0);

  public PhieuNhap() {
  }

  public PhieuNhap(int idphieuNhap, DonDatHang donDatHang, NhanVien nhanVien, Date nhayNhap, boolean flagDelete) {
    this.idphieuNhap = idphieuNhap;
    this.donDatHang = donDatHang;
    this.nhanVien = nhanVien;
    this.nhayNhap = nhayNhap;
    this.flagDelete = flagDelete;
  }

  public PhieuNhap(int idphieuNhap, DonDatHang donDatHang, NhanVien nhanVien, Date nhayNhap, boolean flagDelete,
      Set<CtphieuNhap> ctphieuNhaps) {
    this.idphieuNhap = idphieuNhap;
    this.donDatHang = donDatHang;
    this.nhanVien = nhanVien;
    this.nhayNhap = nhayNhap;
    this.flagDelete = flagDelete;
    this.ctphieuNhaps = ctphieuNhaps;
  }

  @Id

  @Column(name = "IDPhieuNhap", unique = true, nullable = false)
  public int getIdphieuNhap() {
    return this.idphieuNhap;
  }

  public void setIdphieuNhap(int idphieuNhap) {
    this.idphieuNhap = idphieuNhap;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IDDonDatHang", nullable = false)
  public DonDatHang getDonDatHang() {
    return this.donDatHang;
  }

  public void setDonDatHang(DonDatHang donDatHang) {
    this.donDatHang = donDatHang;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IDNhanVien", nullable = false)
  public NhanVien getNhanVien() {
    return this.nhanVien;
  }

  public void setNhanVien(NhanVien nhanVien) {
    this.nhanVien = nhanVien;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "NhayNhap", nullable = false, length = 10)
  public Date getNhayNhap() {
    return this.nhayNhap;
  }

  public void setNhayNhap(Date nhayNhap) {
    this.nhayNhap = nhayNhap;
  }

  @Column(name = "flagDelete", nullable = false)
  public boolean isFlagDelete() {
    return this.flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuNhap")
  public Set<CtphieuNhap> getCtphieuNhaps() {
    return this.ctphieuNhaps;
  }

  public void setCtphieuNhaps(Set<CtphieuNhap> ctphieuNhaps) {
    this.ctphieuNhaps = ctphieuNhaps;
  }

}
