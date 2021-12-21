package com.mb.io.connect.frontend.mb;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MBConnectShopPage {

   public static Target NUMBER_TO_RENEW = Target.the("Number to renew").located(By.xpath("//*[@id='text-input-ipRIghtNumber']"));
   public static Target FORM_FILING_DATE = Target.the("Form filing date").located(By.xpath("//*[@id='datetimepicker-input-renewalFilingDate2']"));
   public static Target CUSTOMER_REF = Target.the("Customer reference").located(By.xpath("//input[@id='text-input-renewalCustomerReference']"));
   public static Target CONTINUE = Target.the("Continue").located(By.xpath("//button[@id='button-button-okbutton']"));

   public static Target IF_IP_RIGHT = Target.the("Select IP Right").located(By.xpath("//iframe[@title='Select IP Right']"));

   public static By CHECK = By.xpath("(//input[@name='code'])[2]");

   public static By LOGIN = By.xpath("//a[@data-testid='navigation-login-ciam']");

   public static By ACCOUNT = By.xpath("//a[@data-testid='navigation-open-account']");

   public static By LOGOUT = By.xpath("//a[@data-testid='navigation-login-ciam']");

   public static By EMAIL = By.xpath("//input[@id='username']");
   public static By CONTINUE_LOGIN = By.xpath("//button[@id='continue']");

   public static By PASSWORD = By.xpath("//input[@id='password']");
   public static By CONTINUE_CONFIRM = By.xpath("//button[@id='confirm']");

   public static By LOGIN_WITH_PASSWORD = By.xpath("//button[@id='login-with-password']");

   public static Target DEFINE = Target.the("create new vehicle").located(By.xpath("(//a[@data-dcp-click='createConnectMe'])[2]"));

   public static Target WITH_PASSWORD = Target.the("LOGIN_WITH_PASSWORD").located(By.xpath("//button[@id='login-with-password']"));

   public static Target LOGOUT_ACCOUNT = Target.the("LOGOUT ACCOUNT").located(By.xpath("//a[@data-testid='navigation-login-ciam']"));

   public static Target LOGIN_ACCOUNT = Target.the("LOGIN ACCOUNT").located(By.xpath("//a[@data-testid='navigation-login-ciam']"));

   public static Target VIN = Target.the("Vehicle Identification Number").located(By.xpath("//input[@id='utils-compatibility-check-input_161']"));

   public static Target CHECK_AVAILABILITY = Target.the("Check Availability").located(By.xpath("//button[@data-testid='utils-compatibility-check-submit-button']"));

   public static Target CHECK_MESSAGE = Target.the("compatibility-check-message").located(By.xpath("//div[@class='utils-compatibility-check__message-bar utils-compatibility-check-message-bar ng-scope']"));

   public static By GOTO_SHOPPING_CART = By.xpath("//a[@data-testid='dcp-co-header-cart_open-cart']");

   public static By OPEN_CART_ICON = By.xpath("//a[@data-testid='co-header-cart-open']");

   public static final Target EMPTY_CART = Target.the("Empty cart").locatedBy("//div[@data-ng-if='cartIsEmpty()']");

   public static final Target CLOSE_CART = Target.the("Close cart").locatedBy("//a[@data-ng-click='closeHeaderCart()']");

   public static By MOVE_FORWARD = By.xpath("//button[@data-testid='co-func-header-forward']");

   public static By CONTINUE_SHIPPING= By.xpath("//button[@data-testid='co-func-header-forward' and @data-track-click-as='go to shipping']");

   public static By CONTINUE_PAYMENT = By.xpath("//button[@data-testid='co-func-header-forward' and @data-track-click-as='go to payment']");

   public static By CONTINUE_SUMMARY = By.xpath("//button[@data-testid='co-func-header-forward' and @data-track-click-as='go to summary']");

   public static By MOVE_BACKWARD_PAYMENT = By.xpath("//a[@data-testid='co-func-header-back' and @data-track-click-as='go to payment']");

   public static final Target TOTAL_PRICE = Target.the("Total Price").located(By.xpath("//span[text()='Subtotal:']"));

   public static final Target FEDERAL_TAXES = Target.the("Federal Taxes").located(By.xpath("//span[text()='GST/HST:']"));

   public static final Target PROVINCIAL_TAXES = Target.the("Provincial Taxes").located(By.xpath("//span[text()='PST/QST/RST:']"));

   public static final Target TOTAL_PRICE_WITH_TAX = Target.the("Total Price with tax").located(By.xpath("//span[text()='Total price (taxes included): ']"));

   public static final Target ADDRESS = Target.the("Address").located(By.xpath("//div[@data-ng-if='vm.paymentAddress']"));

   public static By SHADOW_COOKIE = By.cssSelector("body > cmm-cookie-banner");

   public static final Target OC2_ACCEPT = Target.the("Accept").located(By.xpath("(//button[@data-test='handle-accept-all-button'])[1]"));


   public static final Target OC2_USER = Target.the("User").located(By.xpath("//button[@class='dcp-header-user__button dcp-header-user-button']"));

   public static final Target OC2_LOGIN = Target.the("Login").located(By.xpath("//button[@data-test-id='header-modal__login']"));
   public static final Target OC2_LOGOUT = Target.the("Logout").located(By.xpath("//button[@data-test-id='header-modal__logout']"));

   public static final Target OC2_CART = Target.the("Cart").located(By.xpath("//button[@class='dcp-header-cart__button dcp-header-cart-button']"));

   public static final Target OC2_CART_DELETE = Target.the("Cart delete").located(By.xpath("//button[@class='dcp-header-cart-flyout-product-list-item__delete dcp-header-cart-flyout-product-list-item-delete']"));

   public static final Target VEHICLE_SELECT = Target.the("vehicle-selector").located(By.xpath("//button[@class='wb-button wb-button--tertiary wb-button--large dcp-vehicle-selector-cta__edit']"));

   public static final Target VEHICLE = Target.the("vehicle").locatedBy("//p[normalize-space()='{0}']");

   public static final Target CLOSE_VEHICLE_SELECT = Target.the("close vehicle").located(By.cssSelector("#app > div.dcp-shop > main > div > div > div.dcp-vehicle-modals > wb-modal > div > div > div > button.wb-round-button.wb-round-button--small"));

   public static final Target PRODUCT_INFO = Target.the("product info").locatedBy("//a[contains(@href, '{0}')]");

   public static final Target ADD_2_BASKET = Target.the("add to basket").located(By.xpath("//button[@class='wb-button wb-button--primary wb-button--large']"));//button[@aria-label="Go to basket"] OC2_GO_TO_BASKET

   public static final Target OC2_GO_TO_BASKET = Target.the("Go to basket").located(By.xpath("//button[@aria-label='Go to basket']"));

   public static final Target OC2_CHECKOUT = Target.the("go to checkout").located(By.xpath("//button[@data-test-id='dcp-cart-content-sum-aside-go-to-checkout__cta']"));

   public static final Target OC2_CHECK_ORDER = Target.the("check order").located(By.xpath("//button[@data-test-id='previous-and-next-nav__next']"));

   public static final Target OC2_ORDER_NOW = Target.the("order now").located(By.xpath("//button[@data-test-id='dcp-cart-overview__place-order']"));


   public static By ACCEPT = By.cssSelector("div > div > div.cmm-cookie-banner__content > div.toggle-buttons-wrapper > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all");

   public static String ACCEPT_CSS = "div > div > div.cmm-cookie-banner__content > div.toggle-buttons-wrapper > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all";

   public static final Target PRODUCT = Target.the("Product Link").locatedBy("//a[normalize-space()='{0}']");

   public static final Target PRODUCT_TITLE = Target.the("Product Title Header").locatedBy("//h1[normalize-space()='{0}']");

   public static final Target ADD_TO_BASKET = Target.the("Add to basket").located(By.xpath("//button[@data-track-click-as='add_to_cart']"));

   public static final Target CLOSE_BASKET = Target.the("Close basket").located(By.xpath("//button[@class='close']"));

   public static final Target GO_TO_SHOPPING_BASKET = Target.the("Go to shopping basket").located(By.xpath("//button[normalize-space()='Go to shopping basket']"));

   public static final Target DELETE_PRODUCT = Target.the("Delete Product").locatedBy("//button[normalize-space()='Delete']");

   public static final Target DELETE_CART_ITEM = Target.the("Delete cart item").locatedBy("//button[@data-ng-click='deleteCartEntry()']");

   public static final Target CANCEL_PRODUCT = Target.the("Cancel Delete Product Link").locatedBy("//button[normalize-space()='Cancel']");

   public static final Target HOME_PAGE = Target.the("Product Link").locatedBy("//a[normalize-space()='Back to homepage']");

   //button[normalize-space()='Skip guide']








}
