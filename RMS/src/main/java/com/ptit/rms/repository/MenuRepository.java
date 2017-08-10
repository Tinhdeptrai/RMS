package com.ptit.rms.repository;

import java.util.List;

import com.ptit.rms.model.Menu;

public interface MenuRepository {

  List<Menu> getMenu();

  void saveMenu(Menu menu);

  Menu getMenuByName(String tenMenu);

}
