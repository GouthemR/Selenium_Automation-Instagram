package com.selenium.instagram;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAllImages {
	
	
	public void downloadImages(WebDriver driver,By by) throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		elementWaitMethod eWait = new elementWaitMethod();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		WebElement block = eWait.getElementFromBlock(driver, by);
		List<WebElement> imgTag = block.findElements(By.tagName("img"));
	
			
		for (WebElement img : imgTag) {

			System.out.println("Downloaded the images from the URL : " + img.getAttribute("src"));
			URL url = new URL(img.getAttribute("src"));
			BufferedImage image = null;
			String name = img.getAttribute("src").toString();
			String finalname = name.substring(name.length()-25);
			image = ImageIO.read(url);
			
			ImageIO.write(image, "jpg", new File(
					 "Images/"+finalname  +".jpg"));
			
		
		
		}
	}
}
