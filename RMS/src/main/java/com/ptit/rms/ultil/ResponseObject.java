package com.ptit.rms.ultil;

public class ResponseObject<T> {

  private int code;
  private boolean status;
  private T data;

  public ResponseObject() {
    super();
  }

  public ResponseObject(T data) {
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
    return this.status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
