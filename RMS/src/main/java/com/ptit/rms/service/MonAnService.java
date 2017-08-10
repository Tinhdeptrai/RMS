package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.MonAn;
import com.ptit.rms.model.api.MonAnApi;

public interface MonAnService {

  List<MonAn> getMonAn();

  List<MonAnApi> converMonAn(List<MonAn> lstMonAn);

}
