package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.MonAn;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.MonAnRepository;

@Repository("MonAnRepository")
public class MonAnRepositoryImpl extends AbstractRepository<Integer, MonAn> implements MonAnRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<MonAn> getMonAn() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("tenMon"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<MonAn> list = (List<MonAn>) criteria.list();
    return list;
  }

}
