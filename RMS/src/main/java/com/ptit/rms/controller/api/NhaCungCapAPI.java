package com.ptit.rms.controller.api;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.model.NhaCungCap;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.api.NhaCungCapApi;
import com.ptit.rms.service.NhaCungCapService;
import com.ptit.rms.ultil.DateUtil;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class NhaCungCapAPI {

  @Autowired
  private NhaCungCapService nhaCungCapService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/nhacungcap/list", method = RequestMethod.GET)
  public ResponseEntity<ResponseList> getNhanVien(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<NhaCungCap> lstNhaCungCap = this.nhaCungCapService.getNhaCungCap();
      List<NhaCungCapApi> cungCapApis = this.nhaCungCapService.converNhaCungCap(lstNhaCungCap);
      ResponseList<NhaCungCapApi> lst = new ResponseList<>(cungCapApis);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/nhacungcap/update", method = RequestMethod.POST)
  public ResponseEntity<ResponseObject> UpdateKhachHang(@RequestHeader HttpHeaders headers, @RequestBody String str)
      throws ParseException, java.text.ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      JSONObject object = new JSONObject(str);
      String type = object.getString("type");
      if (type.equals("delete")) {
        int id = object.getInt("id");
        NhaCungCap nhaCungCap = this.nhaCungCapService.findById(id);
        nhaCungCap.setFlagDelete(true);
        this.nhaCungCapService.updateNCC(nhaCungCap);
      } else {
        String tenNCC = object.getString("tenNCC");
        String diaChi = object.getString("diaChi");
        String sdt = object.getString("sdt");
        String email = object.getString("email");
        if (type.equals("edit")) {
          String ngayKetThuc = object.getString("ngayKetThuc");
          int id = object.getInt("id");
          NhaCungCap nhaCungCap = this.nhaCungCapService.findById(id);
          nhaCungCap.setTenNcc(tenNCC);
          nhaCungCap.setDiaChi(diaChi);
          nhaCungCap.setSdt(sdt);
          nhaCungCap.setEmail(email);
          nhaCungCap.setNgayKt(DateUtil.string2Date(ngayKetThuc, "MM-dd-yyyy"));
          this.nhaCungCapService.updateNCC(nhaCungCap);
        }
        if (type.equals("new")) {
          String ngayKetThuc = object.getString("ngayKetThuc");
          NhaCungCap nhaCungCap = new NhaCungCap();
          nhaCungCap.setTenNcc(tenNCC);
          nhaCungCap.setDiaChi(diaChi);
          nhaCungCap.setSdt(sdt);
          nhaCungCap.setEmail(email);
          nhaCungCap.setNgayBd(new Date());
          if (ngayKetThuc != "no")
            nhaCungCap.setNgayKt(DateUtil.string2Date(ngayKetThuc, "MM-dd-yyyy"));
          this.nhaCungCapService.saveNCC(nhaCungCap);
        }
      }
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }
}
