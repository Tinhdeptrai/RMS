package com.ptit.rms.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Locations;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.LocationRepository;

@Repository("LocationsRepository")
public class LocationRepositoryImpl extends AbstractRepository<Integer, Locations> implements LocationRepository {

  @SuppressWarnings("unchecked")
  @Override
  public List<Locations> findLocationByCourseId(int id) {
    Criteria criteria = this.createEntityCriteria().addOrder(Order.desc("locationId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("courses.courseId", id));
    criteria.add(Restrictions.eq("isDeleted", false));
    return (List<Locations>) criteria.list();
  }

  @Override
  public Locations findLocationById(int id) {
    return getByKey(id);
  }

  @Override
  public void updateLocation(Locations location) {
    update(location);
  }

  @Override
  public void saveLocation(Locations location) {
    persist(location);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Locations> getListLocationByDate(Date dateUpdateAt) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("locationId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.ge("updatedAt", dateUpdateAt));
    List<Locations> list = (List<Locations>) criteria.list();
    return list;
  }
}
