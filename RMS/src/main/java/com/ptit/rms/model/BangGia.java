package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BangGia")
public class BangGia {

  private int idgia;
  private MonAn monAn;
  private int gia;
  private Date ngayApDung;

  public BangGia() {
  }

  public BangGia(int idgia, MonAn monAn, int gia, Date ngayApDung) {
    this.idgia = idgia;
    this.monAn = monAn;
    this.gia = gia;
    this.ngayApDung = ngayApDung;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDGia", unique = true, nullable = false)
  public int getIdgia() {
    return this.idgia;
  }

  public void setIdgia(int idgia) {
    this.idgia = idgia;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDMonAn", nullable = false)
  public MonAn getMonAn() {
    return this.monAn;
  }

  public void setMonAn(MonAn monAn) {
    this.monAn = monAn;
  }

  @Column(name = "Gia", nullable = false, scale = 4)
  public int getGia() {
    return this.gia;
  }

  public void setGia(int gia) {
    this.gia = gia;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "NgayApDung", nullable = false, length = 10)
  public Date getNgayApDung() {
    return this.ngayApDung;
  }

  public void setNgayApDung(Date ngayApDung) {
    this.ngayApDung = ngayApDung;
  }

}
