package com.ptit.rms.controller.api;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.model.AuditDate;
import com.ptit.rms.model.Courses;
import com.ptit.rms.model.ItemData;
import com.ptit.rms.model.Items;
import com.ptit.rms.model.Locations;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.User;
import com.ptit.rms.service.AuditDateService;
import com.ptit.rms.service.CourseService;
import com.ptit.rms.service.ItemDataService;
import com.ptit.rms.service.ItemService;
import com.ptit.rms.service.LocationService;
import com.ptit.rms.service.UserService;
import com.ptit.rms.ultil.DateUtil;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.VerifyToken;

@RestController
@RequestMapping("api")
public class SynchronizeAPI {

  @Autowired
  private AuditDateService auditdateService;

  @Autowired
  private CourseService courseService;

  @Autowired
  private ItemDataService itemDataService;

  @Autowired
  private LocationService locationServer;

  @Autowired
  private UserService userService;

  @Autowired
  private ItemService itemService;

  @RequestMapping(value = "/checksyn", method = RequestMethod.GET)
  public ResponseEntity<Messages> checkSynchronize(@RequestParam("time") String date, @RequestHeader HttpHeaders headers) throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      if (date != null && DateUtil.validateDateFormatMmDmYyyy(date)) {
        Date dateUpdateAt = DateUtil.string2Date(date, "MM-dd-yyyy HH:mm:ss");
        List<ItemData> listItemData = this.itemDataService.getListItemByDate(dateUpdateAt);
        if (listItemData != null && listItemData.size() > 0) {
          Messages messages = new Messages(200, "true", true);
          return new ResponseEntity<Messages>(messages, HttpStatus.OK);
        }
        List<AuditDate> listAuditDate = this.auditdateService.getListAuditDateByDate(dateUpdateAt);
        if (listAuditDate != null && listAuditDate.size() > 0) {
          Messages messages = new Messages(200, "true", true);
          return new ResponseEntity<Messages>(messages, HttpStatus.OK);
        }
        List<Items> listItem = this.itemService.getListItemByDate(dateUpdateAt);
        if (listItem != null && listItem.size() > 0) {
          Messages messages = new Messages(200, "true", true);
          return new ResponseEntity<Messages>(messages, HttpStatus.OK);
        }
        List<Locations> listLocation = this.locationServer.getListLocationByDate(dateUpdateAt);
        if (listLocation != null && listLocation.size() > 0) {
          Messages messages = new Messages(200, "true", true);
          return new ResponseEntity<Messages>(messages, HttpStatus.OK);
        }
        List<Courses> listCourses = this.courseService.getListCourseByDate(dateUpdateAt);
        if (listCourses != null && listCourses.size() > 0) {
          Messages messages = new Messages(200, "true", true);
          return new ResponseEntity<Messages>(messages, HttpStatus.OK);
        }
        List<User> listUser = this.userService.getListUserByDate(dateUpdateAt);
        if (listUser != null && listUser.size() > 0) {
          Messages messages = new Messages(200, "true", true);
          return new ResponseEntity<Messages>(messages, HttpStatus.OK);
        }
        Messages messages = new Messages(200, "false", true);
        return new ResponseEntity<Messages>(messages, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }
  }
}
