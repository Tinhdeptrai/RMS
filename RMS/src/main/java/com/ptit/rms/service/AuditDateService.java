package com.ptit.rms.service;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.AuditDate;
import com.ptit.rms.model.api.AuditDatesAPI;

public interface AuditDateService {

  List<AuditDate> getListAuditDateByDate(Date dateUpdateAt);

  List<AuditDatesAPI> convertAuditDateToJson(List<AuditDate> list);

}
