package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.Ctmenu;

public interface CTMenuRepository {

  List<Ctmenu> getCtMenu();

  void saveCTMunu(Ctmenu ctmenu);

}
