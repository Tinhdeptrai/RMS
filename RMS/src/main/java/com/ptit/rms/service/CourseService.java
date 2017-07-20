package com.ptit.rms.service;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.AuditDate;
import com.ptit.rms.model.Courses;
import com.ptit.rms.model.Locations;
import com.ptit.rms.model.api.CoursesAPI;

public interface CourseService {

  Courses findCourseById(int id);

  List<Courses> findAllCourses();

  List<AuditDate> findAllAuditDate(int id);

  void updateCourse(Courses course);

  void saveCourse(Courses course);

  List<Locations> findLocationByCourseId(int id);

  List<Courses> getListCourseByDate(Date dateUpdateAt);

  List<CoursesAPI> convertCourseToJson(List<Courses> list);
}
