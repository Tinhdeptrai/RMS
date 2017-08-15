package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.DonViTinh;
import com.ptit.rms.model.HangHoa;
import com.ptit.rms.model.api.HangHoaApi;

public interface HangHoaService {

  List<HangHoa> getHangHoa();

  List<HangHoaApi> converHangHoa(List<HangHoa> lstHangHoa);

  HangHoa findById(int id);

  void updateHangHoa(HangHoa hangHoa);

  List<DonViTinh> getDonViTinh();

  DonViTinh findDVTByName(String donViTinh);

  void updateDVT(DonViTinh obj);

  void createDVT(DonViTinh obj);

  void createHangHoa(HangHoa hangHoa);

  void updateSoLuongHangHoa(List<HangHoa> hangHoa);

}
