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
@Table(name = "CTDDH")
public class Ctddh {

  private CtddhId id;
  private DonDatHang donDatHang;
  private HangHoa hangHoa;
  private int sldat;

  public Ctddh() {
  }

  public Ctddh(CtddhId id, DonDatHang donDatHang, HangHoa hangHoa, int sldat) {
    this.id = id;
    this.donDatHang = donDatHang;
    this.hangHoa = hangHoa;
    this.sldat = sldat;
  }

  @EmbeddedId

  @AttributeOverrides({
      @AttributeOverride(name = "iddonDatHang", column = @Column(name = "IDDonDatHang", nullable = false)),
      @AttributeOverride(name = "idhangHoa", column = @Column(name = "IDHangHoa", nullable = false)) })
  public CtddhId getId() {
    return this.id;
  }

  public void setId(CtddhId id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDDonDatHang", nullable = false, insertable = false, updatable = false)
  public DonDatHang getDonDatHang() {
    return this.donDatHang;
  }

  public void setDonDatHang(DonDatHang donDatHang) {
    this.donDatHang = donDatHang;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDHangHoa", nullable = false, insertable = false, updatable = false)
  public HangHoa getHangHoa() {
    return this.hangHoa;
  }

  public void setHangHoa(HangHoa hangHoa) {
    this.hangHoa = hangHoa;
  }

  @Column(name = "SLDat", nullable = false)
  public int getSldat() {
    return this.sldat;
  }

  public void setSldat(int sldat) {
    this.sldat = sldat;
  }

}
