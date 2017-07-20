package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.AuditDate;
import com.ptit.rms.model.api.AuditDatesAPI;
import com.ptit.rms.repository.AuditDateRepository;
import com.ptit.rms.service.AuditDateService;

@Service("AuditDateService")
@Transactional
public class AuditDateServiceImpl implements AuditDateService {

  @Autowired
  private AuditDateRepository AuditDateRepository;

  @Override
  public List<AuditDate> getListAuditDateByDate(Date dateUpdateAt) {
    return this.AuditDateRepository.getListAuditDateByDate(dateUpdateAt);
  }

  @Override
  public List<AuditDatesAPI> convertAuditDateToJson(List<AuditDate> list) {
    List<AuditDatesAPI> auditDatesAPIs = new ArrayList<>();
    for (AuditDate auditDate : list) {
      AuditDatesAPI auditDatesAPI = new AuditDatesAPI(auditDate.getAuditDateId(), auditDate.getCourseId(), auditDate.getStatus());
      auditDatesAPI.setDate(auditDate.getDate());
      auditDatesAPIs.add(auditDatesAPI);
    }
    return auditDatesAPIs;
  }

}
