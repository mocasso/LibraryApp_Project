package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class US03_BooksStepDefs {

    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    BookPage bookPage = new BookPage();


    @Given("I login as a {string}")
    public void i_login_as_a(String user) {

        loginPage=new LoginPage();
        loginPage.login(user);
        BrowserUtil.waitFor(3);
        BrowserUtil.waitForPageToLoad(5);

    }

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String module) {

        bookPage.navigateModule(module);




    }
    List<String> actualCategoryList;
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {

        actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);


    }

    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {

        String query = "select name from book_categories";
        DB_Util.runQuery(query);



    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        List<String> expectedCategortList = DB_Util.getColumnDataAsList("name");

        Assert.assertEquals(expectedCategortList, actualCategoryList);


    }
}