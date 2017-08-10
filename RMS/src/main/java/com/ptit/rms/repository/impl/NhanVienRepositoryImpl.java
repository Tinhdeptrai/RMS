package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.NhanVien;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.NhanVienRepository;

@Repository("NhanVienRepository")
public class NhanVienRepositoryImpl extends AbstractRepository<Integer, NhanVien> implements NhanVienRepository {

  @Override
  public NhanVien findByUsername(String username) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("taiKhoan", username));
    crit.add(Restrictions.eq("flagDelete", false));
    NhanVien nhanVien = (NhanVien) crit.uniqueResult();
    if (nhanVien != null) {
      Hibernate.initialize(nhanVien.getQuyen());
    }
    return nhanVien;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<NhanVien> getNhanVien() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("idnhanVien"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("flagDelete", false));
    List<NhanVien> list = (List<NhanVien>) criteria.list();
    return list;
  }

  @Override
  public void updateNhanVien(NhanVien nhanVien) {
    update(nhanVien);
  }

  @Override
  public void saveNhanVien(NhanVien nhanVien) {
    persist(nhanVien);

  }

  @Override
  public NhanVien findById(int parseInt) {
    return getByKey(parseInt);
  }

}
