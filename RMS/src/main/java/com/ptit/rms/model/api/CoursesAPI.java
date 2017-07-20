package com.ptit.rms.model.api;

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class CoursesAPI {

  private int courseId;
  private int updatedBy;
  private int createdBy;
  private String courseName;
  private boolean isDeleted;
  private String createdAt;
  private String updatedAt;
  private int courseOrder;
  private String deletedTime;

  public CoursesAPI() {
    super();
  }

  public CoursesAPI(int courseId, int usersByUpdatedBy, int usersByCreatedBy, String courseName, boolean isDeleted, String createdAt,
      String updatedAt) {
    super();
    this.courseId = courseId;
    this.updatedBy = usersByUpdatedBy;
    this.createdBy = usersByCreatedBy;
    this.courseName = courseName;
    this.isDeleted = isDeleted;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public int getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(int usersByUpdatedBy) {
    this.updatedBy = usersByUpdatedBy;
  }

  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int usersByCreatedBy) {
    this.createdBy = usersByCreatedBy;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
      this.createdAt = DateUtil.date2String(createdAt, "MM-dd-yyyy HH:mm:ss");
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = DateUtil.date2String(updatedAt, "MM-dd-yyyy HH:mm:ss");
  }

  public int getCourseOrder() {
    return courseOrder;
  }

  public void setCourseOrder(int courseOrder) {
    this.courseOrder = courseOrder;
  }

  public String getDeletedTime() {
    return deletedTime;
  }

  public void setDeletedTime(Date deletedTime) {
      this.deletedTime = DateUtil.date2String(deletedTime, "MM-dd-yyyy HH:mm:ss");
  }

}
