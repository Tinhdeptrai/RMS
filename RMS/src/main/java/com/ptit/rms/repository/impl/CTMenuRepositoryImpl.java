package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Ctmenu;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.CTMenuRepository;

@Repository("CTMenuRepository")
public class CTMenuRepositoryImpl extends AbstractRepository<Integer, Ctmenu> implements CTMenuRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<Ctmenu> getCtMenu() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<Ctmenu> list = (List<Ctmenu>) criteria.list();
    return list;
  }

  @Override
  public void saveCTMunu(Ctmenu ctmenu) {
    persist(ctmenu);
  }

}
