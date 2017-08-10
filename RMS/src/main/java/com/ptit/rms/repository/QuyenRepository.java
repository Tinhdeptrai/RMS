package com.ptit.rms.repository;

import com.ptit.rms.model.Quyen;

public interface QuyenRepository {

  Quyen getQuyenByName(String quyen);

}
