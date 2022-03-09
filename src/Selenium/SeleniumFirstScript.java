/*
*	1. Go to https://www.webstaurantstore.com/
*	2. Search for 'stainless work table'.
*	3. Check the search result ensuring every product item has the word 'Table' in its
*	title.
*	4. Add the last of found items to Cart.
*	5. Empty Cart.
*/

package Selenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class SeleniumFirstScript {
	
 public static void main(String[] args) throws InterruptedException {
	 
	 String webStoreURL = "https://www.webstaurantstore.com/";
	 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\bwige\\eclipse-workspace\\Test\\Resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get(webStoreURL);  //Open Webstore 
	
	driver.manage().window().maximize();	//Maximize to expand object vis.
	
	String readURL = driver.getCurrentUrl();  //Check URL of webpage
	
	System.out.println(readURL); //record URL for posterity
	
	if(readURL.contains(webStoreURL))	//confirm we are where we want to be
		System.out.println("Store Page Loaded");
	
	driver.findElement(By.id("searchval")).sendKeys("stainless work table");	//Type search term
	driver.findElement(By.xpath("//button [@value='Search' and @type= 'submit']")).click();  //click Search
	Thread.sleep(2000); //TODO change sleeps to waits
	
	//3. Check the search result ensuring every product item has the word 'Table' in its
	//	title
	
	WebElement matchResults = driver.findElement(By.id("product_listing"));  //results
	 List<WebElement> c = matchResults.findElements(By.xpath("./child::*")); //child object on page 1
	System.out.println(c.size()+" Results per Page");  //Number of items to check
	
	//TODO Turn this into a for loop...
	System.out.println("--------------->Page 1 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 2']")).click();
	Thread.sleep(2000); 												//TODO change sleeps to waits
	System.out.println("--------------->Page 2 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 3']")).click();
	Thread.sleep(2000);
	System.out.println("--------------->Page 3 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 4']")).click();
	Thread.sleep(2000);
	System.out.println("--------------->Page 4 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 5']")).click();
	Thread.sleep(2000);
	System.out.println("--------------->Page 5 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 6']")).click();
	Thread.sleep(2000);
	System.out.println("--------------->Page 6 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 7']")).click();
	Thread.sleep(2000);
	System.out.println("--------------->Page 7 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 8']")).click();
	Thread.sleep(2000);
	System.out.println("--------------->Page 8 Results<-------------");
	checkResultsForTable(driver);  
	driver.findElement(By.xpath("//a [@aria-label='Page 9']")).click();
	System.out.println("--------------->Page 9 Results<-------------");
	checkResultsForTable(driver);  
	Thread.sleep(2000);//TODO change sleeps to waits
	
	//4. Add the last of found items to Cart.
	 WebElement matchResultsFinal = driver.findElement(By.id("product_listing"));  //results
	 List<WebElement> cFinal = matchResultsFinal.findElements(By.xpath("./child::*"));
	 int finalResultIndex = cFinal.size()-1;
	 System.out.println("finalResultIndex; "+finalResultIndex);
	 WebElement finalItemToBuy = cFinal.get(finalResultIndex);
	 System.out.println("finalItemToBuy: "+finalItemToBuy.getText());
	 finalItemToBuy.findElement(By.xpath(".//input[@value=\"Add to Cart\"]")).click();
			
 //5. Empty Cart.
	 Thread.sleep(10000); //waiting for item to load into cart //TODO change sleeps to waits
	 driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div[3]/a[2]/span[1]/span")).click();  //click on cart button.
	 
	Thread.sleep(5000);//TODO change sleeps to waits
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[3]/form/div/div[1]/div/a")).click(); //click Empty Cart button
	
	Thread.sleep(5000); //TODO change sleeps to waits
	driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[3]/button[1]")).click();	//Confirm Delete
	
	System.out.println("End of the Webstaurantstore Test.");
	
//	driver.close();  //Instructions unclear... maybe close Chrome... later :)
 }
 
 public static void  checkResultsForTable(WebDriver driver) {
	 WebElement matchResults = driver.findElement(By.id("product_listing"));  //results
	 List<WebElement> c = matchResults.findElements(By.xpath("./child::*"));
	 int count = 1;
	 for ( WebElement i : c ) { 
		 if(i.getText().contains("Table"))
			 System.out.println("Result "+count+" Contains 'Table'");
		 else {
			 System.out.println("-----------------Error Found in Result: No Table------------");
			 System.out.println("Item: "+i.getText());
		 }
		 count++;
	 }
 	}
}
