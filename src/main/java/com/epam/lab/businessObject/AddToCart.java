package com.epam.lab.businessObject;

import com.epam.lab.page.BasePage;
import com.epam.lab.page.SearchResultsPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AddToCart extends BasePage {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final Logger logger = LogManager.getLogger(AddToCart.class);

    public AddToCart() { super(); }

    public void addToCart(String sum) throws InterruptedException {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        //redneck code
        Thread.sleep(3000);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.isCartIconVisible());
        logger.info("Click add to cart");
        searchResultsPage.clickListOfCartIcons();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getCartButton());
        logger.info("Click on cart button");
        searchResultsPage.clickOnCartButton();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getPrice());
    }

    public boolean isPriseVisible() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        return searchResultsPage.isPriceVisible();
    }

    public int getTextFromPrice() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        return searchResultsPage.getTextFromPrice();
    }
}
