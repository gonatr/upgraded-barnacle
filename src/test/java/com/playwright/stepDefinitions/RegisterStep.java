package com.playwright.stepDefinitions;

import com.microsoft.playwright.Page;
import com.playwright.pageObject.HomePage;
import com.playwright.pageObject.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utils.Hooks;

public class RegisterStep {
    private final Page page;
    public RegisterStep(){
        this.page = Hooks.page;
    }
    HomePage homePage;
    RegisterPage registerPage;

    @Given("User on Page Automation Demo Site")
    public void userOnPageAutomationDemoSite() {
        homePage = new HomePage(page);
        registerPage = new RegisterPage(page);
        homePage.assertHomePage();
    }

    @When("User click skip to sign in")
    public void userClickSkipToSignIn() {
        homePage.clickRegister();
    }

    @Then("User will be redirected to Register page")
    public void userWillBeRedirectedToRegisterPage() {
        registerPage.assertRegister();
    }

    @When("User input {string} value")
    public void userInputValue(String text) {
        if (text.toLowerCase().contains("fullname")){
            registerPage.inputFirstName(registerPage.generateFirstname());
            registerPage.inputLastName(registerPage.generateLastname());
        } else if (text.toLowerCase().contains("address")){
            registerPage.inputAddress(registerPage.generateAddress());
        } else if (text.toLowerCase().contains("email")){
            registerPage.inputEmail(registerPage.generateEmail());
        } else if (text.toLowerCase().contains("phone")){
            registerPage.inputPhone(registerPage.generatePhone());
        } else {
            System.out.println("Error : "+text);
        }
    }

    @And("User select gender {string}")
    public void userSelectGender(String text) {
        registerPage.selectGender(text.toLowerCase());
    }

    @And("User select hobbies {string}")
    public void userSelectHobbies(String text) {
        registerPage.selectHobbies(text.toLowerCase());
    }

    @And("User select language {string}")
    public void userSelectLanguage(String text) {
        if (text.toLowerCase().contains("arab")) {
            registerPage.selectLanguage();
            registerPage.selectArab();
        } else {
            System.out.println("Error: "+text+" Language not found");
        }
    }

    @And("User select skills {string}")
    public void userSelectSkills(String text) throws InterruptedException {
        registerPage.selectSkills(text);
        Thread.sleep(3000);
    }
}
