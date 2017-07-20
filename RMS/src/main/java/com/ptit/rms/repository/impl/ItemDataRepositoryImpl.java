package com.ptit.rms.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.ItemData;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.ItemDataRepository;

@Repository("ItemDataRepository")
public class ItemDataRepositoryImpl extends AbstractRepository<Integer, ItemData> implements ItemDataRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<ItemData> getListItemByDate(Date dateUpdateAt) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("itemDataId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.ge("updatedAt", dateUpdateAt));
    List<ItemData> list = (List<ItemData>) criteria.list();
    return list;
  }

}
