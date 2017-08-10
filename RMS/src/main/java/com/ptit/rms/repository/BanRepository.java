package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.Ban;

public interface BanRepository {

  List<Ban> getBan();

  void update(Ban ban);

}
