package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.NhaCungCap;
import com.ptit.rms.model.api.NhaCungCapApi;
import com.ptit.rms.repository.NhaCungCapRepository;
import com.ptit.rms.service.NhaCungCapService;

@Transactional
@Service("NhaCungCapService")
public class NhaCungCapServiceImpl implements NhaCungCapService {
  @Autowired
  private NhaCungCapRepository nhaCungCapRepository;

  @Override
  public List<NhaCungCap> getNhaCungCap() {
    return this.nhaCungCapRepository.getNhaCungCap();
  }

  @Override
  public List<NhaCungCapApi> converNhaCungCap(List<NhaCungCap> lstNhaCungCap) {
    List<NhaCungCapApi> cungCapApis = new ArrayList<>();
    for (NhaCungCap nhaCungCap : lstNhaCungCap) {
      NhaCungCapApi api = new NhaCungCapApi(nhaCungCap.getIdnhaCungCap(), nhaCungCap.getTenNcc(),
          nhaCungCap.getDiaChi(), nhaCungCap.getSdt(), nhaCungCap.getEmail(), nhaCungCap.isFlagDelete());
      api.setNgayBd(nhaCungCap.getNgayBd());
      api.setNgayKt(nhaCungCap.getNgayKt());
      cungCapApis.add(api);
    }
    return cungCapApis;
  }

  @Override
  public NhaCungCap findById(int id) {
    return this.nhaCungCapRepository.findById(id);
  }

  @Override
  public void updateNCC(NhaCungCap nhaCungCap) {
    this.nhaCungCapRepository.updateNCC(nhaCungCap);
  }

  @Override
  public void saveNCC(NhaCungCap nhaCungCap) {
    this.nhaCungCapRepository.saveNCC(nhaCungCap);
    
  }

}
