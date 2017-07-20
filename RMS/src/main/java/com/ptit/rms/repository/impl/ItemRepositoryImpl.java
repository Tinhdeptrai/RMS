package com.ptit.rms.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Items;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.ItemRepository;

@Repository("ItemRepository")
public class ItemRepositoryImpl extends AbstractRepository<Integer, Items> implements ItemRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<Items> getListItemByDate(Date dateUpdateAt) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("itemId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.ge("updatedAt", dateUpdateAt));
    List<Items> list = (List<Items>) criteria.list();
    return list;
  }

}
