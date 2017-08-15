package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.PhieuNhap;

public interface PhieuNhapRepository {

  List<PhieuNhap> getPhieuNhap();

  int savePhieuNhap(PhieuNhap phieuNhap);

}
