package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.DatBan;

public interface DatBanRepository {

  List<DatBan> getDatBan();

  void update(DatBan datBan);

  void saveDatBan(DatBan datBan);

}
