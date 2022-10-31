package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pages.ContactPage;
import pages.EventsPage;
import pages.NavMenuPage;
import pages.SingleEventPage;
import utils.BaseTest;

public class IframeExample extends BaseTest{
 // @Test
  public void iframeExample() throws InterruptedException {
	  NavMenuPage menu= new NavMenuPage(driver);
	  menu.navigateTo(menu.contactLink);
	  ContactPage contactPage= new ContactPage(driver);
	  contactPage.zoomMap(contactPage.zoomIn);
	  Thread.sleep(4000);
  }
  
  @Test
  public void iframeExample2() throws InterruptedException {
	  NavMenuPage menu= new NavMenuPage(driver);
	  menu.navigateTo(menu.eventsLink);
	  EventsPage eventsPage= new EventsPage(driver);
	  eventsPage.click(eventsPage.festivalOfOldFilemLinks);
	  Thread.sleep(3000);
	  
	  SingleEventPage sePage=new SingleEventPage(driver);
	  sePage.clickMap();
	  Thread.sleep(4000);
	  
	  //ia id-ul tabului pe care il ai deschis
	 // System.out.println(driver.getWindowHandle());
	  //ia id-urile tuturor taburilor deschise
	  System.out.println("All:"+driver.getWindowHandles());
	  System.out.println("Current:"+driver.getWindowHandle());
	  
	  List<String> browserTabs= new ArrayList<>(driver.getWindowHandles());
	  System.out.println(browserTabs.size());
	  driver.switchTo().window(browserTabs.get(1)); //ma mut pe tabul 1 (cu harta)
	  
	  driver.close(); //inchid harta
	  System.out.println("Size:"+browserTabs.size()); //ele raman inca cate au fost populate initial
	  //System.out.println("Current2:"+driver.getWindowHandle());
	  driver.switchTo().window(browserTabs.get(0));
  
	  sePage.clickMap();
	  Thread.sleep(4000);
  }
}
