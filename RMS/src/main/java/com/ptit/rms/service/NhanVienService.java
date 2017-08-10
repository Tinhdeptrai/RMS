package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.NhanVien;
import com.ptit.rms.model.Quyen;
import com.ptit.rms.model.api.NhanVienApi;

public interface NhanVienService {

  NhanVien findByUsername(String username);

  List<NhanVien> getNhanVien();

  List<NhanVienApi> converNhanVien(List<NhanVien> lstNhanVien);

  void updateNhanVien(NhanVien nhanVien);

  Quyen getQuyenByName(String quyen);

  void saveNhanVien(NhanVien nhanVien);

  NhanVien findById(int parseInt);

}
