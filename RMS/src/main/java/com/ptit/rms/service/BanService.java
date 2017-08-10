package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.Ban;

public interface BanService {

  List<Ban> getBan();

  void update(Ban ban);

}
