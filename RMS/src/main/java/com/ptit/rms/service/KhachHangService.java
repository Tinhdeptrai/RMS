package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.KhachHang;
import com.ptit.rms.model.TheUuDai;
import com.ptit.rms.model.api.KhachHangApi;

public interface KhachHangService {

  List<KhachHang> getKhachHang();

  List<KhachHangApi> converKhachHang(List<KhachHang> lstKhachHang);

  KhachHang findById(int id);

  void updateKhachHang(KhachHang khachHang);

  TheUuDai getTheUuDaiByName(String theUuDai);

  void saveKhachHang(KhachHang khachHang);

}
