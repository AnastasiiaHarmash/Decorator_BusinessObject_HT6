package com.epam.lab.decorator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CustomClick extends DecoratedElement{

    private static final Logger logger = LogManager.getLogger(CustomClick.class);

    public CustomClick(WebElement webElement) {
        super(webElement);
    }

    public void customClick()
    {
        webElement.click();
        logger.info("Click from CustomClick class");
    }

    public WebElement getElement() {
        return webElement;
    }
}
