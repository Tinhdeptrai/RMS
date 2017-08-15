package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.Ctddh;

public interface CTDonDatHangRepository {

  List<Ctddh> getCTDonDatHang(int id);

  void saveCTDDH(Ctddh ctddh);

}
