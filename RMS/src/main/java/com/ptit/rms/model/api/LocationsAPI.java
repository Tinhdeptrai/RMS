package com.ptit.rms.model.api;

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class LocationsAPI {

  private int locationId;
  private int coursesId;
  private String locationName;
  private String description;
  private int locationOrder;
  private boolean isDeleted;
  private String createdAt;
  private String updatedAt;
  private int createdBy;
  private int updatedBy;
  private String deletedTime;

  public LocationsAPI() {
    super();
  }

  public LocationsAPI(int locationId, int coursesId, String locationName, String description, int locationOrder, boolean isDeleted, String createdAt,
      String updatedAt, int createdBy, int updatedBy) {
    super();
    this.locationId = locationId;
    this.coursesId = coursesId;
    this.locationName = locationName;
    this.description = description;
    this.locationOrder = locationOrder;
    this.isDeleted = isDeleted;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public int getLocationId() {
    return locationId;
  }

  public void setLocationId(int locationId) {
    this.locationId = locationId;
  }

  public int getCoursesId() {
    return coursesId;
  }

  public void setCoursesId(int coursesId) {
    this.coursesId = coursesId;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getLocationOrder() {
    return locationOrder;
  }

  public void setLocationOrder(int locationOrder) {
    this.locationOrder = locationOrder;
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
    ;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = DateUtil.date2String(updatedAt, "MM-dd-yyyy HH:mm:ss");
  }

  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }

  public int getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(int updatedBy) {
    this.updatedBy = updatedBy;
  }

  public String getDeletedTime() {
    return deletedTime;
  }

  public void setDeletedTime(Date deletedTime) {
    this.deletedTime = DateUtil.date2String(deletedTime, "MM-dd-yyyy HH:mm:ss");
  }

}
