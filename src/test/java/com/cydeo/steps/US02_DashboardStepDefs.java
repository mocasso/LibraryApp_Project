package com.cydeo.steps;

import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigurationReader;
import com.cydeo.utility.DB_Util;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class US02_DashboardStepDefs {

    LoginPage loginPage;
    DashBoardPage dashBoardPage;




@Given("user login as a {string}")
public void userLoginAsA(String user){

        loginPage=new LoginPage();
        loginPage.login(user);
        BrowserUtil.waitFor(3);
        }

//    @Given("user login as a librarian")
//    public void user_login_as_a_librarian() {
//        loginPage = new LoginPage();
//        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("librarian_username"));
//        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
//        loginPage.loginButton.click();
//
//        BrowserUtil.waitFor(3);

   // }
    String actualNumber;
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {

        dashBoardPage = new DashBoardPage();
         actualNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualNumber = " + actualNumber);


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
       String query = "select count(*) as borrowedBooks from users u\n" +
               "inner join book_borrow b on u.id = b.user_id where is_returned = 0";
        DB_Util.runQuery(query);
        String expectedNumber = DB_Util.getFirstRowFirstColumn();


        Assert.assertEquals(expectedNumber, actualNumber);


    }


    }

