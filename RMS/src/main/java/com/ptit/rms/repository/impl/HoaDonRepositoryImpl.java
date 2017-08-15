package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.HoaDon;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.HoaDonRepository;

@Repository("HoaDonRepository")
public class HoaDonRepositoryImpl extends AbstractRepository<Integer, HoaDon> implements HoaDonRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<HoaDon> getHoaDon() {
    Criteria criteria = createEntityCriteria().addOrder(Order.desc("trangThai")).addOrder(Order.desc("ngayLapHd"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<HoaDon> list = (List<HoaDon>) criteria.list();
    return list;
  }

  @Override
  public void save(HoaDon hoaDon) {
    persist(hoaDon);
  }

}
