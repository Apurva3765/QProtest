package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FunctionClass {
	public static WebDriver driver;
	public static String value;

	public static String getHomePath() {
		String homePath;
		homePath = System.getProperty("user.dir");
		return homePath;
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String[] getKeywordParam(String strParams) {
		String params[];
		params = strParams.split("@#");
		return params;
	}


	public String getElementText(WebElement ele) {
		String eleText = ele.getText();
		return eleText;
	}
	public String getElementText(By locator) {
		WebElement ele=driver.findElement(locator);
		String eleText = ele.getText();
		return eleText;
	}

	public String readProperties(String key) throws IOException {

		try {

			String configPath = getHomePath() + "\\config\\appConfig.properties";
			FileInputStream fis = new FileInputStream(configPath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}

	public void waitExplicitely(WebElement ele, String expectedCondition, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		switch (expectedCondition) {
		case "elementToBeClickable": {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		case "visibility": {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		case "invisibility": {
			wait.until(ExpectedConditions.invisibilityOf(ele));
		}
		}

	}

	public void moveToElement(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.perform();
	}

	public WebDriver launchBrowser(String browserName, String url) {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", getHomePath() + "\\resources\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);
				driver.get(url);

			}
			if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", getHomePath() + "\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
				driver.get(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

	public WebElement createElement(By locator) {
		WebElement ele = driver.findElement(locator);
		return ele;
	}

	public List<WebElement> getElementList(By locator) {
		List<WebElement> eleList = new ArrayList<WebElement>();
		eleList = driver.findElements(locator);
		return eleList;
	}

	public void dragAndDrop(WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).build().perform();
	}

	public void dragAndDrop(By src, By dest) {
		WebElement ele1 = driver.findElement(src);
		WebElement ele2 = driver.findElement(dest);
		Actions act = new Actions(driver);
		act.clickAndHold(ele1);
		act.dragAndDrop(ele1, ele2).build().perform();
	}

	public void checkRadio(WebElement ele) {
		ele.click();
	}

	public void enterText(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	public void enterText(By locator, String text) {
		WebElement ele = createElement(locator);
		ele.sendKeys(text);
	}

	public void quit() {
		driver.close();
		driver.quit();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void click(By locator) {
		WebElement ele = createElement(locator);
		ele.click();
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public boolean displayStatus(By locator) {
		WebElement ele = createElement(locator);
		boolean status = ele.isDisplayed();
		return status;
	}
	public boolean displayStatus(WebElement ele) {
		boolean status = ele.isDisplayed();
		return status;
	}

	public void selectByIndex(By locator, int index) {
		WebElement ele = createElement(locator);
		Select s = new Select(ele);
		s.selectByIndex(index);
	}

	public void selectByText(By locator, String text) {
		WebElement ele = createElement(locator);
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	public void selectByValue(By locator, String value) {
		WebElement ele = createElement(locator);
		Select s = new Select(ele);
		s.selectByValue(value);
	}
	
	public int getMatrixIndex(String key)
	{
		int value=0;
		final Map<String,Integer> matrixMap=new HashMap<String,Integer>();
		matrixMap.put("CommunicationVeryUncomfortable",11);
		matrixMap.put("CommunicationSomewhatUncomfortable",12);
		matrixMap.put("CommunicationNeutral",13);
		matrixMap.put("CommunicationSomewhatComfortable",14);
		matrixMap.put("CommunicationVeryComfortable",15);
		matrixMap.put("CommunicationNA",16);
		matrixMap.put("AptitudeVeryUncomfortable",20);
		matrixMap.put("AptitudeSomewhatUncomfortable",21);
		matrixMap.put("AptitudeNeutral",22);
		matrixMap.put("AptitudeSomewhatComfortable",23);
		matrixMap.put("AptitudeVeryComfortable",24);
		matrixMap.put("AptitudeNA",25);
		matrixMap.put("SkillsetVeryUncomfortable",29);
		matrixMap.put("SkillsetSomewhatUncomfortable",30);
		matrixMap.put("SkillsetNeutral",31);
		matrixMap.put("SkillsetSomewhatComfortable",32);
		matrixMap.put("SkillsetVeryComfortable",33);
		matrixMap.put("SkillsetNA",34);
		value=matrixMap.get(key);
		return value;
	}
}
