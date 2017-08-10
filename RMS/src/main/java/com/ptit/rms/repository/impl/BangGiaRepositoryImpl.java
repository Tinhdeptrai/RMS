package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.BangGia;
import com.ptit.rms.model.MonAn;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.BanGiaRepository;

@Repository("BanGiaRepository")
public class BangGiaRepositoryImpl extends AbstractRepository<Integer, BangGia> implements BanGiaRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<BangGia> getGiaByMonAnId(MonAn monAn) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("idgia"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("monAn", monAn));
    List<BangGia> list = (List<BangGia>) criteria.list();
    return list;
  }

}
