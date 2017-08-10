package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.NhaCungCap;
import com.ptit.rms.model.api.NhaCungCapApi;

public interface NhaCungCapService {

  List<NhaCungCap> getNhaCungCap();

  List<NhaCungCapApi> converNhaCungCap(List<NhaCungCap> lstNhaCungCap);

  NhaCungCap findById(int id);

  void updateNCC(NhaCungCap nhaCungCap);

  void saveNCC(NhaCungCap nhaCungCap);

}
