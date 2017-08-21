package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.DinhLuong;
import com.ptit.rms.model.MonAn;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.DinhLuongRepository;

@Repository("DinhLuongRepository")
public class DinhLuongRepositoryImpl extends AbstractRepository<Integer, DinhLuong> implements DinhLuongRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<DinhLuong> getDinhLuongByMonAnId(MonAn monAn) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("id.idmonAn"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("monAn", monAn));
    List<DinhLuong> list = (List<DinhLuong>) criteria.list();
    return list;
  }

  @Override
  public void save(DinhLuong dinhLuong) {
    persist(dinhLuong);
  }

}
