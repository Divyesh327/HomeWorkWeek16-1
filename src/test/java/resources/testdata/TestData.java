package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData
{
    @DataProvider(name = "credentials")
    public Object[][] getLoginData()
    {
        Object[][] data = new Object[][]
        {
                {"Div@gmail.com","Div123"},
                {"Div123@gmail.com","London456"},
        };
        return data;
    }

}
