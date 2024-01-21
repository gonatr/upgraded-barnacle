package org.example.base;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;

public class BaseTClass {
    private static Page page;

    public BaseTClass(Page page) {
        BaseTClass.page = page;
    }

    public String generateFirstname() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public String generateLastname() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public String generateAddress() {
        Faker faker = new Faker();
        return faker.address().fullAddress();
    }

    public String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public String generatePhone() {
        Faker faker = new Faker();
        return faker.phoneNumber().cellPhone();
    }

}
