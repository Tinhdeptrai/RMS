package com.ptit.rms.model.api;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ptit.rms.model.BangGia;
import com.ptit.rms.model.DanhMuc;
import com.ptit.rms.model.DinhLuong;
import com.ptit.rms.model.DonViTinh;

@JsonSerialize
public class MonAnApi {

  private int idmonAn;
  private DanhMuc danhMuc;
  private DonViTinh donViTinh;
  private String tenMon;
  private String anh;
  private String ghiChu;
  private boolean flagDelete;
  private List<DinhLuong> dinhLuong;
  private List<BangGia> bangGia;

  public MonAnApi() {
    super();
  }

  public MonAnApi(int idmonAn, DanhMuc danhMuc, DonViTinh donViTinh, String tenMon, String anh, String ghiChu,
      boolean flagDelete) {
    super();
    this.idmonAn = idmonAn;
    this.danhMuc = danhMuc;
    this.donViTinh = donViTinh;
    this.tenMon = tenMon;
    this.anh = anh;
    this.ghiChu = ghiChu;
    this.flagDelete = flagDelete;
  }

  public MonAnApi(int idmonAn, DanhMuc danhMuc, DonViTinh donViTinh, String tenMon, String anh, String ghiChu,
      boolean flagDelete, List<DinhLuong> dinhLuong, List<BangGia> bangGia) {
    super();
    this.idmonAn = idmonAn;
    this.danhMuc = danhMuc;
    this.donViTinh = donViTinh;
    this.tenMon = tenMon;
    this.anh = anh;
    this.ghiChu = ghiChu;
    this.flagDelete = flagDelete;
    this.dinhLuong = dinhLuong;
    this.bangGia = bangGia;
  }

  public int getIdmonAn() {
    return idmonAn;
  }

  public void setIdmonAn(int idmonAn) {
    this.idmonAn = idmonAn;
  }

  public DanhMuc getDanhMuc() {
    return danhMuc;
  }

  public void setDanhMuc(DanhMuc danhMuc) {
    this.danhMuc = danhMuc;
  }

  public DonViTinh getDonViTinh() {
    return donViTinh;
  }

  public void setDonViTinh(DonViTinh donViTinh) {
    this.donViTinh = donViTinh;
  }

  public String getTenMon() {
    return tenMon;
  }

  public void setTenMon(String tenMon) {
    this.tenMon = tenMon;
  }

  public String getAnh() {
    return anh;
  }

  public void setAnh(String anh) {
    this.anh = anh;
  }

  public String getGhiChu() {
    return ghiChu;
  }

  public void setGhiChu(String ghiChu) {
    this.ghiChu = ghiChu;
  }

  public boolean isFlagDelete() {
    return flagDelete;
  }

  public void setFlagDelete(boolean flagDelete) {
    this.flagDelete = flagDelete;
  }

  public List<DinhLuong> getDinhLuong() {
    return dinhLuong;
  }

  public void setDinhLuong(List<DinhLuong> dinhLuong) {
    this.dinhLuong = dinhLuong;
  }

  public List<BangGia> getBangGia() {
    return bangGia;
  }

  public void setBangGia(List<BangGia> bangGia) {
    this.bangGia = bangGia;
  }

}
