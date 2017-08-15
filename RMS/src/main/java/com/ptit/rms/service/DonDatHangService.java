package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.Ctddh;
import com.ptit.rms.model.DonDatHang;

public interface DonDatHangService {

  List<DonDatHang> getDonDatHang();

  List<Ctddh> getCTDonDatHang(int id);

  int saveDDH(DonDatHang donDatHang);

  void saveCTDDH(List<Ctddh> listCTDDH);

  void updateDDH(DonDatHang donDatHang);

  DonDatHang getDonDatHangById(int iddonDatHang);

  
}
