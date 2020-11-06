package com.gfforce.pom.pages;

import org.openqa.selenium.WebDriver;

import com.gfforce.pom.common.BaseAction;
import com.gfforce.pom.common.ContextSteps;

public class MatchedFundRaising extends BaseAction{
	public WebDriver driver;
	
	String eventNameLoc= "";
    
    public MatchedFundRaising(ContextSteps contextSteps){
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

}
