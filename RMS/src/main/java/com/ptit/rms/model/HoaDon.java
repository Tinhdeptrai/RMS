package com.ptit.rms.model;
// Generated Aug 8, 2017 12:49:31 AM by Hibernate Tools 4.3.1.Final

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

/**
 * HoaDon generated by hbm2java
 */
@Entity
@Table(name = "HoaDon")
public class HoaDon{

	private int idhoaDon;
	private DatBan datBan;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Date ngayLapHd;
	private int trangThai;
	private boolean flagDelete;

	public HoaDon() {
	}

	public HoaDon(int idhoaDon, KhachHang khachHang, NhanVien nhanVien, Date ngayLapHd, int trangThai,
			boolean flagDelete) {
		this.idhoaDon = idhoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHd = ngayLapHd;
		this.trangThai = trangThai;
		this.flagDelete = flagDelete;
	}

	public HoaDon(int idhoaDon, DatBan datBan, KhachHang khachHang, NhanVien nhanVien, Date ngayLapHd, int trangThai,
			boolean flagDelete) {
		this.idhoaDon = idhoaDon;
		this.datBan = datBan;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHd = ngayLapHd;
		this.trangThai = trangThai;
		this.flagDelete = flagDelete;
	}

	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDHoaDon", unique = true, nullable = false)
	public int getIdhoaDon() {
		return this.idhoaDon;
	}

	public void setIdhoaDon(int idhoaDon) {
		this.idhoaDon = idhoaDon;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDDatBan")
	public DatBan getDatBan() {
		return this.datBan;
	}

	public void setDatBan(DatBan datBan) {
		this.datBan = datBan;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDKhachHang", nullable = false)
	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDNhanVien", nullable = false)
	public NhanVien getNhanVien() {
		return this.nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayLapHD", nullable = false, length = 10)
	public Date getNgayLapHd() {
		return this.ngayLapHd;
	}

	public void setNgayLapHd(Date ngayLapHd) {
		this.ngayLapHd = ngayLapHd;
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
}
