package com.ptit.rms.model.api;

public class HangHoaApi {
  private int idhangHoa;
  private String donViTinh;
  private String tenHangHoa;
  private int donGia;
  private int slHienCo;
  private String ghiChu;

  public HangHoaApi() {
    super();
  }

  public HangHoaApi(int idhangHoa, String donViTinh, String tenHang, int donGia, int slhienCo, String ghiChu) {
    super();
    this.idhangHoa = idhangHoa;
    this.donViTinh = donViTinh;
    this.tenHangHoa = tenHang;
    this.donGia = donGia;
    this.slHienCo = slhienCo;
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

  public String getTenHangHoa() {
    return tenHangHoa;
  }

  public void setTenHangHoa(String tenHangHoa) {
    this.tenHangHoa = tenHangHoa;
  }

  public int getSlHienCo() {
    return slHienCo;
  }

  public void setSlHienCo(int slHienCo) {
    this.slHienCo = slHienCo;
  }

}
