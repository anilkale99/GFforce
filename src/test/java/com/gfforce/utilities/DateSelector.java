package com.gfforce.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DateSelector {

    public static void selectDate(WebDriver driver, String date, String locatorValue) {
        
		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='start_dts']")).click();
		} catch (Exception e) {
			try {
				driver.findElement(By.xpath("//input[@id='apply_by_dts']")).click();
			} catch (Exception e1) {
				driver.findElement(By.xpath("//input[@id='event_dts']")).click();
			}
		}finally{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
        String monthYearTextLocator = "//*[@class='datepicker-days']/table/thead/tr[2]/th[2]";
        String nextButton = "//*[@class='datepicker-days']/table/thead/tr[2]/th[3]";
        String allRowsLocator = "//*[@class='datepicker-days']/table/tbody/tr";
        String day = date.substring(0,2);
        String monthYear = date.substring(3);
        String monthYearOnCalendar = driver.findElement(By.xpath(monthYearTextLocator)).getText();

        while(! monthYear.equals(monthYearOnCalendar)) {
            driver.findElement(By.xpath(nextButton)).click();
            monthYearOnCalendar = driver.findElement(By.xpath(monthYearTextLocator)).getText();

        }
        List<WebElement> allRows = driver.findElements(By.xpath(allRowsLocator));
        mainLoop:
        for (WebElement row: allRows) {
            List<WebElement> allCols = row.findElements(By.tagName("td"));
            for (WebElement col: allCols) {
                String dayInCol = col.getText();
                if(day.equals(dayInCol)){
                    String attr = col.getAttribute("class");
                    if(attr.equals("day") || attr.equals("active day")){
                        col.click();
                        break mainLoop;
                    }

                }
            }
        }
    }
}
