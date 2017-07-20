package com.ptit.rms.model;

public class Breadcrumb {
  public String url;
  public String name;
  public String value;

  public Breadcrumb(final String url, final String name, final String value)
  {
    this.url = url;
    this.name = name;
    this.value = value;
  }
  
  public String getUrl() 
  {
    return this.url;
  }
  
  public String getName() 
  {
    return this.name;
  }
  
  public String getValue() 
  {
    return this.value;
  }
}
