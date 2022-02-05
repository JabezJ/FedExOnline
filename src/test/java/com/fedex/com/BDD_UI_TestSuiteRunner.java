package com.fedex.com;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/connect/OC2/run/FedEx_HomePage.feature"
)
public class BDD_UI_TestSuiteRunner {}
