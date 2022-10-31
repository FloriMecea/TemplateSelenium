package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest{

	//@Test
	public void jsExecutorScroll() throws InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		//JavaScript class scroll
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		
		//Actions class scroll bar
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 2000).perform();
		Thread.sleep(2000);
	}
	
	//@Test
	public void scrollToElement() throws InterruptedException {
     JavascriptExecutor jse=(JavascriptExecutor) driver;
     Actions action=new Actions(driver);
 	 WebElement signUpButton= driver.findElement(By.cssSelector("input[value='Sign up']"));

 	//JavaScript class scroll - dar aici e acoperit de sticky header de sus si nu se prea vede
	//	jse.executeScript("arguments[0].scrollIntoView();",signUpButton);
		Thread.sleep(3000);
		
		//Actions class move to element	
		action.moveToElement(signUpButton).perform();
		Thread.sleep(3000);
	}

	@Test
	public void scrollTopAndDown() throws InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
	//	window -browser
	//	document -in interiorul browsului, aplicatia
	//	argument-element din interiorul documentului/aplicatiei
		
		//scroleaza pe toata inaltimea in jos
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
		Thread.sleep(3000);
		//scroleaza pe toata inaltimea in sus
		jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(3000);
	}
	
	@Test
	public void jsFunctionCall() throws InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
	
	    System.out.println(driver.getTitle());
	    
	    jse.executeScript("window.schimbTitlu=function(){document.title='Alt titlu'};"
	    +"window.schimbTitlu.call()");
	    
	    System.out.println(driver.getTitle());
		Thread.sleep(3000);
	    
	}
}
