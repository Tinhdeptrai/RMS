package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "MonAn")
public class MonAn {

  private int idmonAn;
  private DanhMuc danhMuc;
  private DonViTinh donViTinh;
  private String tenMon;
  private String anh;
  private String ghiChu;
  private boolean flagDelete;
  private Set<DinhLuong> dinhLuongs = new HashSet<DinhLuong>(0);
  private Set<BangGia> bangGias = new HashSet<BangGia>(0);

  public MonAn() {
  }

  public MonAn(int idmonAn, DonViTinh donViTinh, String tenMon, boolean flagDelete) {
    this.idmonAn = idmonAn;
    this.donViTinh = donViTinh;
    this.tenMon = tenMon;
    this.flagDelete = flagDelete;
  }

  public MonAn(int idmonAn, DanhMuc danhMuc, DonViTinh donViTinh, String tenMon, String anh, String ghiChu,
      boolean flagDelete, Set<DinhLuong> dinhLuongs, Set<BangGia> bangGias) {
    this.idmonAn = idmonAn;
    this.danhMuc = danhMuc;
    this.donViTinh = donViTinh;
    this.tenMon = tenMon;
    this.anh = anh;
    this.ghiChu = ghiChu;
    this.flagDelete = flagDelete;
    this.dinhLuongs = dinhLuongs;
    this.bangGias = bangGias;
  }

  @Id

  @Column(name = "IDMonAn", unique = true, nullable = false)
  public int getIdmonAn() {
    return this.idmonAn;
  }

  public void setIdmonAn(int idmonAn) {
    this.idmonAn = idmonAn;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDDanhMuc")
  public DanhMuc getDanhMuc() {
    return this.danhMuc;
  }

  public void setDanhMuc(DanhMuc danhMuc) {
    this.danhMuc = danhMuc;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDDonViTinh", nullable = false)
  public DonViTinh getDonViTinh() {
    return this.donViTinh;
  }

  public void setDonViTinh(DonViTinh donViTinh) {
    this.donViTinh = donViTinh;
  }

  @Column(name = "TenMon", nullable = false)
  public String getTenMon() {
    return this.tenMon;
  }

  public void setTenMon(String tenMon) {
    this.tenMon = tenMon;
  }

  @Column(name = "Anh")
  public String getAnh() {
    return this.anh;
  }

  public void setAnh(String anh) {
    this.anh = anh;
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
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "monAn")
  public Set<DinhLuong> getDinhLuongs() {
    return this.dinhLuongs;
  }

  public void setDinhLuongs(Set<DinhLuong> dinhLuongs) {
    this.dinhLuongs = dinhLuongs;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "monAn")
  public Set<BangGia> getBangGias() {
    return this.bangGias;
  }

  public void setBangGias(Set<BangGia> bangGias) {
    this.bangGias = bangGias;
  }

}
