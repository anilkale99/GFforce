package com.gfforce.pom.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.Before;

public class ContextSteps {

	   private static boolean initialized = false;

	   private WebDriver driver;

	   //@Before
	   public void setUp() throws Exception {
	      if (!initialized) {
	         // initialize the driver
	    	  
	    	  ChromeOptions options = new ChromeOptions();
		       //options.setExperimentalOption("prefs", chromePrefs);
		       options.addArguments("--test-type");
		       options.addArguments("--disable-extensions"); //to disable browser extension popup
		       DesiredCapabilities cap = DesiredCapabilities.chrome();
		       cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		       cap.setCapability(ChromeOptions.CAPABILITY, options);
		       
//	    	  DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ()    ;   
//	    	  handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
	    	  System.setProperty("webdriver.chrome.driver", "src/test/resources/lib/chromedriver_win32_forCh_B86/chromedriver.exe");
	          driver = new ChromeDriver(options);
	          
	         initialized = true;
	      }
	   }

	   public WebDriver getDriver() {
	      return driver;
	   }
	}