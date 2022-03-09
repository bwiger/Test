
package com.ex1;

import java.io.File;

import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import graphql.Assert;

public class TestLibrariesSetup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseURL = "https://www.google.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bwige\\eclipse-workspace\\Test\\Resources\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		//driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String readURL = driver.getCurrentUrl();
		System.out.println("Resultant URL = "+readURL);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title = "+pageTitle);
		
		if(readURL.contains(baseURL))
		System.out.println("Great Success!");
		
		else
			System.out.println("Error: URL doesn't match expected: "+baseURL);
		
	}

}
 