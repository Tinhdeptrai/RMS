package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.DonViTinh;
import com.ptit.rms.model.HangHoa;
import com.ptit.rms.model.api.HangHoaApi;
import com.ptit.rms.repository.DonViTinhRepository;
import com.ptit.rms.repository.HangHoaRepository;
import com.ptit.rms.service.HangHoaService;

@Transactional
@Service("HangHoaService")
public class HangHoaServiceImpl implements HangHoaService {

  @Autowired
  private HangHoaRepository hangHoaRepository;

  @Autowired
  private DonViTinhRepository donViTinhRepository;

  @Override
  public List<HangHoa> getHangHoa() {
    return this.hangHoaRepository.getHangHoa();
  }

  @Override
  public List<HangHoaApi> converHangHoa(List<HangHoa> lstHangHoa) {
    List<HangHoaApi> hangHoaApis = new ArrayList<>();
    for (HangHoa hangHoa : lstHangHoa) {
      HangHoaApi hangHoaApi = new HangHoaApi(hangHoa.getIdhangHoa(), hangHoa.getDonViTinh().getTenDonVi(),
          hangHoa.getTenHang(), hangHoa.getDonGia(), hangHoa.getSlhienCo(), hangHoa.getGhiChu());
      hangHoaApis.add(hangHoaApi);
    }
    return hangHoaApis;
  }

  @Override
  public HangHoa findById(int id) {
    return this.hangHoaRepository.findById(id);
  }

  @Override
  public void updateHangHoa(HangHoa hangHoa) {
    this.hangHoaRepository.updateKhachHang(hangHoa);
  }

  @Override
  public List<DonViTinh> getDonViTinh() {
    return this.donViTinhRepository.getDonViTinh();
  }

  @Override
  public DonViTinh findDVTByName(String donViTinh) {
    return this.donViTinhRepository.findDVTByName(donViTinh);
  }

  @Override
  public void updateDVT(DonViTinh obj) {
    this.donViTinhRepository.updateDVT(obj);
  }

  @Override
  public void createDVT(DonViTinh obj) {
    this.donViTinhRepository.createDVT(obj);

  }

  @Override
  public void createHangHoa(HangHoa hangHoa) {
    this.hangHoaRepository.createHangHoa(hangHoa);

  }

  @Override
  public void updateSoLuongHangHoa(List<HangHoa> hangHoa) {
    for (HangHoa hangHoa2 : hangHoa) {
      HangHoa hangHoaObj = this.hangHoaRepository.getHangHoaById(hangHoa2.getIdhangHoa());
      hangHoaObj.setSlhienCo(hangHoaObj.getSlhienCo() - hangHoa2.getSlhienCo());
      this.hangHoaRepository.updateKhachHang(hangHoaObj);
    }

  }

}
