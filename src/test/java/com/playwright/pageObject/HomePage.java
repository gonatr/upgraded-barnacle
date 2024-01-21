package com.playwright.pageObject;

import com.microsoft.playwright.Page;
import org.example.base.BaseTClass;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BaseTClass {
    public Page page;

    public HomePage(Page page) {
        super(page);
        this.page = page;
    }

    String homePage = "https://demo.automationtesting.in/Index.html";

    public void assertHomePage(){
        String a = page.url();
        assertTrue(a.contains(homePage));
        assertThat(page).hasURL(homePage);
    }

    public void clickRegister(){
        page.locator("//img[@id='enterimg']").click();
    }




}
