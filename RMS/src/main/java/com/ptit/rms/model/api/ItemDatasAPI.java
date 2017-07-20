package com.ptit.rms.model.api;

import java.util.Date;

import com.ptit.rms.ultil.DateUtil;

public class ItemDatasAPI {

  private int itemDataId;
  private int auditDateId;
  private int itemId;
  private String value;
  private String imageUrl;
  private String createdAt;
  private String updatedAt;
  private int createdBy;
  private int updatedBy;

  public ItemDatasAPI(int itemDataId, int auditDateId, int itemId, String value, String imageUrl, int createdBy, int updatedBy) {
    super();
    this.itemDataId = itemDataId;
    this.auditDateId = auditDateId;
    this.itemId = itemId;
    this.value = value;
    this.imageUrl = imageUrl;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public ItemDatasAPI() {
    super();
  }

  public ItemDatasAPI(int itemDataId, int auditDateId, int itemId, String value, String imageUrl, String createdAt, String updatedAt, int createdBy,
      int updatedBy) {
    super();
    this.itemDataId = itemDataId;
    this.auditDateId = auditDateId;
    this.itemId = itemId;
    this.value = value;
    this.imageUrl = imageUrl;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public int getItemDataId() {
    return itemDataId;
  }

  public void setItemDataId(int itemDataId) {
    this.itemDataId = itemDataId;
  }

  public int getAuditDateId() {
    return auditDateId;
  }

  public void setAuditDateId(int auditDateId) {
    this.auditDateId = auditDateId;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
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

}
