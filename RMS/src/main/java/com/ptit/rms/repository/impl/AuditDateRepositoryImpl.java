package com.ptit.rms.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.AuditDate;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.AuditDateRepository;

@Repository("AuditDateRepository")
public class AuditDateRepositoryImpl extends AbstractRepository<Integer, AuditDate> implements AuditDateRepository {

  @SuppressWarnings("unchecked")
  public List<AuditDate> findAllAuditDate(int id) {
    Criteria criteria = this.createEntityCriteria().addOrder(Order.desc("auditDateId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("courseId", id));
    return (List<AuditDate>) criteria.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<AuditDate> getListAuditDateByDate(Date dateUpdateAt) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("auditDateId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.ge("date", dateUpdateAt));
    List<AuditDate> list = (List<AuditDate>) criteria.list();
    return list;
  }
}
