package com.epam.lab.decorator;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.*;

import java.lang.reflect.Field;

public abstract class AbstractElement implements WebElement {
    protected WebElement webElement;

    public AbstractElement(WebElement webElement) { this.webElement = webElement; }


    public static class ExtendedFieldDecorator extends DefaultFieldDecorator {
        public ExtendedFieldDecorator(ElementLocatorFactory factory) {
            super(factory);
        }

        @Override
        public Object decorate(ClassLoader loader, Field field) {
            if (field.getType().equals(DecoratedElement.class)) {
                ElementLocator locator = factory.createLocator(field);
                if (locator == null) {
                    return null;
                }
                return new DecoratedElement(proxyForLocator(loader, locator)) {
                };
            } else if (field.getType().equals(CustomClick.class)) {
                ElementLocator locator = factory.createLocator(field);
                if (locator == null) {
                    return null;
                }
                return new CustomClick(proxyForLocator(loader, locator)) {
                };
        } else if (field.getType().equals(CustomTextInput.class)) {
                ElementLocator locator = factory.createLocator(field);
                if (locator == null) {
                    return null;
                }
                return new CustomTextInput(proxyForLocator(loader, locator)) {
                };
            }
            return super.decorate(loader, field);
    }
    }
}


