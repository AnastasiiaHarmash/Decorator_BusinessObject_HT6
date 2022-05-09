package com.epam.lab;

import com.epam.lab.businessObject.AddToCart;
import com.epam.lab.businessObject.FilterDropdown;
import com.epam.lab.businessObject.SearchOnHomePage;
import com.epam.lab.util.TestListener;
import com.epam.lab.util.XMLToObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Listeners({TestListener.class})
public class SmokeTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(SmokeTest.class);
    private static XMLToObject xmlToObject;
    SearchOnHomePage searchOnHomePage = new SearchOnHomePage();
    FilterDropdown filterDropdown = new FilterDropdown();
    AddToCart addToCart = new AddToCart();

    static {
        try {
            xmlToObject = new XMLToObject();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object [][] simpleData() {
        return new Object[][] {{"someProduct", "someBrand", "someSum"}};
    }

    @DataProvider
    public Object [][] testData() {
        logger.info("Running dataProvider testData");
        return xmlToObject.testDataMassive();
    }

    @Test(dataProvider = "testData", invocationCount = 5, threadPoolSize = 3)
    public void smokeTest(String product, String brand, String sum) throws InterruptedException {
        logger.info("smokeTest is running");
        searchOnHomePage.stepOneSearchOnHomePage(product);
        filterDropdown.choseProductByFilterDropdown(brand);
        addToCart.addToCart(sum);
        Assert.assertTrue(addToCart.isPriseVisible());
        Assert.assertTrue(Integer.parseInt(sum) < addToCart.getTextFromPrice());
    }
}
