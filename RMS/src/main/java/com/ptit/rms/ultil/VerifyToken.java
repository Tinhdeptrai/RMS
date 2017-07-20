package com.ptit.rms.ultil;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpHeaders;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.ptit.rms.model.TokenInfor;

public class VerifyToken {
  public static String createToken(TokenInfor infor) {

    try {
      Gson gson = new Gson();
      Date date = new Date();
      Algorithm algorithm = Algorithm.HMAC256(Constants.SECRET_KEY);
      String token = JWT.create().withIssuer("InspectionAuth").withClaim("tokenInfor", gson.toJson(infor))
          .withExpiresAt(date).sign(algorithm);
      System.out.println(token);
      return token;
    } catch (UnsupportedEncodingException exception) {
      System.out.println(exception);
      return "";
    } catch (JWTCreationException exception) {
      System.out.println(exception);
      return "";
    }
  }

  public static TokenInfor verify(HttpHeaders headers) {

    if (headers.get("Authorization") == null) {
      return null;
    } else {
      try {
        String token = headers.get("Authorization").get(0);
        Gson gson = new Gson();
        Algorithm algorithm = Algorithm.HMAC256(Constants.SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(21600).withIssuer("InspectionAuth").build();
        DecodedJWT jwt = verifier.verify(token);
        Claim claim = jwt.getClaim("tokenInfor");
        String jsonInString = claim.asString();
        TokenInfor infor = gson.fromJson(jsonInString, TokenInfor.class);
        return infor;
      } catch (UnsupportedEncodingException exception) {
        return null;
      } catch (JWTVerificationException exception) {
        return null;
      }

    }
  }

  public static void main(String[] args) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    System.out.println(dateFormat.format(date));
    TokenInfor infor = new TokenInfor("tinh", "1", "2", "3", "4");
    createToken(infor);
    // / verify();

  }
}
