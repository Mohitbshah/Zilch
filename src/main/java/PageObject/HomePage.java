
package PageObject;

import com.payZilch.BasePage;
import com.payZilch.LoadProperties;
import com.payZilch.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by Welcome on 02/07/2019.
 */
public class HomePage extends Utils {

    LoadProperties loadProperties = new LoadProperties();

    //This method will fetch the page title
    public String getTitle() {
        return driver.getTitle();
    }

    // Assert url gor LoginPage
    public void assertUrl(){
        Utils.assertURL("https://customers.payzilch.com/#/login");
    }

    //This will click on login link
    public void clickOnLogin() {
        //Used CSS Locator
        driver.findElement(By.cssSelector("#menu-item-1048>a")).click();
        handleNewTab(driver);
    }

    //This will click on Help link
    public void clickOnHelp() {
        //Used Relative Xpath with contains (text)
        driver.findElement(By.xpath("(//*[contains(text(),'Help')])[1]")).click();
        handleNewTab(driver);
    }
}
