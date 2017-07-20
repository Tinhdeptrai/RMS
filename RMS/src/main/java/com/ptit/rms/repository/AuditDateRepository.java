package com.ptit.rms.repository;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.AuditDate;

public interface AuditDateRepository {
  List<AuditDate> findAllAuditDate(int id);

  List<AuditDate> getListAuditDateByDate(Date dateUpdateAt);
}
