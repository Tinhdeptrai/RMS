package com.ptit.rms.model.api;

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class AuditDatesAPI {

  private int auditDateId;
  private String date;
  private int courseId;
  private boolean status;

  public AuditDatesAPI() {
    super();
  }

  public AuditDatesAPI(int auditDateId, int courseId, boolean status) {
    super();
    this.auditDateId = auditDateId;
    this.courseId = courseId;
    this.status = status;
  }

  public AuditDatesAPI(int auditDateId, String date, int courseId, boolean status) {
    super();
    this.auditDateId = auditDateId;
    this.date = date;
    this.courseId = courseId;
    this.status = status;
  }

  public int getAuditDateId() {
    return auditDateId;
  }

  public void setAuditDateId(int auditDateId) {
    this.auditDateId = auditDateId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = DateUtil.date2String(date, "MM-dd-yyyy HH:mm:ss");
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}
