package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility
{
    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());

    @FindBy(id = "products-orderby")
    WebElement sort_by;

    @FindBy(xpath = "//h2[@class='product-tittle']")
    List<WebElement> productList;

    @FindBy(xpath = "//div[@data-productid='1']/div[2]/div[3]/div[2]/button[3]")
    WebElement addToCart;

    public void sortInOrder(List<WebElement> List)
    {
        List<WebElement> elementList = List;
        List<String> expected = new ArrayList<>();

        for (WebElement element: elementList)
        {
            expected.add(element.getText());
        }

        List<String> actual = new ArrayList<>();
        actual.addAll(expected);

        Collections.sort(actual);
        Assert.assertEquals("Not sorted",expected, actual);
    }

    public void sortByValuePosition(String value)
    {
        Reporter.log("Click on Sort By --> " + sort_by.toString() + "<br>");
        selectByValueFromDropDown(sort_by, value);
        log.info("Sorting --> " + sort_by.toString());
    }

    public void verifyProductListSortedOrNot()
    {
        Reporter.log("Checking the Products Sorted " + productList.toString() + "<br>");
        sortInOrder(productList);
        log.info("Checking the Products Sorted...." + productList.toString());
    }

    public void clickOnAddToCart() throws InterruptedException {
        Reporter.log("Click on Add to Cart --> " + addToCart.toString() + "<br>");
        Thread.sleep(5000);
        clickOnElement(addToCart);
        log.info("Click on Add to Cart --> " + addToCart.toString());
    }
}
