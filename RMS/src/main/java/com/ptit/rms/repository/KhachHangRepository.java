package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.KhachHang;

public interface KhachHangRepository {

  List<KhachHang> getKhachHang();

  KhachHang findById(int id);

  void updateKhachHang(KhachHang khachHang);

  void saveKhachHang(KhachHang khachHang);

}
