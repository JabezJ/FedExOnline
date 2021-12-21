package com.mb.io.connect.frontend.login;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WaitUntilElement {
    public static void visible(By by) {
        //WaitUntil.the(RenewalDetailsPage.IF_IP_RIGHT, isVisible()).forNoMoreThan(100).seconds();
        for (int second = 0; second <= 30; second++) {
            try{
                Thread.sleep(3000);
                WebElement element = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().findElement(by);
                if (element.isEnabled()){
                    System.out.println("***completed loading*************************** "+second);
                    break;
                }else
                {
                    System.out.println("still loading*************************** "+second);
                }
            }catch (Exception e){
                System.out.println("----completed loading---"+e.getMessage());
            }
        }
    }

    public static void visible(WebElement we) {
        //WaitUntil.the(RenewalDetailsPage.IF_IP_RIGHT, isVisible()).forNoMoreThan(100).seconds();
        for (int second = 0; second <= 10; second++) {
            try{
                Thread.sleep(3000);
                if (we.isEnabled()){
                    System.out.println("***completed loading*************************** "+second);
                    break;
                }else
                {
                    System.out.println("still loading*************************** "+second);
                }
            }catch (Exception e){
                System.out.println("----completed loading---"+e.getMessage());
            }
        }
    }
}
