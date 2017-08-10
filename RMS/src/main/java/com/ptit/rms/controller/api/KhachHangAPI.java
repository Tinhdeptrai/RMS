package com.ptit.rms.controller.api;

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

import com.ptit.rms.model.KhachHang;
import com.ptit.rms.model.TheUuDai;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.api.KhachHangApi;
import com.ptit.rms.service.KhachHangService;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class KhachHangAPI {
  @Autowired
  private KhachHangService khachHangService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/khachhang/list", method = RequestMethod.GET)
  public ResponseEntity<ResponseList> getKhachHang(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<KhachHang> lstKhachHang = this.khachHangService.getKhachHang();
      List<KhachHangApi> KhachHangApis = this.khachHangService.converKhachHang(lstKhachHang);

      ResponseList<KhachHangApi> lst = new ResponseList<>(KhachHangApis);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/khachhang/update", method = RequestMethod.POST)
  public ResponseEntity<ResponseObject> UpdateKhachHang(@RequestHeader HttpHeaders headers, @RequestBody String str)
      throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      JSONObject object = new JSONObject(str);
      String type = object.getString("type");
      if (type.equals("delete")) {
        int id = object.getInt("id");
        KhachHang KhachHang = this.khachHangService.findById(id);
        KhachHang.setFlagDelete(true);
        this.khachHangService.updateKhachHang(KhachHang);
      } else {
        String tenKhachHang = object.getString("tenkhachhang");
        String diaChi = object.getString("diachi");
        String sdt = object.getString("sdt");
        String email = object.getString("email");
        String diemThuong = object.getString("diemthuong");
        String ghiChu = object.getString("ghichu");
        String theUuDai = object.getString("the");
       
        if (type.equals("edit")) {
          int id = object.getInt("id");
          KhachHang KhachHang = this.khachHangService.findById(id);
          KhachHang.setTenKhachHang(tenKhachHang);
          KhachHang.setDiaChi(diaChi);
          KhachHang.setSdt(sdt);
          KhachHang.setEmail(email);
          KhachHang.setGhiChu(ghiChu);
          KhachHang.setDiemThuong(Integer.parseInt(diemThuong));
          TheUuDai theUuDai2 = this.khachHangService.getTheUuDaiByName(theUuDai);
          KhachHang.setTheUuDai(theUuDai2);
          this.khachHangService.updateKhachHang(KhachHang);
        }
        if (type.equals("new")) {

          KhachHang KhachHang = new KhachHang();
          KhachHang.setTenKhachHang(tenKhachHang);
          KhachHang.setDiaChi(diaChi);
          KhachHang.setSdt(sdt);
          KhachHang.setEmail(email);
          KhachHang.setGhiChu(ghiChu);
          KhachHang.setDiemThuong(Integer.parseInt(diemThuong));
          TheUuDai theUuDai2 = this.khachHangService.getTheUuDaiByName(theUuDai);
          KhachHang.setTheUuDai(theUuDai2);
          KhachHang.setFlagDelete(false);
          this.khachHangService.saveKhachHang(KhachHang);

        }
      }
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

}
