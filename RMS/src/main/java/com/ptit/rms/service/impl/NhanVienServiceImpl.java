package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.NhanVien;
import com.ptit.rms.model.Quyen;
import com.ptit.rms.model.api.NhanVienApi;
import com.ptit.rms.repository.NhanVienRepository;
import com.ptit.rms.repository.QuyenRepository;
import com.ptit.rms.service.NhanVienService;

@Transactional
@Service("NhanVienService")
public class NhanVienServiceImpl implements NhanVienService {

  @Autowired
  private NhanVienRepository nhanVien;

  @Autowired
  private QuyenRepository quyen;;

  @Override
  public NhanVien findByUsername(String username) {
    return this.nhanVien.findByUsername(username);
  }

  @Override
  public List<NhanVien> getNhanVien() {
    return this.nhanVien.getNhanVien();
  }

  @Override
  public List<NhanVienApi> converNhanVien(List<NhanVien> lstNhanVien) {
    List<NhanVienApi> nhanVienApis = new ArrayList<>();
    for (NhanVien nhanVien : lstNhanVien) {
      NhanVienApi api = new NhanVienApi(nhanVien.getIdnhanVien(), nhanVien.getTaiKhoan(), nhanVien.getMatKhau(),
          nhanVien.getHo(), nhanVien.getTen(), nhanVien.getDiaChi(), nhanVien.getSdt(),
          nhanVien.getQuyen().getTenQuyen());
      nhanVienApis.add(api);

    }
    return nhanVienApis;
  }

  @Override
  public void updateNhanVien(NhanVien nhanVien) {
    this.nhanVien.updateNhanVien(nhanVien);
    
  }

  @Override
  public Quyen getQuyenByName(String quyen) {
    return this.quyen.getQuyenByName(quyen);
  }

  @Override
  public void saveNhanVien(NhanVien nhanVien) {
    this.nhanVien.saveNhanVien(nhanVien);
    
  }

  @Override
  public NhanVien findById(int parseInt) {
    return this.nhanVien.findById(parseInt);
  }

}
