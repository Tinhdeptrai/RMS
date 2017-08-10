package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.NhaCungCap;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.NhaCungCapRepository;

@Repository("NhaCungCapRepository")
public class NhaCungCapRepositoryImpl extends AbstractRepository<Integer, NhaCungCap> implements NhaCungCapRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<NhaCungCap> getNhaCungCap() {
    Criteria criteria = createEntityCriteria().addOrder(Order.desc("idnhaCungCap"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<NhaCungCap> list = (List<NhaCungCap>) criteria.list();
    return list;
  }

  @Override
  public NhaCungCap findById(int id) {
    return getByKey(id);
  }

  @Override
  public void updateNCC(NhaCungCap nhaCungCap) {
    update(nhaCungCap);
  }

  @Override
  public void saveNCC(NhaCungCap nhaCungCap) {
    persist(nhaCungCap);
  }

}
