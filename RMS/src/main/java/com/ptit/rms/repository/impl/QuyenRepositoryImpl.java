package com.ptit.rms.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Quyen;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.QuyenRepository;

@Repository("QuyenRepository")
public class QuyenRepositoryImpl extends AbstractRepository<Integer, Quyen> implements QuyenRepository {

  @Override
  public Quyen getQuyenByName(String quyen) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("tenQuyen", quyen));
    Quyen quyenNv = (Quyen) crit.uniqueResult();
    return quyenNv;
  }

}
