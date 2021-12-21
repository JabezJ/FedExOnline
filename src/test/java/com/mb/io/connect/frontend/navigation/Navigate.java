package com.mb.io.connect.frontend.navigation;

import com.mb.io.connect.frontend.login.WaitUntilElement;
import com.mb.io.connect.frontend.tasks.waits.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navigate {

    public static Performable toTheConnectShop(String baseUrl,boolean cookie) {
        return Task.where("{0} navigates to the connect shop",
                actor -> {
                    actor.attemptsTo(
                            Open.browserOn().thePageNamed(baseUrl),
                            WaitFor.noMoreThan(5).seconds()
                    );
                    if (cookie) {
                        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
                        WebDriverWait wait = new WebDriverWait(driver,30);
                        wait.until(ExpectedConditions.presenceOfElementLocated(SHADOW_COOKIE));
                        if (!driver.findElements(SHADOW_COOKIE).isEmpty())
                        {
                            WebElement root = driver.findElement(SHADOW_COOKIE);
                            WebElement shadowDomRoot = expand_shadow_element(driver, root);
                            shadowDomRoot.findElement(ACCEPT).click();
                        }
                    }
                    WaitUntilElement.visible(CHECK);
                    actor.attemptsTo(
                            JavaScriptClick.on(LOGIN)
                    );
                    WaitUntilElement.visible(EMAIL);
                }
        );
    }
    public static Performable toTheOC2ConnectShop(String baseUrl,boolean cookie) {
        return Task.where("{0} navigates to the connect shop",
                actor -> {
                    actor.attemptsTo(
                            Open.browserOn().thePageNamed(baseUrl),
                            WaitFor.noMoreThan(5).seconds()
                    );
                    if (cookie) {
                        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
                        WebDriverWait wait = new WebDriverWait(driver,30);
                        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(SHADOW_COOKIE));
                    /*    element.sendKeys(Keys.SHIFT);
                        for (int i=0;i<=4;i++) {
                            element.sendKeys(Keys.TAB);
                        }
                        element.sendKeys(Keys.ENTER);*/

                        if (!driver.findElements(SHADOW_COOKIE).isEmpty())
                        {
                            WebElement root = driver.findElement(SHADOW_COOKIE);
                            element = wait.until(ExpectedConditions.presenceOfElementLocated(SHADOW_COOKIE));
                           // WebElement shadowDomRoot = expand_shadow_element(driver, element);
                            driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
                            Object obj = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
                            WebElement shadow_root = (WebElement) (obj);
                           //Shadow shadow = new Shadow(driver);
                            shadow_root.findElement(ACCEPT).click();
                        }


                    }
                    WaitUntilElement.visible(OC2_USER.resolveFor(actor));
                    actor.attemptsTo(
                            JavaScriptClick.on(OC2_USER),
                            JavaScriptClick.on(OC2_LOGIN)
                    );
                    WaitUntilElement.visible(EMAIL);
                }
        );
    }
    public static Performable toTheOC2ConnectShop1(String baseUrl,boolean cookie) {
        return Task.where("{0} navigates to the OC2 connect shop",
                actor -> {
                    actor.attemptsTo(
                            Open.browserOn().thePageNamed(baseUrl),
                            WaitFor.noMoreThan(2).seconds()
                    );
                    if (cookie) {
                        WaitUntilElement.visible(OC2_ACCEPT.resolveFor(actor));
                        actor.attemptsTo(
                                JavaScriptClick.on(OC2_ACCEPT)
                        );
                    }
                    WaitUntilElement.visible(OC2_USER.resolveFor(actor));
                    actor.attemptsTo(
                            JavaScriptClick.on(OC2_USER),
                            JavaScriptClick.on(OC2_LOGIN)
                    );
                    WaitUntilElement.visible(EMAIL);
                }
        );
    }
    public WebElement getShadowRootElement(WebDriver driver,WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }
    public static Performable toTheShoppingCart() {
        return Task.where("{0} navigates to the Shopping Cart",
                actor -> {
                    actor.attemptsTo(
                            JavaScriptClick.on(OPEN_CART_ICON)
                    );
                    List<WebElementFacade> emptyCart = EMPTY_CART.resolveAllFor(actor);
                    if (emptyCart.isEmpty()) {
                       // WaitUntilElement.visible(GOTO_SHOPPING_CART);
                        actor.attemptsTo(
                                WaitUntil.the(GOTO_SHOPPING_CART,isVisible()),
                                JavaScriptClick.on(GOTO_SHOPPING_CART)
                        );
                    }else
                    {
                        actor.attemptsTo(
                                JavaScriptClick.on(CLOSE_CART)
                        );
                    }
                }
        );
    }
    public static Performable toTheNextSection() {
        return Task.where("{0} navigates to the Next Section",
                actor -> {
                    actor.attemptsTo(
                            JavaScriptClick.on(MOVE_FORWARD)
                    );
                    WaitUntilElement.visible(MOVE_FORWARD);
                }
        );
    }
    public static WebElement expand_shadow_element(WebDriver driver, WebElement element)
    {
        WebElement shadow_root = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
        return shadow_root;
    }

}


