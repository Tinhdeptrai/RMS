package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.BangGia;
import com.ptit.rms.model.DinhLuong;
import com.ptit.rms.model.MonAn;
import com.ptit.rms.model.api.MonAnApi;
import com.ptit.rms.repository.BanGiaRepository;
import com.ptit.rms.repository.DinhLuongRepository;
import com.ptit.rms.repository.MonAnRepository;
import com.ptit.rms.service.MonAnService;

@Transactional
@Service("MonAnService")
public class MonAnServiceImpl implements MonAnService {
  @Autowired
  private MonAnRepository monAn;

  @Autowired
  private BanGiaRepository banGia;

  @Autowired
  private DinhLuongRepository dinhLuong;

  @Override
  public List<MonAn> getMonAn() {
    return this.monAn.getMonAn();
  }

  @Override
  public List<MonAnApi> converMonAn(List<MonAn> lstMonAn) {
    List<MonAnApi> monAnAPIs = new ArrayList<>();
    for (MonAn monAn : lstMonAn) {
      MonAnApi api = new MonAnApi(monAn.getIdmonAn(), monAn.getDanhMuc(), monAn.getDonViTinh(), monAn.getTenMon(),
          monAn.getAnh(), monAn.getGhiChu(), monAn.isFlagDelete());
      List<BangGia> bangGias = this.banGia.getGiaByMonAnId(monAn);
      if (bangGias != null)
        api.setBangGia(bangGias);
      List<DinhLuong> dinhLuongs = this.dinhLuong.getDinhLuongByMonAnId(monAn);
      if (dinhLuongs != null && dinhLuongs.size() != 0)
        api.setDinhLuong(dinhLuongs);
      monAnAPIs.add(api);
    }

    return monAnAPIs;
  }

  @Override
  public int saveMonAn(MonAn ma) {
    return this.monAn.saveMonAn(ma);

  }

  @Override
  public void saveBangGia(BangGia bangGias) {
    bangGias.setNgayApDung(new Date());
    this.banGia.save(bangGias);
  }

  @Override
  public void updateMonAn(MonAn ma) {
    this.monAn.update(ma);
  }

}
