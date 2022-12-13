package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.pages.BorrowedBooksPage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class US07_ {
    DashBoardPage dashBoardPage ;
    BookPage bookPage = new BookPage();

    String bookName;
    @And("I search book name called {string}")
    public void iSearchBookNameCalled(String name) {

        bookName = name;
        bookPage.search.sendKeys(name);


    }

    @When("I click Borrow Book")
    public void iClickBorrowBook() {

        bookPage.borrowBook(bookName);


    }

    @Then("verify that book is shown in \"Borrowing Books” page")
    public void verifyThatBookIsShownInBorrowingBooksPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}

        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
        new DashBoardPage().navigateModule("Borrowing Books");

        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));

    }

    @And("verify logged student has same book in database")
    public void verifyLoggedStudentHasSameBookInDatabase() {





    }
}
