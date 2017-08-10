package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.NhaCungCap;

public interface NhaCungCapRepository {

  List<NhaCungCap> getNhaCungCap();

  NhaCungCap findById(int id);

  void updateNCC(NhaCungCap nhaCungCap);

  void saveNCC(NhaCungCap nhaCungCap);

}
