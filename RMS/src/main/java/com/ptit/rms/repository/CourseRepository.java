package com.ptit.rms.repository;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.Courses;
import com.ptit.rms.model.Locations;

public interface CourseRepository {
  List<Courses> findAllCourses();

  Courses findCourseById(int id);

  void updateCourse(Courses course);

  void saveCourse(Courses course);

  List<Locations> findLocationByCourseId(int id);

  List<Courses> getListCourseByDate(Date dateUpdateAt);
}
