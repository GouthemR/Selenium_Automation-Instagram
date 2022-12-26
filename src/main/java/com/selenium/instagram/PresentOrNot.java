package com.selenium.instagram;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PresentOrNot {
	public static boolean isElementPresent(WebDriver driver,String locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
			return true;
		}catch(Throwable t) {
	        return false;
		}
	}
}
