package com.epam.lab.businessObject;

import com.epam.lab.page.BasePage;
import com.epam.lab.page.HomePageRozetka;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SearchOnHomePage extends BasePage {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final Logger logger = LogManager.getLogger(SearchOnHomePage.class);

    public SearchOnHomePage() { super(); }

    public void stepOneSearchOnHomePage(String product) {
        logger.info("Step one - search on the Home Page");
        HomePageRozetka homePageRozetka = new HomePageRozetka();
        homePageRozetka.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        logger.info("Enter text to text field");
        homePageRozetka.enterTextToSearchField(product);
        homePageRozetka.clickSearchButton();
    }
}
