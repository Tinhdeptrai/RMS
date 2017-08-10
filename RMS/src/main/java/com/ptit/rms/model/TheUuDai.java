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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "TheUuDai")
public class TheUuDai {

  private int idthe;
  private String tenThe;
  private int diemThuong;
  private int chietKhau;
  private boolean flagDelete;
  private Set<KhachHang> khachHangs = new HashSet<KhachHang>(0);

  public TheUuDai() {
  }

  public TheUuDai(int idthe, String tenThe, int diemThuong, int chietKhau, boolean flagDelete) {
    this.idthe = idthe;
    this.tenThe = tenThe;
    this.diemThuong = diemThuong;
    this.chietKhau = chietKhau;
    this.flagDelete = flagDelete;
  }

  public TheUuDai(int idthe, String tenThe, int diemThuong, int chietKhau, boolean flagDelete,
      Set<KhachHang> khachHangs) {
    this.idthe = idthe;
    this.tenThe = tenThe;
    this.diemThuong = diemThuong;
    this.chietKhau = chietKhau;
    this.flagDelete = flagDelete;
    this.khachHangs = khachHangs;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDThe", unique = true, nullable = false)
  public int getIdthe() {
    return this.idthe;
  }

  public void setIdthe(int idthe) {
    this.idthe = idthe;
  }

  @Column(name = "TenThe", nullable = false)
  public String getTenThe() {
    return this.tenThe;
  }

  public void setTenThe(String tenThe) {
    this.tenThe = tenThe;
  }

  @Column(name = "DiemThuong", nullable = false)
  public int getDiemThuong() {
    return this.diemThuong;
  }

  public void setDiemThuong(int diemThuong) {
    this.diemThuong = diemThuong;
  }

  @Column(name = "ChietKhau", nullable = false)
  public int getChietKhau() {
    return this.chietKhau;
  }

  public void setChietKhau(int chietKhau) {
    this.chietKhau = chietKhau;
  }

  @Column(name = "flagDelete", nullable = false)
  public boolean isFlagDelete() {
    return this.flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "theUuDai")
  public Set<KhachHang> getKhachHangs() {
    return this.khachHangs;
  }

  public void setKhachHangs(Set<KhachHang> khachHangs) {
    this.khachHangs = khachHangs;
  }

}
