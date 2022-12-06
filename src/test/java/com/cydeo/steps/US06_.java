package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class US06_ {

    BookPage bookPage = new BookPage();

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        BrowserUtil.waitForPageToLoad(5);
        bookPage.addBook.click();


    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String name) {

         bookPage.bookName.sendKeys(name);

    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {

        bookPage.isbn.sendKeys(isbn);

    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {

        bookPage.year.sendKeys(year);

    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {

        bookPage.author.sendKeys(author);

    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String category) {

        BrowserUtil.selectOptionDropdown(bookPage.categoryDropdown , category);

    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

        bookPage.saveChanges.click();


    }
    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String actualBName) throws InterruptedException {

//        Thread.sleep(3000);
//       bookPage.search.sendKeys(actualBName);
//        Thread.sleep(3000);



    }
    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String expectedBookName) {

        String query = "select id,name,author from books\n" +
                "where name = '"+expectedBookName+"' "+
                "order by id desc" ;

        DB_Util.runQuery(query);

        Map<String, String> rowMap = DB_Util.getRowMap(1);

        String actualBookNAme = rowMap.get("name");

        Assert.assertEquals(expectedBookName, actualBookNAme);


    }
}
