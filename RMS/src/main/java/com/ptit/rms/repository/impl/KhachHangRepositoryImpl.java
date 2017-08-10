package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.KhachHang;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.KhachHangRepository;

@Repository("KhachHangRepository")
public class KhachHangRepositoryImpl extends AbstractRepository<Integer, KhachHang> implements KhachHangRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<KhachHang> getKhachHang() {
    Criteria criteria = createEntityCriteria().addOrder(Order.desc("idkhachHang"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<KhachHang> list = (List<KhachHang>) criteria.list();
    return list;
  }

  @Override
  public KhachHang findById(int id) { 
    return getByKey(id);
  }

  @Override
  public void updateKhachHang(KhachHang khachHang) {
    update(khachHang);
  }

  @Override
  public void saveKhachHang(KhachHang khachHang) {
    persist(khachHang);

  }

}
