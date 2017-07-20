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

import com.ptit.rms.model.Items;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.api.ItemsAPI;
import com.ptit.rms.service.ItemService;
import com.ptit.rms.ultil.DateUtil;
import com.ptit.rms.ultil.ReponseList;
import com.ptit.rms.ultil.VerifyToken;

@RestController
@RequestMapping("api")
public class ItemAPI {

  @Autowired
  private ItemService itemService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/item", method = RequestMethod.GET)
  public ResponseEntity<ReponseList> getListItemByUpdateTime(@RequestParam("time") String date, @RequestHeader HttpHeaders headers)
      throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      if (date != null && DateUtil.validateDateFormatMmDmYyyy(date)) {
        Date dateUpdateAt = DateUtil.string2Date(date, "MM-dd-yyyy HH:mm:ss");
        List<Items> list = this.itemService.getListItemByDate(dateUpdateAt);
        List<ItemsAPI> itemsAPIs = this.itemService.convertItemToJson(list);
        ReponseList<ItemsAPI> success = new ReponseList<>(itemsAPIs);
        return new ResponseEntity<ReponseList>(success, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }
  }

}
