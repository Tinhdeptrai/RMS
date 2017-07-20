package com.ptit.rms.service;

import java.util.List;

import com.ptit.rms.model.Breadcrumb;

public interface BreadcrumbsBuilderService {
  List<Breadcrumb> getUserBreadcrumb();
  List<Breadcrumb> getCourseBreadcrumb();
  List<Breadcrumb> getLocationBreadcrumb();
  List<Breadcrumb> getStaticBreadcrumb(Breadcrumb breadcrumb);
}
