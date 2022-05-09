package com.epam.lab.decorator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CustomTextInput extends DecoratedElement{

    private static final Logger logger = LogManager.getLogger(CustomTextInput.class);

    public CustomTextInput(WebElement webElement) {
        super(webElement);
    }

    public void customTextInput(String text) {
        logger.info("Send keys from CustomTextInput!");
        webElement.clear();
        webElement.sendKeys(text);
    }

    public WebElement getElement() {
        return webElement;
    }
}
