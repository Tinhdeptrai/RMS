package com.ptit.rms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.Ban;
import com.ptit.rms.repository.BanRepository;
import com.ptit.rms.service.BanService;

@Service("BanService")
@Transactional
public class BanServiceImpl implements BanService {
  @Autowired

  private BanRepository banRepository;

  @Override
  public List<Ban> getBan() {
    return this.banRepository.getBan();
  }

  @Override
  public void update(Ban ban) {
    this.banRepository.update(ban);
  }

}
