package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.NhanVien;

public interface NhanVienRepository {

  NhanVien findByUsername(String username);

  List<NhanVien> getNhanVien();

  void updateNhanVien(NhanVien nhanVien);

  void saveNhanVien(NhanVien nhanVien);

  NhanVien findById(int parseInt);

}
