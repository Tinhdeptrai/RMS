package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Ctddh;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.CTDonDatHangRepository;

@Repository("CTDonDatHangRepository")
public class CTDonDatHangRepositoryImpl extends AbstractRepository<Integer, Ctddh> implements CTDonDatHangRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<Ctddh> getCTDonDatHang(int id) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("id.idhangHoa"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("donDatHang.iddonDatHang", id));
    List<Ctddh> list = (List<Ctddh>) criteria.list();
    return list;
  }

  @Override
  public void saveCTDDH(Ctddh ctddh) {
    persist(ctddh);
  }

}
