package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.KhachHang;
import com.ptit.rms.model.TheUuDai;
import com.ptit.rms.model.api.KhachHangApi;
import com.ptit.rms.repository.KhachHangRepository;
import com.ptit.rms.repository.TheUuDaiRepository;
import com.ptit.rms.service.KhachHangService;

@Transactional
@Service("KhachHangService")
public class KhachHangServiceImpl implements KhachHangService {

  @Autowired
  private KhachHangRepository khachhang;
  
  @Autowired
  private TheUuDaiRepository uudai;

  @Override
  public List<KhachHang> getKhachHang() {
    return this.khachhang.getKhachHang();
  }

  @Override
  public List<KhachHangApi> converKhachHang(List<KhachHang> lstKhachHang) {
    List<KhachHangApi> khachHangApis = new ArrayList<>();
    for (KhachHang khachHang : lstKhachHang) {
      KhachHangApi khachHangApi = new KhachHangApi(khachHang.getIdkhachHang(), khachHang.getTenKhachHang(),
          khachHang.getTheUuDai().getTenThe(), khachHang.getDiaChi(), khachHang.getSdt(), khachHang.getEmail(),
          khachHang.getDiemThuong().toString(), khachHang.getGhiChu(), khachHang.getTheUuDai().getChietKhau());
      khachHangApis.add(khachHangApi);
    }
    return khachHangApis;
  }

  @Override
  public KhachHang findById(int id) {
    return  this.khachhang.findById(id);
  }

  @Override
  public void updateKhachHang(KhachHang khachHang) {
   this.khachhang.updateKhachHang(khachHang);
    
  }

  @Override
  public TheUuDai getTheUuDaiByName(String theUuDai) {
    return this.uudai.getTheUuDaiByName(theUuDai);
  }

  @Override
  public void saveKhachHang(KhachHang khachHang) {
    this.khachhang.saveKhachHang(khachHang);
    
  }

}
