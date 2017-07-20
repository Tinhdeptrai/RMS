package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.Locations;
import com.ptit.rms.model.api.LocationsAPI;
import com.ptit.rms.repository.LocationRepository;
import com.ptit.rms.service.LocationService;

@Service("LocationRepositoryImpl")
@Transactional
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationRepository localtionRepository;

  @Override
  public List<Locations> findLocationByCourseId(int id) {
    return this.localtionRepository.findLocationByCourseId(id);
  }

  @Override
  public Locations findLocationById(int id) {
    return this.localtionRepository.findLocationById(id);
  }

  @Override
  public void updateLocation(Locations location) {
    this.localtionRepository.updateLocation(location);
  }

  @Override
  public void saveLocation(Locations location) {
    this.localtionRepository.saveLocation(location);

  }

  @Override
  public List<Locations> getListLocationByDate(Date dateUpdateAt) {
    return this.localtionRepository.getListLocationByDate(dateUpdateAt);
  }

  @Override
  public List<LocationsAPI> convertLocationToJson(List<Locations> list) {
    List<LocationsAPI> listLocations = new ArrayList<>();
    for (Locations location : list) {
      LocationsAPI locationsAPI = new LocationsAPI();
      locationsAPI.setLocationId(location.getLocationId());
      locationsAPI.setCoursesId(location.getCourses().getCourseId());
      locationsAPI.setLocationName(location.getLocationName());
      locationsAPI.setDescription(location.getDescription());
      locationsAPI.setLocationOrder(location.getLocationOrder());
      locationsAPI.setDeleted(location.getIsDeleted());
      locationsAPI.setCreatedBy(location.getCreatedBy());
      locationsAPI.setUpdatedBy(location.getUpdatedBy());
      locationsAPI.setCreatedAt(location.getUpdatedAt());
      locationsAPI.setUpdatedAt(location.getUpdatedAt());
      locationsAPI.setDeletedTime(location.getDeletedTime());
      listLocations.add(locationsAPI);
    }
    return listLocations;
  }

}
