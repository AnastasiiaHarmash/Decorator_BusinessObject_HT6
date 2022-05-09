package com.epam.lab.page;

import com.epam.lab.decorator.CustomTextInput;
import com.epam.lab.decorator.CustomClick;
import org.openqa.selenium.support.FindBy;

public class HomePageRozetka extends BasePage{

    @FindBy(xpath = "//input[@class='search-form__input ng-untouched ng-pristine ng-valid']")
    private CustomTextInput searchField;

    @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")
    private CustomClick searchButton;

    public HomePageRozetka() {
        super();
    }

    public boolean isSearchFieldVisible() { return searchField.isDisplayed(); }
    public void enterTextToSearchField(final String searchText) {
        searchField.customTextInput(searchText);
    }
    public void clickSearchButton() { searchButton.customClick(); }

}
