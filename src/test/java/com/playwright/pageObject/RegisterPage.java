package com.playwright.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.example.base.BaseTClass;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterPage extends BaseTClass {
    public Page page;

    public RegisterPage(Page page) {
        super(page);
        this.page = page;
    }

    public void assertRegister() {
        assertThat(page).hasURL("https://demo.automationtesting.in/Register.html");
    }

    public void inputFirstName(String firstName){
        Locator a = page.locator("//input[@placeholder='First Name']");
        a.isVisible();
        a.click();
        a.clear();
        a.fill(firstName);
        assertThat(a).isVisible();
    }

    public void inputLastName(String lastName) {
        Locator a = page.locator("//input[@placeholder='Last Name']");
        a.isVisible();
        a.click();
        a.clear();
        a.fill(lastName);
        assertThat(a).isVisible();
    }

    public void inputAddress(String address) {
        Locator a = page.locator("//textarea[@ng-model='Adress']");
        a.isVisible();
        a.click();
        a.clear();
        a.fill(address);
        assertThat(a).isVisible();
    }

    public void inputEmail(String email) {
        Locator a =page.locator("//input[@type='email']");
        a.isVisible();
        a.click();
        a.clear();
        a.fill(email);
    }

    public void inputPhone(String phone) {
        Locator a = page.locator("//input[@type='tel']");
        a.isVisible();
        a.click();
        a.clear();
        a.fill(phone);
    }

    public void selectGender(String gender) {
        if (gender.equals("male")) {
            page.locator("//input[@value='Male']").click();
            assertThat(page.locator("//input[@value='Male']")).isVisible();
        } else if (gender.equals("female")) {
            page.locator("//input[@value='FeMale']").click();
            assertThat(page.locator("//input[@value='FeMale']")).isVisible();
        } else {
            System.out.println("Error: " +gender);
        }
    }

    public void checkHobbies1(){
        page.locator("//input[@id='checkbox1']").check();
    }

    public void checkHobbies2() {
        page.locator("//input[@id='checkbox2']").check();
    }

    public void checkHobbies3() {
        page.locator("//input[@id='checkbox3']").check();
    }

    public void selectHobbies(String hobbies) {
        switch (hobbies) {
            case "cricket":
                checkHobbies1();
                break;
            case "movies":
                checkHobbies2();
                break;
            case "hockey":
                checkHobbies3();
                break;
            default:
                System.out.println("Error: "+hobbies+" not found");
        }
    }

    public void selectLanguage() {
        Locator a = page.locator("//div[@id='msdd']");
        a.click();
    }

    public void selectArab() {
        page.locator("//li[contains(.,'Arabic')]").click();
        page.locator("//label[.='Languages']").click();
    }

    public void selectSkills(String text) {
        Locator a = page.locator("//select[@id='Skills']");
        a.selectOption(text);
    }









}
