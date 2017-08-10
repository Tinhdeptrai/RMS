package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Ban;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.BanRepository;

@Repository("BanRepository")
public class BanRepositoryImpl extends AbstractRepository<Integer, Ban> implements BanRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<Ban> getBan() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("idban"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<Ban> list = (List<Ban>) criteria.list();
    return list;
  }

}
