package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.HangHoa;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.HangHoaRepository;

@Repository("HangHoaRepository")
public class HangHoaRepositoryImpl extends AbstractRepository<Integer, HangHoa> implements HangHoaRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<HangHoa> getHangHoa() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("idhangHoa"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<HangHoa> list = (List<HangHoa>) criteria.list();
    return list;
  }

  @Override
  public HangHoa findById(int id) {
    return getByKey(id);
  }

  @Override
  public void updateKhachHang(HangHoa hangHoa) {
    update(hangHoa);
  }

  @Override
  public void createHangHoa(HangHoa hangHoa) {
    persist(hangHoa);

  }

}
