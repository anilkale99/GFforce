package com.gfforce.steps.common;

import com.gfforce.pom.common.ContextSteps;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    private ContextSteps contextSteps;
    WebDriver driver;

    // PicoContainer injects class ContextSteps
    public Login(ContextSteps contextSteps) throws Exception {
        contextSteps.setUp();
        driver = contextSteps.getDriver();
    }

    @Given("User is on application home page")
    public void userIsAtHomePage() throws InterruptedException {
        driver.get("https://barclays.dev-givingforce.com/");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
    }


}
