package com.mb.io.connect;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/connect/MB_Connect_Shop_OC2_INT1_FR.feature"
)
public class BDD_INT1_TestSuiteRunner {}
