package com.selenium.instagram;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class elementWaitMethod {
	public void elementWait(WebDriver driver,By by) {
		driver = new ChromeDriver();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	public void elementWaitAndSendKeys(WebDriver driver,By by,String keys) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(keys);
	}
	public void elementClick(WebDriver driver,By by) {
        driver.findElement(by).click();
	}
	public void elementWaitAndClick(WebDriver driver,By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	public WebElement getElementFromBlock(WebDriver driver,By by) {
		WebElement block = driver.findElement(by);
		return block;
	}
	public void scrollUsingPostNumber(WebDriver driver,By by) throws InterruptedException {
		WebElement noOfPosts = driver.findElement(by);
		int times = Integer.parseInt(noOfPosts.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (times > 0) {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			times = times / 12;
		}
	}
}
