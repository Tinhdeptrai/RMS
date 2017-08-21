package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.BangGia;
import com.ptit.rms.model.MonAn;

public interface BanGiaRepository {

  List<BangGia> getGiaByMonAnId(MonAn monAn);

  void save(BangGia bangGia);

}
