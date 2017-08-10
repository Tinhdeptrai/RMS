package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize 
@Embeddable
public class DinhLuongId implements java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int idmonAn;
  private int idhangHoa;

  public DinhLuongId() {
  }

  public DinhLuongId(int idmonAn, int idhangHoa) {
    this.idmonAn = idmonAn;
    this.idhangHoa = idhangHoa;
  }

  @Column(name = "IDMonAn", nullable = false)
  public int getIdmonAn() {
    return this.idmonAn;
  }

  public void setIdmonAn(int idmonAn) {
    this.idmonAn = idmonAn;
  }

  @Column(name = "IDHangHoa", nullable = false)
  public int getIdhangHoa() {
    return this.idhangHoa;
  }

  public void setIdhangHoa(int idhangHoa) {
    this.idhangHoa = idhangHoa;
  }

  public boolean equals(Object other) {
    if ((this == other))
      return true;
    if ((other == null))
      return false;
    if (!(other instanceof DinhLuongId))
      return false;
    DinhLuongId castOther = (DinhLuongId) other;

    return (this.getIdmonAn() == castOther.getIdmonAn()) && (this.getIdhangHoa() == castOther.getIdhangHoa());
  }

  public int hashCode() {
    int result = 17;

    result = 37 * result + this.getIdmonAn();
    result = 37 * result + this.getIdhangHoa();
    return result;
  }

}
