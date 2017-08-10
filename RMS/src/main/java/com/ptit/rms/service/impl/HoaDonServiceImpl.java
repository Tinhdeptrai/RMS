package com.ptit.rms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.HoaDon;
import com.ptit.rms.repository.HoaDonRepository;
import com.ptit.rms.service.HoaDonService;

@Service("HoaDonService")
@Transactional
public class HoaDonServiceImpl implements HoaDonService {

  @Autowired
  private HoaDonRepository hoaDon;
  
  @Override
  public List<HoaDon> getHoaDon() {
    return this.hoaDon.getHoaDon();
  }

  @Override
  public void save(HoaDon hoaDon) {
     this.hoaDon.save(hoaDon);
    
  }

}
