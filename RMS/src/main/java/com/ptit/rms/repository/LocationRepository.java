package com.ptit.rms.repository;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.Locations;

public interface LocationRepository {
  List<Locations> findLocationByCourseId(int id);

  Locations findLocationById(int id);

  void updateLocation(Locations location);

  void saveLocation(Locations location);

  List<Locations> getListLocationByDate(Date dateUpdateAt);
}
