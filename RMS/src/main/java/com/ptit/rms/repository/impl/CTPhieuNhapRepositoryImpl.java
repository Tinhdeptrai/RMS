package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.CtphieuNhap;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.CTPhieuNhapRepository;

@Repository("CTPhieuNhapRepository")
public class CTPhieuNhapRepositoryImpl extends AbstractRepository<Integer, CtphieuNhap>
    implements CTPhieuNhapRepository {

  @Override
  public void saveCTPhieuNhap(CtphieuNhap ctphieuNhap) {
    persist(ctphieuNhap);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<CtphieuNhap> getCTPhieuNhap() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("id.idhangHoa"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<CtphieuNhap> list = (List<CtphieuNhap>) criteria.list();
    return list;
  }

}
