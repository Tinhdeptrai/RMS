package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.Breadcrumb;
import com.ptit.rms.service.BreadcrumbsBuilderService;

@Service("BreadcrumbsBuilderService")
@Transactional
public class BreadcrumbsBuilderServiceImpl implements BreadcrumbsBuilderService {
  
  public List<Breadcrumb> getUserBreadcrumb() {
    List<Breadcrumb> list = new ArrayList<Breadcrumb>();
    list.add(new Breadcrumb("#", "ユーザ設定", ""));   
    return list;
  }
  
  public List<Breadcrumb> getCourseBreadcrumb() {
    List<Breadcrumb> list = new ArrayList<Breadcrumb>();
    
    // TODO: something here
    return list;
  }
  
  public List<Breadcrumb> getLocationBreadcrumb() {
    List<Breadcrumb> list = new ArrayList<Breadcrumb>();
    
    // TODO: something here
    return list;
  }
  
  public List<Breadcrumb> getStaticBreadcrumb(Breadcrumb breadcrumb) {
    List<Breadcrumb> list = new ArrayList<Breadcrumb>();
    list.add(breadcrumb);   
    return list;
  }
}
