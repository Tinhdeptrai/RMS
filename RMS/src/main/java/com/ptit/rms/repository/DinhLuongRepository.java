package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.DinhLuong;
import com.ptit.rms.model.MonAn;

public interface DinhLuongRepository {

  List<DinhLuong> getDinhLuongByMonAnId(MonAn monAn);

}
