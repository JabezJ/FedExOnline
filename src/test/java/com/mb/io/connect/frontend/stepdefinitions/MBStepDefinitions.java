package com.mb.io.connect.frontend.stepdefinitions;

import com.mb.io.connect.backend.services.ServiceEndpoint;
import com.mb.io.connect.frontend.login.Login;
import com.mb.io.connect.frontend.login.Logout;
import com.mb.io.connect.frontend.login.WaitUntilElement;
import com.mb.io.connect.frontend.mb.MBConnectShopPage;
import com.mb.io.connect.frontend.navigation.Navigate;
import com.mb.io.connect.frontend.navigation.NavigateTo;
import com.mb.io.connect.frontend.search.SearchFor;
import com.mb.io.connect.frontend.search.SearchResult;
import com.mb.io.connect.frontend.tasks.*;
import com.mb.io.connect.frontend.tasks.waits.WaitFor;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mb.io.connect.frontend.matchers.TextMatcher.textOf;
import static com.mb.io.connect.frontend.mb.MBConnectShopPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class MBStepDefinitions extends UIInteractionSteps {

    EnvironmentVariables environmentVariables;
    @Steps
    NavigateTo navigateTo;

    @Steps
    private ServiceEndpoint service;

    @Steps
    SearchFor searchFor;

    @Steps
    SearchResult searchResult;

    public static WebDriver wd;
    Map<String, String> renewalTableList;
    String totalPrice;

    @Before
    public void initiate(){
        Cast onlineCast = new OnlineCast();
        OnStage.setTheStage(onlineCast);
    }

    @Then("all the result titles should contain the word {string}")
    public void all_the_result_titles_should_contain_the_word(String expectedTerm) {
        assertThat(searchResult.titles())
                .allMatch(title -> textOf(title).containsIgnoringCase(expectedTerm));
    }

    @Given("{actor} navigates to MB connect shop page")
    public void bobNavigatesToMBConnectShopPage(Actor actor) throws Exception {
        actor.attemptsTo(
                Navigate.toTheConnectShop("germany.base.url",true)
        );
    }

    @And("{actor} logs into MB connect shop")
    public void bobLogsIntoMBconnectshop(Actor actor) throws Exception{
        String email = environmentVariables.getProperty("mb.account.germany.email");
        String pass = environmentVariables.getProperty("mb.account.germany.password");
        actor.attemptsTo(
                Login.withCredentials(email,pass)
        );
    }

    @And("{actor} could log out of the MB connect shop")
    public void customerCouldLogOutOfTheMBConnectShop(Actor actor) throws Exception{
        actor.attemptsTo(
                Logout.ofConnect()
        );
    }

    @Given("{actor} navigates to MB Canadian shop page")
    public void customerNavigatesToMBCanadianShopPage(Actor actor) throws Exception {
        actor.attemptsTo(
                Navigate.toTheConnectShop("canada.base.url",false)
        );
    }

    @And("{actor} logs into MB Canadian connect shop")
    public void customerLogsIntoMBCanadianConnectShop(Actor actor) throws Exception{
        String email = environmentVariables.getProperty("mb.account.canada.email");
        String pass = environmentVariables.getProperty("mb.account.canada.password");
        actor.attemptsTo(
                Login.withCredentials(email,pass)
        );
    }

    @And("{actor} adds the digital service to the shopping cart")
    public void customerNavigatesToTheShoppingCart(Actor actor,List<Map<String, String>> item) {
        // delete existing item in cart
        actor.attemptsTo(
                DeleteCart.items()
        );

        //WaitUntilElement.visible(PRODUCT.of(item.get(0).get("product")).resolveFor(actor));

        // Add new product
        actor.attemptsTo(
                WaitUntil.the(PRODUCT.of(item.get(0).get("product")),isVisible()),
                JavaScriptClick.on(PRODUCT.of(item.get(0).get("product"))),
                WaitUntil.the(PRODUCT_TITLE.of(item.get(0).get("product")),isVisible())
        );

        WaitUntilElement.visible(PRODUCT_TITLE.of(item.get(0).get("product")).resolveFor(actor));
        WaitUntilElement.visible(ADD_TO_BASKET.resolveFor(actor));
        actor.attemptsTo(
                WaitFor.noMoreThan(10).seconds(),
                JavaScriptClick.on(ADD_TO_BASKET)
               // WaitUntil.the(CLOSE_BASKET,isVisible())
        );
        WaitUntilElement.visible(CLOSE_BASKET.resolveFor(actor));
        actor.attemptsTo(
               JavaScriptClick.on(CLOSE_BASKET)
        );

        //Go to shopping basket
        /*
        WaitUntilElement.visible(GO_TO_SHOPPING_BASKET.resolveFor(actor));
        actor.attemptsTo(
                JavaScriptClick.on(GO_TO_SHOPPING_BASKET)
        );
        */

        actor.attemptsTo(
                Navigate.toTheShoppingCart(),
                WaitUntil.the(CONTINUE_SHIPPING,isVisible())
        );
        WaitUntilElement.visible(CONTINUE_SHIPPING);
    }

    @And("{actor} selects canadian invoice address at the Address and delivery")
    public void customerHasCanadianInvoiceAddressAtTheAddressAndDelivery(Actor actor) {
        actor.attemptsTo(
                JavaScriptClick.on(CONTINUE_SHIPPING),
                WaitUntil.the(CONTINUE_PAYMENT,isVisible())
        );
       WaitUntilElement.visible(CONTINUE_PAYMENT);
       // theActorInTheSpotlight().should(seeThat(TheTarget.textOf(MBConnectShopPage.ADDRESS),containsString("Canada")));
    }

    @And("{actor} selects the Payment type")
    public void customerSelectsThePaymentType(Actor actor) throws Exception{
        actor.attemptsTo(
                JavaScriptClick.on(CONTINUE_PAYMENT),
                WaitUntil.the(CONTINUE_SUMMARY,isVisible())
        );
        WaitUntilElement.visible(CONTINUE_SUMMARY);
       // Thread.sleep(5000);
    }

    @And("{actor} moves forward to the Verification and order placement section")
    public void customerMovesForwardToTheVerificationAndOrderPlacementSection(Actor actor) {
        actor.attemptsTo(
                JavaScriptClick.on(CONTINUE_SUMMARY),
                WaitUntil.the(MOVE_BACKWARD_PAYMENT,isVisible())
        );
        WaitUntilElement.visible(MOVE_BACKWARD_PAYMENT);
    }

    @Then("{actor} should see the correct tax amount displayed next to the net price in order")
    public void theCorrectTaxAmountShouldBeDisplayedNextToTheNetPriceInOrder(Actor actor,List<Map<String, String>> taxes) {
        theActorInTheSpotlight().should(seeThat(TheTarget.textOf(MBConnectShopPage.TOTAL_PRICE),containsString("Subtotal")));
        theActorInTheSpotlight().should(seeThat(TheTarget.textOf(MBConnectShopPage.FEDERAL_TAXES),containsString("GST/HST")));
        theActorInTheSpotlight().should(seeThat(TheTarget.textOf(MBConnectShopPage.PROVINCIAL_TAXES),containsString("PST/QST/RST")));
        theActorInTheSpotlight().should(seeThat(TheTarget.textOf(MBConnectShopPage.TOTAL_PRICE_WITH_TAX),containsString("taxes included")));
    }

    @Given("taxes are retrieved from the backend")
    public void taxesAreRetrievedFromTheBackend() throws Exception{
        String outhUrl = service.getUrlEndpoint("oauth");
        Map<String,String> query = new HashMap<>();
        query.put("client_id", "backend_trusted_client");
        query.put("client_secret", "secret" );
        query.put("grant_type", "client_credentials" );
        query.put("username", environmentVariables.getProperty("mb.account.canada.email") );
        query.put("password", environmentVariables.getProperty("mb.account.canada.password") );
        Response authResponse = service.callHTTPPost(outhUrl, query,null);
        System.out.println("Response status-code: "+ authResponse.statusCode());
        System.out.println("access_token: "+ authResponse.jsonPath().get("access_token"));
        String access_token = authResponse.jsonPath().get("access_token");

        String cartUrl = service.getUrlEndpoint("cart");
        Map<String,String> cartQuery = new HashMap<>();
        cartQuery.put("checkout", "true");
        cartQuery.put("fields", "FULL" );
        cartQuery.put("lang", "en_ca" );
        Response cartResponse = service.callHTTPGet(cartUrl,null,cartQuery,access_token);
        System.out.println("Response status-code: "+ cartResponse.statusCode());
        System.out.println("taxes: "+ cartResponse.jsonPath().get("taxValues"));

    }

    @Given("a Canadian customer purchases digital services from connect shop")
    public void aCanadianCustomerPurchasesDigitalServicesFromConnectShop(List<Map<String, String>> userId) {

    }

    @When("^the customer checks out the digital services with order value of (.*)$")
    public void theCustomerChecksOutTheDigitalServicesWithOrderValueOfTotalPrice(String price) {
        totalPrice = price;
    }

    @Then("^the correct value of (.*) and (.*) are calculated$")
    public void theCorrectValueOfFederalTaxesAndProvincialTaxesAreCalculated(String federal,String provincial) throws Exception {
        String outhUrl = service.getUrlEndpoint("oauth");
        Map<String,String> query = new HashMap<>();
        query.put("client_id", "backend_trusted_client");
        query.put("client_secret", "secret" );
        query.put("grant_type", "client_credentials" );
        query.put("username", environmentVariables.getProperty("mb.account.canada.email") );
        query.put("password", environmentVariables.getProperty("mb.account.canada.password") );
        Response authResponse = service.callHTTPPost(outhUrl, query,null);
        System.out.println("Response status-code: "+ authResponse.statusCode());
        System.out.println("access_token: "+ authResponse.jsonPath().get("access_token"));
        String access_token = authResponse.jsonPath().get("access_token");

        String cartUrl = service.getUrlEndpoint("cart");
        Map<String,String> cartQuery = new HashMap<>();
        cartQuery.put("checkout", "true");
        cartQuery.put("fields", "FULL" );
        cartQuery.put("lang", "en_ca" );
        Response cartResponse = service.callHTTPGet(cartUrl,null,cartQuery,access_token);
        System.out.println("Response status-code: "+ cartResponse.statusCode());
        System.out.println("taxes: "+ cartResponse.jsonPath().get("taxValues"));

        MatcherAssert.assertThat(cartResponse.jsonPath().get("totalPrice.formattedValue"), equalTo(totalPrice));
        MatcherAssert.assertThat(cartResponse.jsonPath().get("taxValues.formattedValue[0]"), equalTo(federal));
        MatcherAssert.assertThat(cartResponse.jsonPath().get("taxValues.formattedValue[1]"), equalTo(provincial));
       // MatcherAssert.assertThat(cartResponse.jsonPath().get("totalPriceWithTax.formattedValue"), equalTo(totalPrice));

    }

    @Given("{actor} navigates to MB Swiss OC2 connect shop page")
    public void customerNavigatesToMBSwissOCConnectShopPage(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheOC2ConnectShop("swiss.base.url",true)
        );
    }

    @And("{actor} logs into MB Swiss OC2 connect shop")
    public void customerLogsIntoMBSwissOCConnectShop(Actor actor) throws Exception{
        String email = environmentVariables.getProperty("mb.account.swiss.email");
        String pass = environmentVariables.getProperty("mb.account.swiss.password");
        actor.attemptsTo(
                Login.intoOC2ConnectShop(email,pass)
        );
    }

    @When("{actor} adds the digital service to the OC2 connect shopping cart")
    public void customerAddsTheDigitalServiceToTheOCConnectShoppingCart(Actor actor,List<Map<String, String>> item) {

        WaitUntilElement.visible(VEHICLE_SELECT.resolveFor(actor));
        actor.attemptsTo(
                WaitFor.noMoreThan(15).seconds(),
                DeleteOC2Cart.items()
        );
        actor.attemptsTo(
                SelectVehicle.withVIN(item.get(0).get("vehicle"))
        );
        //BrowseTheWeb.as(actor).getDriver().navigate().refresh();
        Actions action = new Actions(BrowseTheWeb.as(actor).getDriver());
        action.sendKeys(Keys.ESCAPE);
        WaitUntilElement.visible(PRODUCT_INFO.of(item.get(0).get("product")).resolveFor(actor));

        actor.attemptsTo(
                AddProductToCart.byName(item.get(0).get("product"))
        );


    }

    @Given("{actor} navigates to MB french OC2 connect shop page")
    public void customerNavigatesToMBFrenchOCConnectShopPage(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheOC2ConnectShop("france.base.url",true)
        );
    }

    @And("{actor} logs into MB french OC2 connect shop")
    public void customerLogsIntoMBFrenchOCConnectShop(Actor actor) throws Exception{
        String email = environmentVariables.getProperty("mb.account.france.email");
        String pass = environmentVariables.getProperty("mb.account.france.password");
        actor.attemptsTo(
                Login.intoOC2ConnectShop(email,pass)
        );
    }

    @Then("the {actor} should be able to check out the shopping cart")
    public void theCustomerShouldBeAbleToCheckOutTheShoppingCart(Actor actor) {
        actor.attemptsTo(
                CheckOutOC2Cart.items()
        );
    }

    @And("the {actor} should be able to verify and confirm the order")
    public void theCustomerShouldBeAbleToVerifyAndConfirmTheOrder(Actor actor) {

        WaitUntilElement.visible(OC2_ORDER_NOW.resolveFor(actor));

    }

    @Given("{actor} navigates to OC2 connect shop page of {string} rollout market")
    public void customerNavigatesToOCConnectShopPageOfRolloutMarket(Actor actor, String market) {
        actor.attemptsTo(
                Navigate.toTheOC2ConnectShop(market+".base.url",true)
        );
    }

    @And("{actor} logs into OC2 connect shop of {string} rollout market")
    public void customerLogsIntoOCConnectShopOfRolloutMarket(Actor actor, String market) throws Exception {
        String email = environmentVariables.getProperty("mb.account."+market+".email");
        String pass = environmentVariables.getProperty("mb.account."+market+".password");
        actor.attemptsTo(
                Login.intoOC2ConnectShop(email,pass)
        );
    }

    @And("{actor} logsout of OC2 connect shop")
    public void customerLogsOutofOCConnectShop(Actor actor) throws Exception {
        actor.attemptsTo(
                Logout.ofOC2ConnectShop()
        );
        WaitUntilElement.visible(OC2_USER.resolveFor(actor));
    }

    @Given("a Swiss customer purchases digital services from OC2 connect shop")
    public void aSwissCustomerPurchasesDigitalServicesFromOCConnectShop(List<Map<String, String>> userId) {
    }

    @And("the available products are listed in the product overview page")
    public void theAvailableProductsAreListedInTheProductOverviewPage() throws Exception {
        String outhUrl = service.getUrlEndpoint("oauth");
        Map<String,String> query = new HashMap<>();
        query.put("client_id", "backend_trusted_client");
        query.put("client_secret", "secret" );
        query.put("grant_type", "client_credentials" );
        query.put("username", environmentVariables.getProperty("mb.account.swiss.email") );
        query.put("password", environmentVariables.getProperty("mb.account.swiss.password") );
        Response authResponse = service.callHTTPPost(outhUrl, query,null);
        System.out.println("Response status-code: "+ authResponse.statusCode());
        System.out.println("access_token: "+ authResponse.jsonPath().get("access_token"));
        String access_token = authResponse.jsonPath().get("access_token");

        String productUrl = service.getUrlEndpoint("product");
        //fields=FULL&fin=WDD1770461Z000037&lang=en_CH
        Map<String,String> productQuery = new HashMap<>();
        productQuery.put("fields", "FULL" );
        productQuery.put("fin", "WDD1770461Z000037" );
        productQuery.put("lang", "en_CH" );
        Response productResponse = service.callHTTPGet(productUrl,null,productQuery,access_token);
        System.out.println("Response status-code: "+ productResponse.statusCode());
        System.out.println("Available product: "+ productResponse.jsonPath().get("products[0].name"));
    }
}

