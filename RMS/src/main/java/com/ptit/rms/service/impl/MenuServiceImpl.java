package com.ptit.rms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.rms.model.Menu;
import com.ptit.rms.repository.MenuRepository;
import com.ptit.rms.service.MenuService;

@Service("MenuService")
@Transactional
public class MenuServiceImpl implements MenuService {

  @Autowired
  private MenuRepository menuRepository;

  @Override
  public List<Menu> getMenu() {
    return this.menuRepository.getMenu();
  }

}
