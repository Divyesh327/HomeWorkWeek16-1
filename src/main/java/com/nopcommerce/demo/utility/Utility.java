package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utility extends BasePage
{
   public int generateRandomNumber()
   {
        return (int) (Math.random() * 5000 + 1);
   }

    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element)
    {
        element.click();
    }

    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element)
    {
        return element.getText();
    }

    public void sendTextToElement(By by, String str)
    {
        driver.findElement(by).sendKeys(str);
    }

    public void sendTextToElement(WebElement element, String str)
    {
        element.sendKeys(str);
    }

    public void mouseHoverToElement(By by)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElement(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void mouseHoverToElementAndClick(By by)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void mouseHoverToElementAndClick(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void selectByVisibleTextFromDropDown(By by, String str)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(str);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String str) {
        Select select = new Select(element);
        select.selectByVisibleText(str);
    }

    public void selectByIndexFromDropDown(By by, int index)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectByIndexFromDropDown(WebElement element, int index)
    {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectByValueFromDropDown(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void selectByValueFromDropDown(WebElement element, String value)
    {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void waitUntilElementToBeClickable(By by, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    public void waitUntilPresenceOfElementLocated(By by, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilVisibilityOfElementLocated(By by, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public boolean verifyThatElementIsDisplayed(By by)
    {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(By by, String text)
    {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public List<WebElement> webElementList(By by)
    {
        return driver.findElements(by);
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public void clearTextFromField(By by)
    {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }

    public void sendTabAndEnterKey(By by)
    {
        driver.findElement(by).sendKeys(Keys.TAB);
        //driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public static void takeScreenShot()
    {
        String filePath = System.getProperty("user.dir") + "/src/main/java/co/uk/expedia/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String currentTimeStamp()
    {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName)
    {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/src/main/java/com/demo/nopcommerce/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String takeScreenShot(String fileName)
    {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
