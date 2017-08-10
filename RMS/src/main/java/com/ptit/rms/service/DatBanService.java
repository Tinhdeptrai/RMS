package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.DatBan;

public interface DatBanService {

  List<DatBan> getDatBan();

  void update(DatBan datBan);

  void saveDatBan(DatBan datBan);

}
