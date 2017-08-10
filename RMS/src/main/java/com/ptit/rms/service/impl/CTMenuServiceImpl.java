package com.ptit.rms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.Ctmenu;
import com.ptit.rms.model.CtmenuId;
import com.ptit.rms.model.Menu;
import com.ptit.rms.repository.CTMenuRepository;
import com.ptit.rms.repository.MenuRepository;
import com.ptit.rms.service.CTMenuService;

@Service("CTMenuService")
@Transactional
public class CTMenuServiceImpl implements CTMenuService {
  @Autowired
  private CTMenuRepository ctMenu;

  @Autowired
  private MenuRepository menuRepository;

  @Override
  public List<Ctmenu> getCtMenu() {
    return this.ctMenu.getCtMenu();
  }

  @Override
  public void saveCTMenu(List<Ctmenu> lstCTMenu) {
    for (Ctmenu ctmenu : lstCTMenu) {
      CtmenuId ctmenuId =  new CtmenuId(ctmenu.getMenu().getIdmenu(), ctmenu.getMonAn().getIdmonAn());
      ctmenu.setId(ctmenuId);
     // this.menuRepository.saveMenu(ctmenu.getMenu());
      this.ctMenu.saveCTMunu(ctmenu);
    }

  }

  @Override
  public void saveMenu(Menu menu) {
    this.menuRepository.saveMenu(menu);
  }

  @Override
  public Menu getMenuByName(String tenMenu) {
     return this.menuRepository.getMenuByName(tenMenu);
  }

}
