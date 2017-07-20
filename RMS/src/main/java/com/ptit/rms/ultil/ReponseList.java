package com.ptit.rms.ultil;

import java.util.List;

public class ReponseList<T> {

  private int code;
  private boolean status;
  private List<T> data;

  public ReponseList() {
    super();
  }

  public ReponseList(List<T> data) {
    super();
    this.code = 200;
    this.status = true;
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

}
