package com.ptit.rms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.Ctddh;
import com.ptit.rms.model.CtddhId;
import com.ptit.rms.model.DonDatHang;
import com.ptit.rms.repository.CTDonDatHangRepository;
import com.ptit.rms.repository.DonDatHangRepository;
import com.ptit.rms.service.DonDatHangService;

@Service("DonDatHangService")
@Transactional
public class DonDatHangServiceImpl implements DonDatHangService {

  @Autowired
  private DonDatHangRepository donDatHangRepository;

  @Autowired
  private CTDonDatHangRepository ctDonDatHang;

  @Override
  public List<DonDatHang> getDonDatHang() {
    return this.donDatHangRepository.getDonDatHang();
  }

  @Override
  public List<Ctddh> getCTDonDatHang(int id) {
    return this.ctDonDatHang.getCTDonDatHang(id);
  }

  @Override
  public int saveDDH(DonDatHang donDatHang) {
    return this.donDatHangRepository.saveDDH(donDatHang);
  }

  @Override
  public void saveCTDDH(List<Ctddh> listCTDDH) {
    for (Ctddh ctddh : listCTDDH) {
      CtddhId ctddhId = new CtddhId(ctddh.getDonDatHang().getIddonDatHang(), ctddh.getHangHoa().getIdhangHoa());
      ctddh.setId(ctddhId);
      this.ctDonDatHang.saveCTDDH(ctddh);
    }

  }

  @Override
  public void updateDDH(DonDatHang donDatHang) {
   this.donDatHangRepository.updateDDH(donDatHang);
    
  }

  @Override
  public DonDatHang getDonDatHangById(int iddonDatHang) {
    return donDatHangRepository.getDonDatHangById(iddonDatHang);
  }

}
