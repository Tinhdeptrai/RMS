package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CtddhId implements java.io.Serializable {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int iddonDatHang;
	private int idhangHoa;

	public CtddhId() {
	}

	public CtddhId(int iddonDatHang, int idhangHoa) {
		this.iddonDatHang = iddonDatHang;
		this.idhangHoa = idhangHoa;
	}

	@Column(name = "IDDonDatHang", nullable = false)
	public int getIddonDatHang() {
		return this.iddonDatHang;
	}

	public void setIddonDatHang(int iddonDatHang) {
		this.iddonDatHang = iddonDatHang;
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
		if (!(other instanceof CtddhId))
			return false;
		CtddhId castOther = (CtddhId) other;

		return (this.getIddonDatHang() == castOther.getIddonDatHang())
				&& (this.getIdhangHoa() == castOther.getIdhangHoa());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIddonDatHang();
		result = 37 * result + this.getIdhangHoa();
		return result;
	}

}
