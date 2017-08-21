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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize 
@Entity
@Table(name = "DinhLuong")
public class DinhLuong {

  private DinhLuongId id;
  private HangHoa hangHoa;
  private MonAn monAn;
  private int sl;

  public DinhLuong() {
  }

  public DinhLuong(DinhLuongId id, HangHoa hangHoa, MonAn monAn, int sl) {
    this.id = id;
    this.hangHoa = hangHoa;
    this.monAn = monAn;
    this.sl = sl;
  }

  @EmbeddedId

  @AttributeOverrides({ @AttributeOverride(name = "idmonAn", column = @Column(name = "IDMonAn", nullable = false)),
      @AttributeOverride(name = "idhangHoa", column = @Column(name = "IDHangHoa", nullable = false)) })
  public DinhLuongId getId() {
    return this.id;
  }

  public void setId(DinhLuongId id) {
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
  @JoinColumn(name = "IDMonAn", nullable = false, insertable = false, updatable = false)
  public MonAn getMonAn() {
    return this.monAn;
  }

  public void setMonAn(MonAn monAn) {
    this.monAn = monAn;
  }

  @Column(name = "SL", nullable = false)
  public int getSl() {
    return this.sl;
  }

  public void setSl(int sl) {
    this.sl = sl;
  }

}
