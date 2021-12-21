package com.mb.io.connect.frontend.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

   public static Target LOGIN_EMAIL = Target.the("Account ID").located(By.xpath("//input[@id='userIdInput']"));
   public static Target LOGIN_LOAD = Target.the("Load Login Page").located(By.xpath("//button[@id='loadingTrigger']"));
   public static Target LOGIN_USR = Target.the("Account User").located(By.xpath("//input[@type='email']"));
   public static Target LOGIN_PASS = Target.the("Account Password").located(By.xpath("//input[@type='password']"));
   public static Target LOGIN_SUBMIT = Target.the("Account ID").located(By.xpath("//input[@type='submit']"));
   public static Target PASS = Target.the("Password").located(By.xpath("//input[@id='password']"));

  }
