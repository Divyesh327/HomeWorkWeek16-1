package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase
{
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        homePage = new HomePage();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyPageNavigation()
    {
        homePage.mouseHoverOnTopMenu();
        homePage.selectMenu("Apparel"); //Menu are Computers,Electronics,Apparel,Digital downloads,Books,Jewelry,Gift Cards
    }
}
