package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.BangGia;
import com.ptit.rms.model.MonAn;
import com.ptit.rms.model.api.MonAnApi;

public interface MonAnService {

  List<MonAn> getMonAn();

  List<MonAnApi> converMonAn(List<MonAn> lstMonAn);

  int saveMonAn(MonAn ma);

  void saveBangGia(BangGia bangGias);

  void updateMonAn(MonAn ma);

}
