package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.CtphieuNhap;
import com.ptit.rms.model.CtphieuNhapId;
import com.ptit.rms.model.HangHoa;
import com.ptit.rms.model.PhieuNhap;
import com.ptit.rms.repository.CTPhieuNhapRepository;
import com.ptit.rms.repository.HangHoaRepository;
import com.ptit.rms.repository.PhieuNhapRepository;
import com.ptit.rms.service.PhieuNhapService;

@Service("PhieuNhapService")
@Transactional
public class PhieuNhapServiceImpl implements PhieuNhapService {

  @Autowired
  private PhieuNhapRepository phieuNhapRepository;

  @Autowired
  private CTPhieuNhapRepository ctPhieuNhapRepository;

  @Autowired
  private HangHoaRepository hangHoaRepository;

  @Override
  public List<PhieuNhap> getPhieuNhap() {
    return this.phieuNhapRepository.getPhieuNhap();
  }

  @Override
  public int savePhieuNhap(PhieuNhap phieuNhap) {
    return this.phieuNhapRepository.savePhieuNhap(phieuNhap);
  }

  @Override
  public void saveCTPhieuNhap(List<CtphieuNhap> listCTDDH) {
    List<HangHoa> hangHoas = new ArrayList<>();
    for (CtphieuNhap ctphieuNhap : listCTDDH) {
      HangHoa hangHoa = this.hangHoaRepository.getHangHoaById(ctphieuNhap.getHangHoa().getIdhangHoa());
      hangHoa.setSlhienCo(ctphieuNhap.getSlNhap() + hangHoa.getSlhienCo());
      hangHoas.add(hangHoa);
      CtphieuNhapId ctphieuNhapId = new CtphieuNhapId(ctphieuNhap.getPhieuNhap().getIdphieuNhap(),
          ctphieuNhap.getHangHoa().getIdhangHoa());
      ctphieuNhap.setId(ctphieuNhapId);
      this.ctPhieuNhapRepository.saveCTPhieuNhap(ctphieuNhap);
    }
    for (HangHoa hangHoa : hangHoas) {
      this.hangHoaRepository.updateKhachHang(hangHoa);
    }
  }

  @Override
  public List<CtphieuNhap> getCTPhieuNhap() {
    return this.ctPhieuNhapRepository.getCTPhieuNhap();
  }

}
