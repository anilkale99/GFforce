package com.gfforce.steps.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.utilities.PropertiesOperation;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private ContextSteps contextSteps;
	WebDriver driver;
	
	public Hooks(ContextSteps contextSteps) throws Exception {
		contextSteps.setUp();
		driver = contextSteps.getDriver();
		
	}
	@Before
    public void beforeScenario() throws InterruptedException{
        System.out.println("This will run before the Scenario");
        driver.get(PropertiesOperation.getRadicalValueBykey("url"));
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
    } 
 
    @After
    public void afterScenario() throws InterruptedException{
        System.out.println("This will run after the Scenario");
        Thread.sleep(30000);
        driver.quit();
        ContextSteps.initialized=false;
    }

}
