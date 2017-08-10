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
@Table(name = "Ban")
public class Ban {

  private int idban;
  private String tenBan;
  private Integer slnguoi;
  private int trangThai;
  private boolean flagDelete;
  private Set<DatBan> datBans = new HashSet<DatBan>(0);

  public Ban() {
  }

  public Ban(int idban, String tenBan, int trangThai, boolean flagDelete) {
    this.idban = idban;
    this.tenBan = tenBan;
    this.trangThai = trangThai;
    this.flagDelete = flagDelete;
  }

  public Ban(int idban, String tenBan, Integer slnguoi, int trangThai, boolean flagDelete, Set<DatBan> datBans) {
    this.idban = idban;
    this.tenBan = tenBan;
    this.slnguoi = slnguoi;
    this.trangThai = trangThai;
    this.flagDelete = flagDelete;
    this.datBans = datBans;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDBan", unique = true, nullable = false)
  public int getIdban() {
    return this.idban;
  }

  public void setIdban(int idban) {
    this.idban = idban;
  }

  @Column(name = "TenBan", nullable = false)
  public String getTenBan() {
    return this.tenBan;
  }

  public void setTenBan(String tenBan) {
    this.tenBan = tenBan;
  }

  @Column(name = "SLNguoi")
  public Integer getSlnguoi() {
    return this.slnguoi;
  }

  public void setSlnguoi(Integer slnguoi) {
    this.slnguoi = slnguoi;
  }

  @Column(name = "TrangThai", nullable = false)
  public int getTrangThai() {
    return this.trangThai;
  }

  public void setTrangThai(int trangThai) {
    this.trangThai = trangThai;
  }

  @Column(name = "flagDelete", nullable = false)
  public boolean isFlagDelete() {
    return this.flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }
  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "ban")
  public Set<DatBan> getDatBans() {
    return this.datBans;
  }

  public void setDatBans(Set<DatBan> datBans) {
    this.datBans = datBans;
  }

}
