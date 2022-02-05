package com.fedex.com.frontend.pageObjects;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FedexOnlinePage {

   public static Target COOKIE = Target.the("Cookie").located(By.xpath("//button[text()='ACCEPT ALL COOKIES']"));
   public static Target AlertBtn = Target.the("Alert button").located(By.xpath("//span[@class='fxg-alert__close-btn']"));


   public static Target LogInMenu = Target.the("LogInMenu").located(By.xpath("//img[@alt='Sign in to Fedex.com']"));
   public static Target LogIn = Target.the("LogIn").located(By.xpath("//a[@title='Log In']"));
   public static Target SignOut = Target.the("SignOut").located(By.xpath("//a[@title='SIGN OUT']"));

   public static Target InvalidCredentials = Target.the("Invalid Credentials").located(By.xpath("//div[@id='invalidCredentials']"));



   public static final Target UserOption = Target.the("UserOption").locatedBy("//span[normalize-space()='{0}']");

   public static Target USER = Target.the("userId").located(By.xpath("//input[@id='userId']"));
   public static Target PASS = Target.the("Password").located(By.xpath("//input[@id='password']"));

   public static Target LogIn_Btn = Target.the("login-btn").located(By.xpath("//button[@id='login-btn']"));

   public static Target FDXCube = Target.the("Feature Push button").locatedBy("//span[normalize-space()='{0}']");
   public static Target FromAdd = Target.the("From Address").located(By.xpath("//input[@id='fromGoogleAddress']"));

   public static Target FromPostcode = Target.the("From Postcode").located(By.xpath("//input[@id='fromPostcode']"));
   public static Target ToPostcode = Target.the("To Postcode").located(By.xpath("//input[@id='toPostcode']"));

   public static Target ContinueEntry = Target.the("CONTINUE").located(By.xpath("//button[contains(text(),'CONTINUE')]"));

   public static Target ToAdd = Target.the("To Address").located(By.xpath("//input[@id='toGoogleAddress']"));

   public static Target PackageType = Target.the("package-details-package-type").located(By.xpath("//select[@id='package-details__package-type']"));

   public static final Target PackOption = Target.the("UserOption").locatedBy("//option[normalize-space()='{0}']");


   public static Target PackageQuantity = Target.the("package-details__quantity").located(By.xpath("//select[@id='package-details__quantity-0']"));

   public static Target PackageWeight = Target.the("package-details__weight").located(By.xpath("//input[@id='package-details__weight-0']"));

   public static Target PackageDetailsSubmit = Target.the("e2ePackage Details Submit Button Rates").located(By.xpath("//button[@id='e2ePackageDetailsSubmitButtonRates']"));

   public static Target CalculatedRateSummary = Target.the("Calculated Shipment Rate Summary").located(By.xpath("//*[@id='rateSummary']"));

   public static Target TrackingNumber = Target.the("Tracking number").located(By.xpath("//*[@id='HomeTrackingApp']/div/input[1]"));
   public static Target Track = Target.the("Track").located(By.xpath("//button[@id='btnSingleTrack']"));

}
