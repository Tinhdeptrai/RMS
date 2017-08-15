package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.PhieuNhap;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.PhieuNhapRepository;

@Repository("PhieuNhapRepository")
public class PhieuNhapRepositoryImpl extends AbstractRepository<Integer, PhieuNhap> implements PhieuNhapRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<PhieuNhap> getPhieuNhap() {
    Criteria criteria = createEntityCriteria().addOrder(Order.desc("idphieuNhap"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<PhieuNhap> list = (List<PhieuNhap>) criteria.list();
    return list;
  }

  @Override
  public int savePhieuNhap(PhieuNhap phieuNhap) {
    persist(phieuNhap);
    flush();
    return phieuNhap.getIdphieuNhap();
  }

}
