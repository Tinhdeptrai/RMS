package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Menu;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.MenuRepository;

@Repository("MenuRepository")
public class MenuRepositoryImpl extends AbstractRepository<Integer, Menu> implements MenuRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<Menu> getMenu() {
    Criteria criteria = createEntityCriteria().addOrder(Order.desc("idmenu"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<Menu> list = (List<Menu>) criteria.list();
    return list;
  }

  @Override
  public void saveMenu(Menu menu) {
    persist(menu);
    
  }

  @Override
  public Menu getMenuByName(String tenMenu) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("tenMenu", tenMenu));
    Menu menu = (Menu) crit.uniqueResult();
    return menu;
  }

}
