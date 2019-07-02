package PageObject;

import com.payZilch.Utils;
import org.openqa.selenium.By;

/**
 * Created by Welcome on 02/07/2019.
 */
public class VirtualMastercardPage extends Utils {

    private By _virtualMastercardText = By.xpath("//*[contains(text(),'Zilch Virtual Mastercard Use')]");

    // used assert text method to assert virtual mastercard heading
    public void assertVirtualMastercardHeading(){
        Utils.assertTextMessage("Zilch Virtual Mastercard Use", _virtualMastercardText);
    }
}
