package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.HangHoa;

public interface HangHoaRepository {

  List<HangHoa> getHangHoa();

  HangHoa findById(int id);

  void updateKhachHang(HangHoa hangHoa);

  void createHangHoa(HangHoa hangHoa);

}
