package com.ptit.rms.service;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.Locations;
import com.ptit.rms.model.api.LocationsAPI;

public interface LocationService {

  List<Locations> findLocationByCourseId(int id);

  Locations findLocationById(int id);

  void updateLocation(Locations location);

  void saveLocation(Locations location);

  List<Locations> getListLocationByDate(Date dateUpdateAt);

  List<LocationsAPI> convertLocationToJson(List<Locations> list);

}
