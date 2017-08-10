package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.HoaDon;

public interface HoaDonService {

  List<HoaDon> getHoaDon();

  void save(HoaDon hoaDon);

}
