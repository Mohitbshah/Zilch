package com.payZilch;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.payZilch.BasePage.driver;

/**
 * Created by Welcome on 02/07/2019.
 */
public class BrowserFactory extends Utils {

    LoadProperties loadprop = new LoadProperties();
    String browser1 = loadprop.getProperty("browser");

    public void selectBrowser() {
        if (browser1.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (browser1.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","src\\test\\Resources\\BrowserDriver\\geckodriver.exe");

            driver = new FirefoxDriver();
        } else {
            System.out.println("Browser Name is Wrong:- " + browser1);
        }
    }
}


