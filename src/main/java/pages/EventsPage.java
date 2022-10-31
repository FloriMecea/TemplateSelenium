package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class EventsPage extends SeleniumWrappers{

	public EventsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public By festivalOfOldFilemLinks=By.linkText("Festival of Old Films");

}
