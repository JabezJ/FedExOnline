package com.fedex.com.frontend.stepdefinitions;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.After;
import org.junit.Before;

public class SerenityCucumberAdaptor {

    @Before
    public void configureScreenplayActors() {

    }
    @ParameterType(".*")
    public Actor actor(String actorname){
        return OnStage.theActorCalled(actorname);
    }

    @After
    public void tidyUp() {

    }
}
