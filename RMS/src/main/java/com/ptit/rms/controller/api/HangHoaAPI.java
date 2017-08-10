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

import com.ptit.rms.model.DonViTinh;
import com.ptit.rms.model.HangHoa;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.api.HangHoaApi;
import com.ptit.rms.service.HangHoaService;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class HangHoaAPI {
  @Autowired
  private HangHoaService hangHoaService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/hanghoa/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getHangHoa(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<HangHoa> lstHangHoa = this.hangHoaService.getHangHoa();
      List<HangHoaApi> hangHoaApis = this.hangHoaService.converHangHoa(lstHangHoa);
      ResponseList<HangHoaApi> lst = new ResponseList<>(hangHoaApis);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/donvitinh/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getDonViTinh(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<DonViTinh> donViTinhs = this.hangHoaService.getDonViTinh();
      ResponseList<DonViTinh> lst = new ResponseList<>(donViTinhs);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/hanghoa/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
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
        HangHoa hangHoa = this.hangHoaService.findById(id);
        hangHoa.setFlagDelete(true);
        this.hangHoaService.updateHangHoa(hangHoa);
      } else {
        String tenHangHoa = object.getString("tenHangHoa");
        int slHienCo = object.getInt("slHienCo");
        String donViTinh = object.getString("donViTinh");
        String ghiChu = object.getString("ghiChu");
        int donGia = object.getInt("donGia");

        if (type.equals("edit")) {
          int id = object.getInt("id");
          HangHoa hangHoa = this.hangHoaService.findById(id);
          hangHoa.setTenHang(tenHangHoa);
          hangHoa.setSlhienCo(slHienCo);
          hangHoa.setDonGia(donGia);
          hangHoa.setGhiChu(ghiChu);
          DonViTinh donViTinhObj = this.hangHoaService.findDVTByName(donViTinh);
          if (donViTinhObj == null) {
            DonViTinh obj = new DonViTinh();
            obj.setTenDonVi(donViTinh);
            this.hangHoaService.createDVT(obj);
            hangHoa.setDonViTinh(obj);
          } else {
            hangHoa.setDonViTinh(donViTinhObj);
          }
          this.hangHoaService.updateHangHoa(hangHoa);
        }
        if (type.equals("new")) {
          HangHoa hangHoa = new HangHoa();
          hangHoa.setTenHang(tenHangHoa);
          hangHoa.setSlhienCo(slHienCo);
          hangHoa.setDonGia(donGia);
          hangHoa.setGhiChu(ghiChu);
          DonViTinh donViTinhObj = this.hangHoaService.findDVTByName(donViTinh);
          if (donViTinhObj == null) {
            DonViTinh obj = new DonViTinh();
            obj.setTenDonVi(donViTinh);
            this.hangHoaService.createDVT(obj);
            hangHoa.setDonViTinh(obj);
          } else {
            hangHoa.setDonViTinh(donViTinhObj);
          }
          this.hangHoaService.createHangHoa(hangHoa);
        }
      }
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

}
