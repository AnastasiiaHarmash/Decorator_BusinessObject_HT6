package com.epam.lab;

import com.epam.lab.util.DriverFactoryManager;
import com.epam.lab.util.PropertiesReader;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    PropertiesReader propertiesReader = new PropertiesReader();

    @BeforeTest
    public void profileSetUp() {
        BasicConfigurator.configure();
        logger.info("BeforeTest in progress.");
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());

    }

    @BeforeMethod
    public void testsSetUp() {
        logger.trace("BeforeMethod in progress.");
        DriverFactoryManager.setDriver();
        DriverFactoryManager.getDriver().manage().window().maximize();
        DriverFactoryManager.getDriver().get(propertiesReader.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        logger.info("AfterMethod, driver close.");
        DriverFactoryManager.closeDriver();
    }

}
