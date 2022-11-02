package utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//setam driverul si il initializam si ulterior il pasam spre base test
public class Driver {
	
	//avem nevoie doar pt rulare paralela pe chrome si firefox gen
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

	public WebDriver initDriver(String browser) {
	
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver.set(new ChromeDriver()); acum folosim pe cea de jos
			driver.set(new ChromeDriver(getChromeOptions()));
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//set window size
			//driver.get().manage().window().setSize(new Dimension(800,600));
			
			
			long chromeId=Thread.currentThread().getId();
			System.out.println("Chrome--->Thread id="+chromeId);
			return driver.get();
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
	       // driver.set(new FirefoxDriver());
			driver.set(new FirefoxDriver(getFirefoxOptions()));
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			long firefoxId=Thread.currentThread().getId();
			System.out.println("Firefox--->Thread id="+firefoxId);
			return driver.get();
		} 	
	 else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();;
        //driver.set(new EdgeDriver());
		
		driver.set(new EdgeDriver(getEdgeOptions()));
		
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		long edgeId=Thread.currentThread().getId();
		System.out.println("Edge--->Thread id="+edgeId);
		return driver.get();
	}
		
		return driver.get();
	}
	
	
	public static ChromeOptions getChromeOptions() {
		
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--disable-infobars"); // sa dea jos cu "chrome is being controled..."
		chromeOption.addArguments("--disable-gpu"); //relevant pt headless
		chromeOption.addArguments("--disable-dev-shm-usage"); //relevant pt ci-cd
		chromeOption.addArguments("--no-sandbox");             //relevant pt ci-cd
		chromeOption.addArguments("--disable-extensions");
		
		//chromeOption.addArguments("--headless");  //nu mai vedem instanta de browser dar ruleaza testele
		//cand se rulease headless fereastra porneste cea mai mica versiune 800, 600 in spate
		
		chromeOption.addArguments("--window-size=1580, 1280");
		
		return chromeOption;
		
	}
	
	public static FirefoxOptions getFirefoxOptions() {

		FirefoxOptions firefoxOption= new FirefoxOptions();
		firefoxOption.addArguments("--disable-gpu"); //relevant pt headless
		firefoxOption.addArguments("--disable-extensions");
		
		firefoxOption.addArguments("--headless");  //nu mai vedem instanta de browser dar ruleaza testele
		//cand se rulease headless fereastra porneste cea mai mica versiune 800, 600 in spate
		
		firefoxOption.addArguments("--width=1580");
		firefoxOption.addArguments("--height=1280");
		firefoxOption.addArguments("--start-maximised");
		return firefoxOption;
	
	}
public static EdgeOptions getEdgeOptions() {
		
	EdgeOptions edgeOption= new EdgeOptions();
	edgeOption.addArguments("--disable-infobars"); // sa dea jos cu "chrome is being controled..."
	edgeOption.addArguments("--disable-gpu"); //relevant pt headless
	edgeOption.addArguments("--disable-dev-shm-usage"); //relevant pt ci-cd
	edgeOption.addArguments("--no-sandbox");             //relevant pt ci-cd
	edgeOption.addArguments("--disable-extensions");
		
	edgeOption.addArguments("--headless");  //nu mai vedem instanta de browser dar ruleaza testele
		//cand se rulease headless fereastra porneste cea mai mica versiune 800, 600 in spate
		
	edgeOption.addArguments("--window-size=1580, 1280");
		
		return edgeOption;
		
	}
}
