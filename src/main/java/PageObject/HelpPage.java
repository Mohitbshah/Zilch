package PageObject;

import com.payZilch.Utils;
import org.openqa.selenium.By;

/**
 * Created by Welcome on 02/07/2019.
 */
public class HelpPage extends Utils {

    private By _zilchMastercard = By.xpath("//*[contains(text(),'Zilch Virtual Mastercard Use')]");

    // used Utils explicit wait method to click on virtual mastercard link
    public void clickZilchMastercard(){
        Utils.waitForElementClickable(_zilchMastercard, 5);
        driver.findElement(_zilchMastercard);
    }

}
