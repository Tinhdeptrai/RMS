package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Kho")
public class Kho {

  private int idkho;
  private HangHoa hangHoa;
  private LoaiKho loaiKho;
  private Date ngay;
  private int tongSl;
  private boolean flagDelete;

  public Kho() {
  }

  public Kho(int idkho, HangHoa hangHoa, LoaiKho loaiKho, Date ngay, int tongSl, boolean flagDelete) {
    this.idkho = idkho;
    this.hangHoa = hangHoa;
    this.loaiKho = loaiKho;
    this.ngay = ngay;
    this.tongSl = tongSl;
    this.flagDelete = flagDelete;
  }

  @Id

  @Column(name = "IDKho", unique = true, nullable = false)
  public int getIdkho() {
    return this.idkho;
  }

  public void setIdkho(int idkho) {
    this.idkho = idkho;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IDHangHoa", nullable = false)
  public HangHoa getHangHoa() {
    return this.hangHoa;
  }

  public void setHangHoa(HangHoa hangHoa) {
    this.hangHoa = hangHoa;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IDLoaiKho", nullable = false)
  public LoaiKho getLoaiKho() {
    return this.loaiKho;
  }

  public void setLoaiKho(LoaiKho loaiKho) {
    this.loaiKho = loaiKho;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "Ngay", nullable = false, length = 10)
  public Date getNgay() {
    return this.ngay;
  }

  public void setNgay(Date ngay) {
    this.ngay = ngay;
  }

  @Column(name = "TongSL", nullable = false)
  public int getTongSl() {
    return this.tongSl;
  }

  public void setTongSl(int tongSl) {
    this.tongSl = tongSl;
  }

  @Column(name = "flagDelete", nullable = false)
  public boolean isFlagDelete() {
    return this.flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }

}
