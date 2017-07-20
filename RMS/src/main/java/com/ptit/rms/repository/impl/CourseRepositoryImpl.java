package com.ptit.rms.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Courses;
import com.ptit.rms.model.Locations;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.CourseRepository;

@Repository("CourseRepository")
public class CourseRepositoryImpl extends AbstractRepository<Integer, Courses> implements CourseRepository {
  @SuppressWarnings("unchecked")
  public List<Courses> findAllCourses() {
    Criteria criteria = this.createEntityCriteria().addOrder(Order.desc("courseId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("isDeleted", false));
    return (List<Courses>) criteria.list();
  }

  @Override
  public Courses findCourseById(int id) {
    return getByKey(id);
  }

  @Override
  public void updateCourse(Courses course) {
    update(course);
  }

  @Override
  public void saveCourse(Courses course) {
    persist(course);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Locations> findLocationByCourseId(int id) {
    Criteria criteria = this.createEntityCriteria().addOrder(Order.desc("courseId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("courseId", id));
    criteria.add(Restrictions.eq("isDeleted", false));
    return (List<Locations>) criteria.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Courses> getListCourseByDate(Date dateUpdateAt) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("courseId"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.ge("updatedAt", dateUpdateAt));
    List<Courses> listCourses = (List<Courses>) criteria.list();
    return listCourses;
  }
}
