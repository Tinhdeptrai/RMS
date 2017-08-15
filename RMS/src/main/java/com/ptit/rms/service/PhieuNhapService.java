package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.CtphieuNhap;
import com.ptit.rms.model.PhieuNhap;

public interface PhieuNhapService {

  List<PhieuNhap> getPhieuNhap();

  int savePhieuNhap(PhieuNhap phieuNhap);

  void saveCTPhieuNhap(List<CtphieuNhap> listCTDDH);

  List<CtphieuNhap> getCTPhieuNhap();

}
