package com.mb.io.connect.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class WebdriverTest {

    public static void main(String[] args) throws Exception{

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver.exe");
        String proxy = "bpa-proxy.mbio.global:3128";
        ChromeOptions options = new ChromeOptions().addArguments("--proxy-server=http://" + proxy);
        //options.addArguments("--enable-javascript");
        options.addArguments("disable-blink-features=AutomationControlled");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_setting_values.javascript", 1);
        options.setExperimentalOption("prefs",chromePrefs);
        options.setExperimentalOption("useAutomationExtension", false);
        //options.addExtensions(new File("C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\padekgcemlokbadohgkifijomclgjgif\\2.5.21_0.crx"));
        options.addArguments("load-extension=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\padekgcemlokbadohgkifijomclgjgif\\2.5.21_0\\");
     //   options..update({"javascript.enabled": True});
        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver(options);

        // Launch Website
        driver.navigate().to("https://mbconnect:TestConnect@AWS!Amap19@int-1-connect.nonprod.ece.dcp.mbio.zone/en-fr/connect/");

       // driver.navigate().to("https://id-int.mercedes-benz.com/ciam/auth/login#/");

        //Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(10000);
        //driver.findElement(By.xpath("(//button[@data-test='handle-accept-all-button'])[1]")).click();
        //Thread.sleep(3000);
        //driver.navigate().to("https://id-int.mercedes-benz.com/ciam/auth/login#/");
        driver.findElement(By.xpath("//button[@class='dcp-header-user__button dcp-header-user-button']")).click();
        driver.findElement(By.xpath("//button[@data-test-id='header-modal__login']")).click();
        Thread.sleep(5000);
        //Scroll down the webpage by 5000 pixels
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("scrollBy(0, 5000)");

        // Click on the Search button
        //driver.findElement(By.linkText("Core Java")).click();

    }

}