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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "HangHoa")
public class HangHoa {

  private int idhangHoa;
  private DonViTinh donViTinh;
  private String tenHang;
  private int donGia;
  private int slhienCo;
  private String ghiChu;
  private boolean flagDelete;
  private Set<DinhLuong> dinhLuongs = new HashSet<DinhLuong>(0);
  private Set<Ctddh> ctddhs = new HashSet<Ctddh>(0);
  private Set<CtphieuNhap> ctphieuNhaps = new HashSet<CtphieuNhap>(0);
  private Set<Kho> khos = new HashSet<Kho>(0);

  public HangHoa() {
  }

  public HangHoa(int idhangHoa, DonViTinh donViTinh, String tenHang, int donGia, int slhienCo, boolean flagDelete) {
    this.idhangHoa = idhangHoa;
    this.donViTinh = donViTinh;
    this.tenHang = tenHang;
    this.donGia = donGia;
    this.slhienCo = slhienCo;
    this.flagDelete = flagDelete;
  }

  public HangHoa(int idhangHoa, DonViTinh donViTinh, String tenHang, int donGia, int slhienCo, String ghiChu,
      boolean flagDelete, Set<DinhLuong> dinhLuongs, Set<Ctddh> ctddhs, Set<CtphieuNhap> ctphieuNhaps, Set<Kho> khos) {
    this.idhangHoa = idhangHoa;
    this.donViTinh = donViTinh;
    this.tenHang = tenHang;
    this.donGia = donGia;
    this.slhienCo = slhienCo;
    this.ghiChu = ghiChu;
    this.flagDelete = flagDelete;
    this.dinhLuongs = dinhLuongs;
    this.ctddhs = ctddhs;
    this.ctphieuNhaps = ctphieuNhaps;
    this.khos = khos;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDHangHoa", unique = true, nullable = false)
  public int getIdhangHoa() {
    return this.idhangHoa;
  }

  public void setIdhangHoa(int idhangHoa) {
    this.idhangHoa = idhangHoa;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDDonViTinh", nullable = false)
  public DonViTinh getDonViTinh() {
    return this.donViTinh;
  }

  public void setDonViTinh(DonViTinh donViTinh) {
    this.donViTinh = donViTinh;
  }

  @Column(name = "TenHang", nullable = false)
  public String getTenHang() {
    return this.tenHang;
  }

  public void setTenHang(String tenHang) {
    this.tenHang = tenHang;
  }

  @Column(name = "DonGia", nullable = false, scale = 4)
  public int getDonGia() {
    return this.donGia;
  }

  public void setDonGia(int donGia) {
    this.donGia = donGia;
  }
  
  @JsonIgnoreProperties(ignoreUnknown = true)
  @Column(name = "SLHienCo", nullable = false)
  public int getSlhienCo() {
    return this.slhienCo;
  }

  public void setSlhienCo(int slhienCo) {
    this.slhienCo = slhienCo;
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
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "hangHoa")
  public Set<DinhLuong> getDinhLuongs() {
    return this.dinhLuongs;
  }

  public void setDinhLuongs(Set<DinhLuong> dinhLuongs) {
    this.dinhLuongs = dinhLuongs;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "hangHoa")
  public Set<Ctddh> getCtddhs() {
    return this.ctddhs;
  }

  public void setCtddhs(Set<Ctddh> ctddhs) {
    this.ctddhs = ctddhs;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "hangHoa")
  public Set<CtphieuNhap> getCtphieuNhaps() {
    return this.ctphieuNhaps;
  }

  public void setCtphieuNhaps(Set<CtphieuNhap> ctphieuNhaps) {
    this.ctphieuNhaps = ctphieuNhaps;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "hangHoa")
  public Set<Kho> getKhos() {
    return this.khos;
  }

  public void setKhos(Set<Kho> khos) {
    this.khos = khos;
  }

}
