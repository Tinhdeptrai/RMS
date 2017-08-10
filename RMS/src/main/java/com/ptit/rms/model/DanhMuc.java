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
@Table(name = "DanhMuc")
public class DanhMuc {

  private int iddanhMuc;
  private String tenDanhMuc;
  private Set<MonAn> monAns = new HashSet<MonAn>(0);

  public DanhMuc() {
  }

  public DanhMuc(int iddanhMuc, String tenDanhMuc) {
    this.iddanhMuc = iddanhMuc;
    this.tenDanhMuc = tenDanhMuc;
  }

  public DanhMuc(int iddanhMuc, String tenDanhMuc, Set<MonAn> monAns) {
    this.iddanhMuc = iddanhMuc;
    this.tenDanhMuc = tenDanhMuc;
    this.monAns = monAns;
  }

  @Id

  @Column(name = "IDDanhMuc", unique = true, nullable = false)
  public int getIddanhMuc() {
    return this.iddanhMuc;
  }

  public void setIddanhMuc(int iddanhMuc) {
    this.iddanhMuc = iddanhMuc;
  }

  @Column(name = "TenDanhMuc", nullable = false)
  public String getTenDanhMuc() {
    return this.tenDanhMuc;
  }

  public void setTenDanhMuc(String tenDanhMuc) {
    this.tenDanhMuc = tenDanhMuc;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "danhMuc")
  public Set<MonAn> getMonAns() {
    return this.monAns;
  }

  public void setMonAns(Set<MonAn> monAns) {
    this.monAns = monAns;
  }

}
