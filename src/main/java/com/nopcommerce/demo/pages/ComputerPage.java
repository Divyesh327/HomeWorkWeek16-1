package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility
{
    private static final Logger log = LogManager.getLogger(ComputerPage.class.getName());

    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    WebElement desktop;

    public void clickOnDesktop() throws InterruptedException {
        Reporter.log("Click on Desktop Link --> " + desktop.toString() + "<br>");
        Thread.sleep(3000);
        clickOnElement(desktop);
        log.info("Click on Desktop --> " + desktop.toString());
    }
}

