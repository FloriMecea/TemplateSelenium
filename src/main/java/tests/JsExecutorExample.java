package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;

public class JsExecutorExample extends BaseTest {

	//@Test
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://www.emag.ro/'")  ;//Object...arga
    
		//cele 2 de mai jos sunt la fel
	    driver.navigate().back();
	    jse.executeScript("window.history.go(-1)");
	    
		//cele 2 de mai jos sunt la fel
	    driver.navigate().forward();
	    jse.executeScript("window.history.forward(-1)");
	    
	  //1. cele 4 de mai jos sunt la fel: e bine sa folosim selenium, apoi clase speciale (gen Actions) si ultima oara java script executor
	    driver.navigate().refresh();
	   //2 
	    jse.executeScript("window.history.go(0)");
	    
	    //3. si asta tot refresh face ca si cele 2 de mai sus
	    Actions action = new Actions(driver);
	    action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	    
	    //4
	    driver.navigate().to(driver.getCurrentUrl());
	
	  /*  
	    jse.executeScript("window.history.go(0)"); //browser in sine
	    jse.executeScript("document.getElement..)"); //instanta de browser si aplicatia
	    jse.executeScript("arguments(0)",null);
	  */
	}
	
	@Test
	public void example2() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NavMenuPage menu= new NavMenuPage(driver);
		
		/*
		//alternativa pt click in js 
		jse.executeScript("arguments[0].click()", menu.getElement(menu.searchIcon));
	   //alternativa pt sendKeys in js 
		jse.executeScript("arguments[0].value='cooking'", menu.getElement(menu.searchField));
		//alternativa pt click in js 
		jse.executeScript("arguments[0].click()", menu.getElement(menu.searchIcon));
			
		//cele 3 de sus se pot scrie asa dar e greu de citit si predispus la erori
		jse.executeScript("arguments[0].click();arguments[0].value='cooking';arguments[0].click()", menu.getElement(menu.searchIcon),menu.getElement(menu.searchField));
				
	  */
		//varianta a doua pt ce este mai sus
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");

		//alternativa pt is displayed
		//jse.executeScript("document.getElementsByClassName('post_title')[0].checkVisibility");
		
		Thread.sleep(3000);
		//alternativa pt getText
		String bookTitle=  jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].innerHTML").toString();
		System.out.println(bookTitle);
		
		
		//alternativa pt get page title
		String pageTitle=  jse.executeScript("return document.title").toString();
		System.out.println(pageTitle);
		
		//alternativa pt linkul curent al paginii
		String pageURL=  jse.executeScript("return document.URL").toString();
		System.out.println(pageURL);
		
		
		//alternativa pt isSelected -intoarce un boolean
		//jse.executeScript("document.getElementById('rememberme').checked");
	
		//alternativa pentru hover (moveToElement din clasa Actions)
				String javaScriptHover = "var obiect = document.createEvent('MouseEvent');"
						+ "obiect.initMouseEvent('mouseover', true);"
						+ "arguments[0].dispatchEvent(obiect);";
				
				jse.executeScript(javaScriptHover, menu.getElement(menu.blogLink));
				Thread.sleep(3000);
				jse.executeScript(javaScriptHover, menu.getElement(menu.abouttLink));
	}
}
