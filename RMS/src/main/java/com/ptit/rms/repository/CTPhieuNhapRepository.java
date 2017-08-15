package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.CtphieuNhap;

public interface CTPhieuNhapRepository {

  void saveCTPhieuNhap(CtphieuNhap ctphieuNhap);

  List<CtphieuNhap> getCTPhieuNhap();

}
