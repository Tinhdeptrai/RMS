package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.DatBan;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.DatBanRepository;

@Repository("DatBanRepository")
public class DatBanRepositoryImpl extends AbstractRepository<Integer, DatBan> implements DatBanRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<DatBan> getDatBan() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("iddatBan"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<DatBan> list = (List<DatBan>) criteria.list();
    return list;
  }

  @Override
  public void saveDatBan(DatBan datBan) {
    persist(datBan);
  }

}
