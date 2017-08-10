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

@Entity
@Table(name = "LoaiKho")
public class LoaiKho {

  private int idloaiKho;
  private String tenLoaiKho;
  private Set<Kho> khos = new HashSet<Kho>(0);

  public LoaiKho() {
  }

  public LoaiKho(int idloaiKho, String tenLoaiKho) {
    this.idloaiKho = idloaiKho;
    this.tenLoaiKho = tenLoaiKho;
  }

  public LoaiKho(int idloaiKho, String tenLoaiKho, Set<Kho> khos) {
    this.idloaiKho = idloaiKho;
    this.tenLoaiKho = tenLoaiKho;
    this.khos = khos;
  }

  @Id

  @Column(name = "IDLoaiKho", unique = true, nullable = false)
  public int getIdloaiKho() {
    return this.idloaiKho;
  }

  public void setIdloaiKho(int idloaiKho) {
    this.idloaiKho = idloaiKho;
  }

  @Column(name = "TenLoaiKho", nullable = false)
  public String getTenLoaiKho() {
    return this.tenLoaiKho;
  }

  public void setTenLoaiKho(String tenLoaiKho) {
    this.tenLoaiKho = tenLoaiKho;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiKho")
  public Set<Kho> getKhos() {
    return this.khos;
  }

  public void setKhos(Set<Kho> khos) {
    this.khos = khos;
  }

}
