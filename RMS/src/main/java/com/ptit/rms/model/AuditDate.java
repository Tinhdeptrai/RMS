package com.ptit.rms.model;
// Generated Jul 11, 2017 9:20:47 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "audit_date")
public class AuditDate {

  private int auditDateId;
  private Date date;
  private int courseId;
  private boolean status;
  private Set<ItemData> itemDatas = new HashSet<ItemData>(0);

  public AuditDate() {
  }

  public AuditDate(int auditDateId, Date date, int courseId, boolean status) {
    this.auditDateId = auditDateId;
    this.date = date;
    this.courseId = courseId;
    this.status = status;
  }

  public AuditDate(int auditDateId, Date date, int courseId, boolean status, Set<ItemData> itemDatas) {
    this.auditDateId = auditDateId;
    this.date = date;
    this.courseId = courseId;
    this.status = status;
    this.itemDatas = itemDatas;
  }

  @Id

  @Column(name = "audit_date_id", unique = true, nullable = false)
  public int getAuditDateId() {
    return this.auditDateId;
  }

  public void setAuditDateId(int auditDateId) {
    this.auditDateId = auditDateId;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date", nullable = false, length = 23)
  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Column(name = "course_id", nullable = false)
  public int getCourseId() {
    return this.courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  @Column(name = "status", nullable = false)
  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "auditDate")
  public Set<ItemData> getItemDatas() {
    return this.itemDatas;
  }

  public void setItemDatas(Set<ItemData> itemDatas) {
    this.itemDatas = itemDatas;
  }

}
