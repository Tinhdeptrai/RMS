package com.ptit.rms.ultil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {

  public CommonUtil() {
  }

  private static final Pattern EMAIL_P = Pattern
      .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

  private static final Pattern USERNAME_P = Pattern.compile("^[A-Za-z0-9_-]{3,25}");

  public static boolean isValidEmail(String email) {
    Matcher matcher = EMAIL_P.matcher(email);
    return matcher.matches();
  }

  public static boolean isValidUsername(String username) {
    Matcher matcher = USERNAME_P.matcher(username);
    return matcher.matches();
  }

  public static boolean isValidPassword(String password) {
    if (password != null && password.length() > 5) {
      return true;
    }
    return false;
  }

  public static String formatDate(Date input) {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
    return sdf.format(input);
  }

}
