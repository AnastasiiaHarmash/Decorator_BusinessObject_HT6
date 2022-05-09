package com.epam.lab.businessObject;

import com.epam.lab.page.BasePage;
import com.epam.lab.page.SearchResultsPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class FilterDropdown extends BasePage {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final Logger logger = LogManager.getLogger(FilterDropdown.class);

    public FilterDropdown() { super(); }

    public void choseProductByFilterDropdown(String brand) throws InterruptedException {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSearchBrandField());
        Assert.assertTrue(searchResultsPage.isSearchBrandFieldVisible());
        logger.info("Enter brand to search field");
        searchResultsPage.enterTextToSearchBrandField(brand);
        //redneck code
        Thread.sleep(3000);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getListCheckBox());
        Assert.assertTrue(searchResultsPage.isListCheckBoxVisible());
        Assert.assertTrue(searchResultsPage.isListCheckBoxEnabled());
        logger.info("Click check box");
        searchResultsPage.clickListCheckBox();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getFilterDropDown());
        logger.info("Click filter dropdown");
        searchResultsPage.clickFilterDropDown();
        searchResultsPage.clickFromExpensiveToCheap();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);

    }
}
