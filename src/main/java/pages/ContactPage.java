package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class ContactPage extends SeleniumWrappers {

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public By zoomIn=By.cssSelector("button[title='Zoom in']");
	public By iframe=By.tagName("iframe");

    public void zoomMap(By locator) {
    	//trebuie sa facem switch catre iframe(este un dom in alt dom)
    	driver.switchTo().frame(getElement(iframe));
    	click(locator);
    }
}
