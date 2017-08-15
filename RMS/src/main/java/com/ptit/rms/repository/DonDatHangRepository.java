package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.DonDatHang;

public interface DonDatHangRepository {

  List<DonDatHang> getDonDatHang();

  int saveDDH(DonDatHang donDatHang);

  void updateDDH(DonDatHang donDatHang);

  DonDatHang getDonDatHangById(int iddonDatHang);


}
