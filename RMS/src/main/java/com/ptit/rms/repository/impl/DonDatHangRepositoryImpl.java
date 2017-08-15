package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.DonDatHang;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.DonDatHangRepository;

@Repository("DonDatHangRepository")
public class DonDatHangRepositoryImpl extends AbstractRepository<Integer, DonDatHang> implements DonDatHangRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<DonDatHang> getDonDatHang() {
    Criteria criteria = createEntityCriteria().addOrder(Order.desc("trangThai")).addOrder(Order.desc("ngayDatHang"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagdelete", false));
    List<DonDatHang> list = (List<DonDatHang>) criteria.list();
    return list;
  }

  @Override
  public int saveDDH(DonDatHang donDatHang) {
    persist(donDatHang);
    flush();
    return donDatHang.getIddonDatHang();
  }

  @Override
  public void updateDDH(DonDatHang donDatHang) {
    update(donDatHang);

  }

  @Override
  public DonDatHang getDonDatHangById(int iddonDatHang) {
    return getByKey(iddonDatHang);
  }

}
