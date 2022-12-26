package com.selenium.instagram;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InstaLoginAndDownload {
	public static void main(String[] args) throws InterruptedException, IOException {
		// Initializing all the classes
		
		getUserAndPass get = new getUserAndPass();
		elementWaitMethod eWait = new elementWaitMethod();
		GetAllImages gg = new GetAllImages();
		
		
		//Getting the user name and password form the properties File
		
		String values[];
		values = get.giveUserNameAndPassword("insta.properties");
		System.out.println("Got the Username and Password form the Properties File");
		System.out.println("Launching Steps To Download");

		// Initializing the drivers
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Implementing Implicit wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Going to Instagram and Logging In
		
		driver.get("https://www.instagram.com/");
		eWait.elementWaitAndSendKeys(driver, By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input"), values[0]);
		eWait.elementWaitAndSendKeys(driver, By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input"), values[1]);
		eWait.elementClick(driver, By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div"));
		
		//Selecting the Search bar and searching for the profile
		
		eWait.elementWaitAndClick(driver, By.xpath(
				"/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div/a/div"));
		eWait.elementWaitAndSendKeys(driver, By.xpath(
				"/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div/input"),
				"************profile name here ************\r\n" + 
				"\r\n" + 
				"");
		eWait.elementWaitAndClick(driver, By.xpath(
				"/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div/a/div/div[2]/div[1]/div/div"));
		
		WebElement count = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/section/main/div/header/section/ul/li[1]/div/span/span"));
		
		//Selecting the image block and downloading the images
		int c = Integer.parseInt(count.getText()); /* count the no of posts*/
		
		boolean result = PresentOrNot.isElementPresent(driver, "/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/section/main/div/div[2]/article");
		while(c>0) {
			Thread.sleep(1000);
			
			if(result ==true) {
			    gg.downloadImages(driver, By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/section/main/div/div[2]/article"));
			}else {
				gg.downloadImages(driver, By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/section/main/div/div[3]/article"));				
			}
			c=c-12;
		}
			

	}
}
