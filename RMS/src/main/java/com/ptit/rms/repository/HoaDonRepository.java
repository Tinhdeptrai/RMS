package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.HoaDon;

public interface HoaDonRepository {

  List<HoaDon> getHoaDon();

  void save(HoaDon hoaDon);

  void update(HoaDon hoaDon);

}
