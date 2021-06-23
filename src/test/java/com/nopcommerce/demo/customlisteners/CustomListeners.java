package com.nopcommerce.demo.customlisteners;

import com.nopcommerce.demo.utility.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener
{
    @Override
    public void onTestStart(ITestResult iTestResult)
    {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult)
    {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult)
    {
        String screenshotName = Utility.takeScreenShot(iTestResult.getName());

        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Reporter.log("Click to see Screenshot --> ");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+"><img src="+screenshotName+" height=200 width=200></img></a>");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult)
    {

    }

    @Override
    public void onStart(ITestContext iTestContext)
    {

    }

    @Override
    public void onFinish(ITestContext iTestContext)
    {

    }
}
