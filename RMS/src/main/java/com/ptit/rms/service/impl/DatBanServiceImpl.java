package com.ptit.rms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.DatBan;
import com.ptit.rms.repository.DatBanRepository;
import com.ptit.rms.service.DatBanService;

@Service("DatBanService")
@Transactional
public class DatBanServiceImpl implements DatBanService{

  @Autowired
  private DatBanRepository datBanRepository;
  
  @Override
  public List<DatBan> getDatBan() {
    return this.datBanRepository.getDatBan();
  }

  @Override
  public void update(DatBan datBan) {
    this.datBanRepository.update(datBan);
    
  }

  @Override
  public void saveDatBan(DatBan datBan) {
   this.datBanRepository.saveDatBan(datBan);
    
  }

}
