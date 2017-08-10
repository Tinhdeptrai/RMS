package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.DonViTinh;

public interface DonViTinhRepository {

  List<DonViTinh> getDonViTinh();

  DonViTinh findDVTByName(String donViTinh);

  void updateDVT(DonViTinh obj);

  void createDVT(DonViTinh obj);

}
