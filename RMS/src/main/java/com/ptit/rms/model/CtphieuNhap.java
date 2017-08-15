package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CTPhieuNhap")
public class CtphieuNhap {

  private CtphieuNhapId id;
  private HangHoa hangHoa;
  private PhieuNhap phieuNhap;
  private int slNhap;

  public CtphieuNhap() {
  }

  public CtphieuNhap(CtphieuNhapId id, HangHoa hangHoa, PhieuNhap phieuNhap, int slNhap) {
    this.id = id;
    this.hangHoa = hangHoa;
    this.phieuNhap = phieuNhap;
    this.slNhap = slNhap;
  }

  @EmbeddedId

  @AttributeOverrides({
      @AttributeOverride(name = "idphieuNhap", column = @Column(name = "IDPhieuNhap", nullable = false)),
      @AttributeOverride(name = "idhangHoa", column = @Column(name = "IDHangHoa", nullable = false)) })
  public CtphieuNhapId getId() {
    return this.id;
  }

  public void setId(CtphieuNhapId id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDHangHoa", nullable = false, insertable = false, updatable = false)
  public HangHoa getHangHoa() {
    return this.hangHoa;
  }

  public void setHangHoa(HangHoa hangHoa) {
    this.hangHoa = hangHoa;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDPhieuNhap", nullable = false, insertable = false, updatable = false)
  public PhieuNhap getPhieuNhap() {
    return this.phieuNhap;
  }

  public void setPhieuNhap(PhieuNhap phieuNhap) {
    this.phieuNhap = phieuNhap;
  }

  @Column(name = "SlNhap", nullable = false)
  public int getSlNhap() {
    return this.slNhap;
  }

  public void setSlNhap(int slNhap) {
    this.slNhap = slNhap;
  }

}
