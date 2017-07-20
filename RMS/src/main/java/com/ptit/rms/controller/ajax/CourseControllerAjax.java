package com.ptit.rms.controller.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.controller.BaseController;
import com.ptit.rms.model.Courses;
import com.ptit.rms.model.User;
import com.ptit.rms.service.CourseService;
import com.ptit.rms.service.UserService;
import com.ptit.rms.ultil.Constants;

@RestController
@RequestMapping("/course")
public class CourseControllerAjax extends BaseController {

  @Autowired
  UserService userService;

  @Autowired
  CourseService courseService;

  @RequestMapping(value = { "/check-coursename" }, method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public boolean checkUsername(@RequestBody String str) {
    JSONObject jsonObject = new JSONObject(str);
    String id = jsonObject.getString(Constants.COURSE_ID);
    Courses course = this.courseService.findCourseById(Integer.parseInt(id));
    if (course == null) {
      return true;
    }
    return false;
  }

  @RequestMapping(value = { "/update-course" }, method = RequestMethod.POST, produces = "application/json")
  public String updateUser(@RequestBody String str) {
    User currentUser = this.userService.findByUsername(getPrincipal());

    List<Courses> listCourseSave = new ArrayList<>();
    List<Courses> listCourseEdit = new ArrayList<>();

    JSONArray jsonarray = new JSONArray(str);
    for (int i = 0; i < jsonarray.length(); i++) {

      JSONObject jsonobject = jsonarray.getJSONObject(i);

      String type = jsonobject.getString(Constants.TYPE);
      String id = jsonobject.getString(Constants.COURSE_ID) != null ? jsonobject.getString(Constants.COURSE_ID) : "";
      if (type.equals(Constants.TYPE_DELETE)) {
        Courses course = null;
        if (!id.equals("")) {
          course = this.courseService.findCourseById(Integer.parseInt(id));
        }
        if (course != null) {
          course.setIsDeleted(true);
          course.setUpdatedAt(new Date());
          course.setUsersByUpdatedBy(currentUser);
        }
        this.courseService.updateCourse(course);
      } else {
        String courseName = jsonobject.getString(Constants.COURSE_NAME) != null
            ? jsonobject.getString(Constants.COURSE_NAME) : "";
        if (type.equals(Constants.TYPE_EDIT)) {
          Courses course = null;
          if (!id.equals("")) {
            course = this.courseService.findCourseById(Integer.parseInt(id));
          }
          if (course != null) {
            course.setUpdatedAt(new Date());
            course.setUsersByUpdatedBy(currentUser);
            if (!courseName.equals("")) {
              course.setCourseName(courseName);
            }
            listCourseEdit.add(course);
          }
        }
        if (type.equals(Constants.TYPE_SAVE)) {
          Courses course = new Courses();
          course.setCourseName(courseName);

          course.setIsDeleted(false);
          course.setCreatedAt(new Date());
          course.setUpdatedAt(new Date());
          course.setUsersByCreatedBy(currentUser);
          course.setUsersByUpdatedBy(currentUser);
          listCourseSave.add(course);
        }
      }
    }
    if (listCourseEdit.isEmpty()) {
      for (Courses course : listCourseEdit) {
        this.courseService.updateCourse(course);
      }
    }
    if (listCourseSave.isEmpty()) {
      for (Courses course : listCourseSave) {
        this.courseService.saveCourse(course);
      }
    }
    return "redirect:/list";
  }

}
