package com.ptit.rms.model;
// Generated Jul 22, 2017 11:11:39 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CtphieuNhapId implements java.io.Serializable {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int idphieuNhap;
	private int idhangHoa;

	public CtphieuNhapId() {
	}

	public CtphieuNhapId(int idphieuNhap, int idhangHoa) {
		this.idphieuNhap = idphieuNhap;
		this.idhangHoa = idhangHoa;
	}

	@Column(name = "IDPhieuNhap", nullable = false)
	public int getIdphieuNhap() {
		return this.idphieuNhap;
	}

	public void setIdphieuNhap(int idphieuNhap) {
		this.idphieuNhap = idphieuNhap;
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
		if (!(other instanceof CtphieuNhapId))
			return false;
		CtphieuNhapId castOther = (CtphieuNhapId) other;

		return (this.getIdphieuNhap() == castOther.getIdphieuNhap())
				&& (this.getIdhangHoa() == castOther.getIdhangHoa());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdphieuNhap();
		result = 37 * result + this.getIdhangHoa();
		return result;
	}

}
