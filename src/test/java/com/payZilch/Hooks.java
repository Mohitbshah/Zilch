package com.payZilch;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;


/**
 * Created by Welcome on 02/07/2019.
 */
public class Hooks extends Utils {

    LoadProperties loadProperties = new LoadProperties();
    BrowserFactory browserFactory = new BrowserFactory();


    @Before
    public void openBrowser(){
        browserFactory.selectBrowser();
        driver.get(loadProperties.getProperty("url"));
        driver.manage().deleteAllCookies();

    }

    @After
    public void closeBrowser(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            Utils.screenShotCucumber(scenario);
        }

        driver.quit();
    }
}
