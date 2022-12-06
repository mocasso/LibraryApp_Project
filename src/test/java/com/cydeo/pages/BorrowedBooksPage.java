package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BorrowedBooksPage extends com.cydeo.pages.BasePage {


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;
}