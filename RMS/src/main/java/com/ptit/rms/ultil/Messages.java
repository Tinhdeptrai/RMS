package com.ptit.rms.ultil;

public class Messages {

  private int code;
  private String message;
  private boolean status;

  public Messages() {
    super();
  }

  public Messages(int code, String message, boolean status) {
    super();
    this.code = code;
    this.message = message;
    this.status = status;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}
