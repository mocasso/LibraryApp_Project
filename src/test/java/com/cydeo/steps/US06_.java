package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US06_ {

    BookPage bookPage = new BookPage();

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        bookPage.a


    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String string) {



    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String string) {



    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String string) {



    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String string) {



    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String string) {



    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {



    }
    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String string) {



    }
    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String string) {




    }
}
