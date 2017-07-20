package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.AuditDate;
import com.ptit.rms.model.Courses;
import com.ptit.rms.model.Locations;
import com.ptit.rms.model.api.CoursesAPI;
import com.ptit.rms.repository.AuditDateRepository;
import com.ptit.rms.repository.CourseRepository;
import com.ptit.rms.service.CourseService;

@Service("CourseServiceImpl")
@Transactional
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private AuditDateRepository auditDateRepository;

  public List<Courses> findAllCourses() {
    return this.courseRepository.findAllCourses();
  }

  public List<AuditDate> findAllAuditDate(int id) {
    return this.auditDateRepository.findAllAuditDate(id);
  }

  @Override
  public Courses findCourseById(int id) {
    return this.courseRepository.findCourseById(id);
  }

  @Override
  public void updateCourse(Courses course) {
    this.courseRepository.updateCourse(course);
  }

  @Override
  public void saveCourse(Courses course) {
    this.courseRepository.saveCourse(course);
  }

  @Override
  public List<Locations> findLocationByCourseId(int id) {
    return this.courseRepository.findLocationByCourseId(id);
  }

  @Override
  public List<Courses> getListCourseByDate(Date dateUpdateAt) {
    return this.courseRepository.getListCourseByDate(dateUpdateAt);
  }

  @Override
  public List<CoursesAPI> convertCourseToJson(List<Courses> list) {
    List<CoursesAPI> listcourseAPI = new ArrayList<>();
    for (Courses courses : list) {
      CoursesAPI courseApi = new CoursesAPI();
      courseApi.setCourseId(courses.getCourseId());
      courseApi.setCourseName(courses.getCourseName());
      courseApi.setCreatedAt(courses.getCreatedAt());
      courseApi.setUpdatedAt(courses.getUpdatedAt());
      courseApi.setCreatedBy(courses.getUsersByCreatedBy().getId());
      courseApi.setUpdatedBy(courses.getUsersByUpdatedBy().getId());
      courseApi.setCourseOrder(courses.getCourseOrder());
      courseApi.setDeletedTime(courses.getDeletedTime());
      listcourseAPI.add(courseApi);
    }
    return listcourseAPI;
  }
}
