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
@Table(name = "DonViTinh")
public class DonViTinh {

  private int iddonViTinh;
  private String tenDonVi;
  private Set<HangHoa> hangHoas = new HashSet<HangHoa>(0);
  private Set<MonAn> monAns = new HashSet<MonAn>(0);

  public DonViTinh() {
  }

  public DonViTinh(int iddonViTinh, String tenDonVi) {
    this.iddonViTinh = iddonViTinh;
    this.tenDonVi = tenDonVi;
  }

  public DonViTinh(int iddonViTinh, String tenDonVi, Set<HangHoa> hangHoas, Set<MonAn> monAns) {
    this.iddonViTinh = iddonViTinh;
    this.tenDonVi = tenDonVi;
    this.hangHoas = hangHoas;
    this.monAns = monAns;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDDonViTinh", unique = true, nullable = false)
  public int getIddonViTinh() {
    return this.iddonViTinh;
  }

  public void setIddonViTinh(int iddonViTinh) {
    this.iddonViTinh = iddonViTinh;
  }

  @Column(name = "TenDonVi", nullable = false)
  public String getTenDonVi() {
    return this.tenDonVi;
  }

  public void setTenDonVi(String tenDonVi) {
    this.tenDonVi = tenDonVi;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "donViTinh")
  public Set<HangHoa> getHangHoas() {
    return this.hangHoas;
  }

  public void setHangHoas(Set<HangHoa> hangHoas) {
    this.hangHoas = hangHoas;
  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "donViTinh")
  public Set<MonAn> getMonAns() {
    return this.monAns;
  }

  public void setMonAns(Set<MonAn> monAns) {
    this.monAns = monAns;
  }

}
