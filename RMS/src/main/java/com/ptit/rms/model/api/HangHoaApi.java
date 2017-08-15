package com.ptit.rms.model.api;

public class HangHoaApi {
  private int idhangHoa;
  private String donViTinh;
  private String tenHang;
  private int donGia;
  private int slhienCo;
  private String ghiChu;

  public HangHoaApi() {
    super();
  }

  public HangHoaApi(int idhangHoa, String donViTinh, String tenHang, int donGia, int slhienCo, String ghiChu) {
    super();
    this.idhangHoa = idhangHoa;
    this.donViTinh = donViTinh;
    this.tenHang = tenHang;
    this.donGia = donGia;
    this.slhienCo = slhienCo;
    this.ghiChu = ghiChu;
  }

  public int getIdhangHoa() {
    return idhangHoa;
  }

  public void setIdhangHoa(int idhangHoa) {
    this.idhangHoa = idhangHoa;
  }

  public String getDonViTinh() {
    return donViTinh;
  }

  public void setDonViTinh(String donViTinh) {
    this.donViTinh = donViTinh;
  }

  public int getDonGia() {
    return donGia;
  }

  public void setDonGia(int donGia) {
    this.donGia = donGia;
  }

  public String getGhiChu() {
    return ghiChu;
  }

  public void setGhiChu(String ghiChu) {
    this.ghiChu = ghiChu;
  }

  public String getTenHang() {
    return tenHang;
  }

  public void setTenHang(String tenHangHoa) {
    this.tenHang = tenHangHoa;
  }

  public int getSlhienCo() {
    return slhienCo;
  }

  public void setSlhienCo(int slHienCo) {
    this.slhienCo = slHienCo;
  }

}
