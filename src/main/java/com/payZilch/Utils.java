package com.payZilch;



import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.FileUtils.copyFile;


/**
 * Created by Welcome on 02/07/2019.
 */
public class Utils extends BasePage {

    //Resuable method for click
    public static void clickElementBy(By by) {
        driver.findElement(by).click();
    }

    public static void currentUrl(String text)
    {
        driver.get(text);
    }

    //Reusable method for entering any text/string (eg: entering name/password/email)
    public static void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    //Reusable method for Assert equals where we want to know expected = actual
    public static String textGet(By by) {
        return driver.findElement(by).getText();
    }

    //Reusable method to clear the text from input box
    public static void textClear(By by) {
        driver.findElement(by).clear();
    }

    //Reusable method to check if element is present and element is not present
    public static void webElementPresent(By by) {
        if (driver.findElement(by).isDisplayed()) {
            System.out.println("Element is Present");
        } else {
            System.out.println("Element is not Present");
        }
    }

    //Reusable method to check if element is displayed and element is not displayed
    public static void webElementDisplayed(By by) {
        if (driver.findElement(by).isDisplayed()) {
            System.out.println("Element is Displayed");
        } else {
            System.out.println("Element is not Displayed");
        }
    }

    //Reusable method to try to click element three times if not available in first go
    public static void elementThreeTimes(By by) {
        if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else {
            System.out.println("Element is not Visible");
        }
    }
    //Method for Implicit wait for element to be displayed
    public static void implicitWait(int time)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //Method for Explicit wait for element to be displayed/visible
    public static void waitForElementDisplay(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Reusable method for Explicit wait for element to be clickable
    public static void waitForElementClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Method for Explicit wait for locator to be clickable
    public static void waitForLocatorClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Method for Explicit wait for element to be invisible
    public static void waitForElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //Method for date short
    public static String shortDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("mmddyyyyHHmmss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

    //Method for Random Date
    public String randomDate() {
        DateFormat format = new SimpleDateFormat("ddMMMyyHHmmss");
        return format.format(new Date());
    }

    public static int cal(){

        int maths = 1+1;

        return maths;
    }


    //Method for date long
    public static void longDate() {
        Date ts = new Date(System.currentTimeMillis());
        Date date = new Date(ts.getTime());
        System.out.println("Current date and time is = " + date);
    }

    //Method for selecting any text/string from dropdown or list (eg: dropdown menu for month/week etc)
    public static void selectVisibleTextBy(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //Method for selecting any value i.e.numbers (eg: dropdown menu for selecting numbers)
    public static void selectTextByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }


    //Method for selecting any value i.e.numbers (eg: dropdown menu for selecting numbers)
    public static void selectByNumber(By by, int number) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    //Method for selecting value from dropdown
    public static void selectValueFromDropdown(By by, String text, int number) {
        Select select = new Select(driver.findElement(by));
        WebElement option = select.getFirstSelectedOption();
        String selectedValue = option.getText();
        System.out.println(selectedValue);
    }

    //Method used for scroll to view element
    public static void scrollViewElement(By by) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(element.getText());
    }

    //Method for Scroll to view element and click
    public static void scrollElementClick(By by) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        System.out.println(element.getText());
    }

    //Method for alert to display
    public static void alertDisplay(By by, int time) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println("Alert box text " + alert.getText());
            alert.accept();

        } catch (NoAlertPresentException noAlert) {
            noAlert.getMessage();
        }
    }

    //Method to get attribute of element
    public static void attributeGet(By by, String text, int number) {
        driver.findElement(by).getAttribute(text);
    }

    //Method to get css property of element
    public static void propertyOfCss(By by, String text) {
        driver.findElement(by).getCssValue(text);
    }

    //Method to get screenshot of browser
    public static void takeScreenshot(WebDriver driver, String testName)
    {
        try {
            File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File("./src/Screenshots/" + testName + ".png");
            copyFile(sourcepath, destinationPath);
            System.out.println("screenshot saved in desired folder");
        }
        catch(Exception e)
        {
            System.out.println("Exception while taking Screenshot" + e.getMessage());
        }
    }

    //Method to get screenshot of current display full
//    public static void fullDisplayScreenshot() {
//        Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
//        try {
//            ImageIO.write(screenshot.getImage(), "PNG", new File("src\\Screenshot"));
//        } catch (IOException ex) {
//            System.out.println("There is a problem in taking a screenshot");
//
//        }
//    }

    //Method to convert date into String
    public static void StringDate()
    {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
    }

    //Method to do assert URL

    public static void assertURL(String expected)
    {
        try {
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, expected);
            System.out.println("Expected Result : " + expected);
            System.out.println("Actual Result : " + URL);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method to do expected = actual

    public static String getTextFromElement(By by)
    {
        String text = driver.findElement(by).getText();
        return text;
    }

    public static void assertTextMessage(String expected, By by) {
        try {
            String actual = getTextFromElement(by);
            Assert.assertEquals(expected, actual);
            System.out.println("Expected Result : " + expected);
            System.out.println("Actual Result : " + actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Method for Hover action
    public  static void elementAction (By by,By by1)

    {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.moveToElement(element).moveToElement(driver.findElement(by1)).click().build().perform();
    }

    public static void verifyPriceIsAscendingOrDescendingOrder (By by)

    {
        java.util.List<WebElement> price = driver.findElements(by);
        //  System.out.println(price.size());
        //List ourAl = new ArrayList<>();
        for (int i = 0; i<price.size(); i=i+1)
        {
            System.out.println(price.get(i).getText());
        }

    }

    public static void handleNewTab(WebDriver driver){
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindowHandles=driver.getWindowHandles();
        Iterator<String> iterator=allWindowHandles.iterator();
        while (iterator.hasNext()){
            String childWindow=iterator.next();
            if(!mainWindow.equals(childWindow)){
                driver.switchTo().window(childWindow);
            }
        }
    }

    public static void screenShotCucumber(Scenario scenario){
        {
            String screenshotName = scenario.getName().replaceAll(".,:;?!", "") + shortDate() + ".png";
            try {
                //This takes a screenshot from the driver at save it to the location
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'Screenshots' within the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "target\\cukeReport\\Screenshots" + screenshotName);
                //Copy taken screenshot from source location to destination location
                copyFile(sourcePath, destinationPath);
                scenario.write("!!!!!!....Scenario Failed....!!!!Please see attached screenshot for the error/issue");
                //attach the screenshot to our report
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (IOException e) {
            }

        }
    }


}
