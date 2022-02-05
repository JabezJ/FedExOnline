package com.fedex.com.frontend.stepdefinitions;

import com.fedex.com.frontend.tasks.Login;
import com.fedex.com.frontend.tasks.Logout;
import com.fedex.com.frontend.tasks.Navigate;
import com.fedex.com.frontend.waits.WaitFor;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

import static com.fedex.com.frontend.pageObjects.FedexOnlinePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.stateOf;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class FedexStepDefinitions extends UIInteractionSteps {

    EnvironmentVariables environmentVariables;

    @Before
    public void initiate(){
        Cast onlineCast = new OnlineCast();
        OnStage.setTheStage(onlineCast);
    }

    @Given("{actor} navigates to fedex.com portal homepage")
    public void customerNavigatesToFedexComPortalAccount(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheOnlinePortal("fedex.com.base.url")
        );
    }

    @When("{actor} attempts to log into fedex.com portal account")
    public void customerLogsIntoFedexComPortalAccount(Actor actor) throws Exception {
        String email = environmentVariables.getProperty("fedex.account.user");
        String pass = environmentVariables.getProperty("fedex.account.password");
        System.out.println(email);
        System.out.println(pass);
        actor.attemptsTo(
                Login.intoFedExOnline(email,pass)
        );
    }

    @Then("{actor} should be successfully logged in")
    public void customerShouldBeSuccessfullyLoggedIn(Actor actor) {
        String name = environmentVariables.getProperty("fedex.account.name");
        actor.should(seeThat(TheTarget.textOf(UserOption.of(name)),containsString(name)));
    }

    @When("{actor} attempts to log out of fedex.com portal account")
    public void customerAttemptsToLogOutOfFedexComPortalAccount(Actor actor) throws Exception {
        actor.attemptsTo(
                Logout.ofFedExOnline()
        );
    }

    @Then("{actor} should be successfully logged out")
    public void customerShouldBeSuccessfullyLoggedOut(Actor actor) {
        actor.attemptsTo(
            JavaScriptClick.on(LogInMenu)
        );
        actor.should(seeThat(stateOf(LogIn),isVisible()));
    }

    @And("{actor} navigates to Calculate FedEx® shipping rates page")
    public void customerNavigatesToCalculateFedExShippingRatesPage(Actor actor) {
        actor.attemptsTo(
                JavaScriptClick.on(FDXCube.of("RATE & TRANSIT TIMES"))
        );
    }

    @When("{actor} calculates FedEx® shipping rates based on the following shipment attributes")
    public void customerCalculatesFedExShippingRatesBasedOnTheFollowingShipmentAttributes(Actor actor,List<Map<String, String>> shipment) {
        actor.attemptsTo(
                JavaScriptClick.on(FDXCube.of("RATE & TRANSIT TIMES")),
                WaitFor.noMoreThan(3).seconds()
        );
        actor.attemptsTo(
                Check.whether(the(FromAdd),isVisible())
                        .andIfSo(
                                Enter.theValue(shipment.get(0).get("From")).into(FromAdd).thenHit(Keys.ARROW_DOWN),
                                JavaScriptClick.on(UserOption.of(shipment.get(0).get("From"))),
                                Enter.theValue(shipment.get(0).get("FromPostcode")).into(FromPostcode).thenHit(Keys.TAB),

                                Enter.theValue(shipment.get(0).get("To")).into(ToAdd).thenHit(Keys.ARROW_DOWN),
                                JavaScriptClick.on(UserOption.of(shipment.get(0).get("To"))),

                                Enter.theValue(shipment.get(0).get("ToPostcode")).into(ToPostcode).thenHit(Keys.TAB),

                                WaitFor.noMoreThan(3).seconds(),
                                WaitUntil.the(ContinueEntry,isVisible()).forNoMoreThan(5).seconds(),
                                JavaScriptClick.on(ContinueEntry),

                               //Package type selection
                              /*  JavaScriptClick.on(PackageType),
                                JavaScriptClick.on(PackOption.of(shipment.get(0).get("PackageType"))),
                                JavaScriptClick.on(PackageQuantity),
                                JavaScriptClick.on(PackOption.of(shipment.get(0).get("PackageQuantity"))),
                               */

                                Enter.theValue(shipment.get(0).get("PackageWeight")).into(PackageWeight),
                                JavaScriptClick.on(PackageDetailsSubmit)
                        )
        );
    }

    @Then("{actor} should get list of calculated rates and delivery dates for shipment")
    public void customerShouldGetListOfCalculatedRatesAndDeliveryDatesForShipment(Actor actor) {
        actor.attemptsTo(
                WaitFor.noMoreThan(3).seconds(),
                WaitUntil.the(CalculatedRateSummary,isVisible()).forNoMoreThan(5).seconds()
                );
        actor.should(seeThat(TheTarget.textOf(CalculatedRateSummary),containsString("Here are the rates and delivery dates for shipments")));

    }

    @Given("{actor} would like to utilize digital postal services from fedex.com")
    public void customerWouldLikeToUtilizeDigitalPostalServicesFromFedexCom(Actor actor) {
    }

    @Then("{actor} should see the digital postal services to calculate,track and ship")
    public void customerShouldSeeTheDigitalPostalServicesToCalculateTrackAndShip(Actor actor) {
        actor.should(seeThat(stateOf(FDXCube.of("RATE & TRANSIT TIMES")),isVisible()));
        actor.should(seeThat(stateOf(FDXCube.of("TRACK")),isVisible()));
        actor.should(seeThat(stateOf(FDXCube.of("SHIP")),isVisible()));
    }

    @And("{actor} should see the tracking service selected as default")
    public void customerShouldSeeTheTrackingServiceSelectedAsDefault(Actor actor) {
        actor.should(seeThat(stateOf(TrackingNumber),isVisible()));
        actor.should(seeThat(stateOf(Track),isVisible()));
    }

    @When("{actor} attempts to log into fedex.com portal account with credentials {string} and {string}")
    public void customerAttemptsToLogIntoFedexComPortalAccountWithCredentialsAnd(Actor actor,String user, String password) throws Exception {
        System.out.println(user);
        System.out.println(password);
        actor.attemptsTo(
                Login.intoFedExOnline(user,password)
        );
    }

    @Then("{actor} should not be logged in")
    public void customerShouldNotBeLoggedIn(Actor actor) {
        actor.should(seeThat(stateOf(InvalidCredentials),isVisible()));
        actor.should(seeThat(TheTarget.textOf(InvalidCredentials),containsString("Login incorrect. Either the user ID or password combination is incorrect, or the account has been locked. Please try again or reset your password.")));
    }

    @And("{actor} navigates to Calculate FedEx® shipment page")
    public void customerNavigatesToCalculateFedExShipmentPage(Actor actor) {
        actor.attemptsTo(
                JavaScriptClick.on(FDXCube.of("SHIP"))
        );
    }

    @When("{actor} attempts to track the postal by tracking number {string}")
    public void customerAttemptsToTrackThePostalByTrackingNumber(Actor actor,String trackingNum) {
        actor.should(seeThat(stateOf(TrackingNumber),isVisible()));
        actor.should(seeThat(stateOf(Track),isVisible()));
        actor.attemptsTo(
                Enter.theValue(trackingNum).into(TrackingNumber).thenHit(Keys.TAB),
                JavaScriptClick.on(Track)
        );

    }

    @Then("{actor} should be able to see the shipment status")
    public void customerShouldBeAbleToSeeTheShipmentStatus(Actor actor) {

    }
}

