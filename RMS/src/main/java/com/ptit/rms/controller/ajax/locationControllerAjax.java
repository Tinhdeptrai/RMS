package com.ptit.rms.controller.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.controller.BaseController;
import com.ptit.rms.model.Locations;
import com.ptit.rms.model.User;
import com.ptit.rms.service.LocationService;
import com.ptit.rms.service.UserService;
import com.ptit.rms.ultil.Constants;

@RestController
@RequestMapping("/location")
public class locationControllerAjax extends BaseController {

  @Autowired
  UserService userService;

  @Autowired
  LocationService locationService;

  @RequestMapping(value = { "/check-coursename" }, method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public boolean checkUsername(@RequestBody String str) {
    JSONObject jsonObject = new JSONObject(str);
    String id = jsonObject.getString(Constants.LOCATION_ID);
    Locations location = this.locationService.findLocationById(Integer.parseInt(id));
    if (location == null) {
      return true;
    }
    return false;
  }

  @RequestMapping(value = { "/update-location" }, method = RequestMethod.POST, produces = "application/json")
  public String updateUser(@RequestBody String str) {
    User currentUser = this.userService.findByUsername(getPrincipal());

    List<Locations> listLocationSave = new ArrayList<>();
    List<Locations> listLocationEdit = new ArrayList<>();

    JSONArray jsonarray = new JSONArray(str);
    for (int i = 0; i < jsonarray.length(); i++) {

      JSONObject jsonobject = jsonarray.getJSONObject(i);

      String type = jsonobject.getString(Constants.TYPE);
      String id = jsonobject.getString(Constants.LOCATION_ID) != null ? jsonobject.getString(Constants.LOCATION_ID)
          : "";
      if (type.equals(Constants.TYPE_DELETE)) {
        Locations location = null;
        if (!id.equals("")) {
          location = this.locationService.findLocationById(Integer.parseInt(id));
        }
        if (location != null) {
          location.setIsDeleted(true);
          location.setUpdatedAt(new Date());
          location.setUpdatedBy(currentUser.getId().intValue());
        }
        this.locationService.updateLocation(location);
      } else {
        String courseName = jsonobject.getString(Constants.COURSE_NAME) != null
            ? jsonobject.getString(Constants.COURSE_NAME) : "";
        if (type.equals(Constants.TYPE_EDIT)) {
          Locations location = null;
          if (!id.equals("")) {
            location = this.locationService.findLocationById(Integer.parseInt(id));
          }
          if (location != null) {
            location.setUpdatedAt(new Date());
            location.setUpdatedBy(currentUser.getId().intValue());
            if (!courseName.equals("")) {
              location.setLocationName(courseName);
            }
            listLocationEdit.add(location);
          }
        }
        if (type.equals(Constants.TYPE_SAVE)) {
          Locations locations = new Locations();
          locations.setLocationName(courseName);
          locations.setIsDeleted(false);
          locations.setCreatedAt(new Date());
          locations.setUpdatedAt(new Date());
          locations.setUpdatedBy(currentUser.getId().intValue());
          locations.setCreatedBy(currentUser.getId().intValue());
          listLocationSave.add(locations);
        }
      }
    }
    if (listLocationEdit.isEmpty()) {
      for (Locations location : listLocationEdit) {
        this.locationService.updateLocation(location);
      }
    }
    if (listLocationSave.isEmpty()) {
      for (Locations location : listLocationSave) {
        this.locationService.saveLocation(location);
      }
    }
    return "redirect:/list";
  }

}
