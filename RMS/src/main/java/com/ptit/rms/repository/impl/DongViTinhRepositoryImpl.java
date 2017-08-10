package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.DonViTinh;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.DonViTinhRepository;

@Repository("DonViTinhRepository")
public class DongViTinhRepositoryImpl extends AbstractRepository<Integer, DonViTinh> implements DonViTinhRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<DonViTinh> getDonViTinh() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("tenDonVi"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<DonViTinh> list = (List<DonViTinh>) criteria.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public DonViTinh findDVTByName(String donViTinh) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("tenDonVi"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("tenDonVi", donViTinh));
    List<DonViTinh> list = (List<DonViTinh>) criteria.list();
    for (DonViTinh donViTinh2 : list) {
      return donViTinh2;
    }
    return null;
  }

  @Override
  public void updateDVT(DonViTinh obj) {
    update(obj);
  }

  @Override
  public void createDVT(DonViTinh obj) {
    persist(obj);
  }
}
