package com.ptit.rms.model.api;

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class ItemsAPI {

  private int itemId;
  private int locationId;
  private String itemName;
  private boolean type;
  private String description;
  private String unit;
  private Integer min;
  private Integer max;
  private String mapUrl;
  private boolean isDeleted;
  private int itemOrder;
  private String deletedTime;
  private String createdAt;
  private String updatedAt;
  private int createdBy;
  private int updatedBy;

  public ItemsAPI() {
    super();
  }

  public ItemsAPI(int itemId, int locationId, String itemName, boolean type, String description, String unit, Integer min, Integer max, String mapUrl,
      boolean isDeleted, int createdBy, int updatedBy, int itemOrder) {
    super();
    this.itemId = itemId;
    this.locationId = locationId;
    this.itemName = itemName;
    this.type = type;
    this.description = description;
    this.unit = unit;
    this.min = min;
    this.max = max;
    this.mapUrl = mapUrl;
    this.isDeleted = isDeleted;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.itemOrder = itemOrder;
  }

  public ItemsAPI(int itemId, int locationId, String itemName, boolean type, String description, String unit, Integer min, Integer max, String mapUrl,
      boolean isDeleted, String deletedTime, String createdAt, String updatedAt, int createdBy, int updatedBy) {
    super();
    this.itemId = itemId;
    this.locationId = locationId;
    this.itemName = itemName;
    this.type = type;
    this.description = description;
    this.unit = unit;
    this.min = min;
    this.max = max;
    this.mapUrl = mapUrl;
    this.isDeleted = isDeleted;
    this.deletedTime = deletedTime;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public int getLocationId() {
    return locationId;
  }

  public void setLocationId(int locationId) {
    this.locationId = locationId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public boolean isType() {
    return type;
  }

  public void setType(boolean type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Integer getMin() {
    return min;
  }

  public void setMin(Integer min) {
    this.min = min;
  }

  public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }

  public String getMapUrl() {
    return mapUrl;
  }

  public void setMapUrl(String mapUrl) {
    this.mapUrl = mapUrl;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public String getDeletedTime() {
    return deletedTime;
  }

  public void setDeletedTime(Date deletedTime) {
    this.deletedTime = DateUtil.date2String(deletedTime, "MM-dd-yyyy HH:mm:ss");
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

  public int getItemOrder() {
    return itemOrder;
  }

  public void setItemOrder(int itemOrder) {
    this.itemOrder = itemOrder;
  }

}
