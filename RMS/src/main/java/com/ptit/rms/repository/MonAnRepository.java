package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.MonAn;

public interface MonAnRepository {

  List<MonAn> getMonAn();

  int saveMonAn(MonAn ma);

  void update(MonAn ma);

}
