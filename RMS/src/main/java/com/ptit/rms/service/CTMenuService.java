package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.Ctmenu;
import com.ptit.rms.model.Menu;

public interface CTMenuService {

  List<Ctmenu> getCtMenu();

  void saveCTMenu(List<Ctmenu> lstCTMenu);

  void saveMenu(Menu menu);

  Menu getMenuByName(String tenMenu);

}
