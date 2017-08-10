package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Quyen")
public class Quyen {

  private int idquyen;
  private String tenQuyen;
  private Set<NhanVien> nhanViens = new HashSet<NhanVien>(0);

  public Quyen() {
  }

  public Quyen(int idquyen, String tenQuyen) {
    this.idquyen = idquyen;
    this.tenQuyen = tenQuyen;
  }

  public Quyen(int idquyen, String tenQuyen, Set<NhanVien> nhanViens) {
    this.idquyen = idquyen;
    this.tenQuyen = tenQuyen;
    this.nhanViens = nhanViens;
  }

  @Id

  @Column(name = "IDQuyen", unique = true, nullable = false)
  public int getIdquyen() {
    return this.idquyen;
  }

  public void setIdquyen(int idquyen) {
    this.idquyen = idquyen;
  }

  @Column(name = "TenQuyen", nullable = false)
  public String getTenQuyen() {
    return this.tenQuyen;
  }

  public void setTenQuyen(String tenQuyen) {
    this.tenQuyen = tenQuyen;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "quyen")
  public Set<NhanVien> getNhanViens() {
    return this.nhanViens;
  }

  public void setNhanViens(Set<NhanVien> nhanViens) {
    this.nhanViens = nhanViens;
  }

}
