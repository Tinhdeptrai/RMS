package com.ptit.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.rms.model.AuditDate;
import com.ptit.rms.model.Breadcrumb;
import com.ptit.rms.model.Courses;
import com.ptit.rms.model.Locations;
import com.ptit.rms.service.BreadcrumbsBuilderService;
import com.ptit.rms.service.CourseService;
import com.ptit.rms.service.LocationService;

@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {

  @Autowired
  CourseService courseService;

  @Autowired
  BreadcrumbsBuilderService breadcrumbBuilderService;

  @Autowired
  LocationService locationService;

  /**
   * This method will list all existing courses.
   */
  @RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
  public String list(ModelMap model) {
    List<Courses> courses = this.courseService.findAllCourses();
    model.addAttribute("courses", courses);
    model.addAttribute("loggedinuser", this.getPrincipal());
    model.addAttribute("breadcrumbs",
        this.breadcrumbBuilderService.getStaticBreadcrumb(new Breadcrumb("#", "コース名", "-")));
    return "courses";
  }

  @RequestMapping(value = { "/{id}/date" }, method = RequestMethod.GET)
  public String dateList(@PathVariable int id, ModelMap model) {
    List<AuditDate> auditDates = this.courseService.findAllAuditDate(id);
    List<Courses> courses = this.courseService.findAllCourses();
    model.addAttribute("courses", courses);
    model.addAttribute("currentCourse", id);
    model.addAttribute("auditDates", auditDates);
    model.addAttribute("loggedinuser", this.getPrincipal());
    model.addAttribute("breadcrumbs",
        this.breadcrumbBuilderService.getStaticBreadcrumb(new Breadcrumb("#", "コース名", "-")));
    return "auditDates";
  }

  @RequestMapping(value = { "/view-list-cosese" }, method = RequestMethod.GET)
  public String listCourseEdit(ModelMap model) {
    List<Courses> courses = this.courseService.findAllCourses();
    model.addAttribute("courses", courses);
    model.addAttribute("loggedinuser", this.getPrincipal());
    model.addAttribute("breadcrumbs",
        this.breadcrumbBuilderService.getStaticBreadcrumb(new Breadcrumb("#", "コース名", "-")));
    return "listCourseEdit";
  }

  @RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
  public String editCourse(ModelMap model) {
    List<Courses> courses = this.courseService.findAllCourses();
    model.addAttribute("courses", courses);
    model.addAttribute("loggedinuser", this.getPrincipal());
    model.addAttribute("breadcrumbs",
        this.breadcrumbBuilderService.getStaticBreadcrumb(new Breadcrumb("#", "コース名", "-")));
    return "editCourse";
  }

  @RequestMapping(value = { "/{id}/location" }, method = RequestMethod.GET)
  public String locationList(@PathVariable int id, ModelMap model) {
    List<Courses> courses = this.courseService.findAllCourses();
    List<Locations> locations = this.locationService.findLocationByCourseId(id);
    model.addAttribute("courses", courses);
    model.addAttribute("locations", locations);
    model.addAttribute("currentCourse", id);
    model.addAttribute("loggedinuser", this.getPrincipal());
    model.addAttribute("breadcrumbs",
        this.breadcrumbBuilderService.getStaticBreadcrumb(new Breadcrumb("#", "コース名", "-")));
    return "listLocationEdit";
  }

  @RequestMapping(value = { "/{id}/location/edit" }, method = RequestMethod.GET)
  public String editLocation(ModelMap model, @PathVariable int id) {
    List<Courses> courses = this.courseService.findAllCourses();
    List<Locations> locations = this.locationService.findLocationByCourseId(id);
    model.addAttribute("courses", courses);
    model.addAttribute("locations", locations);
    model.addAttribute("currentCourse", id);
    model.addAttribute("loggedinuser", this.getPrincipal());
    model.addAttribute("breadcrumbs",
        this.breadcrumbBuilderService.getStaticBreadcrumb(new Breadcrumb("#", "コース名", "-")));
    return "editLocation";
  }

}
