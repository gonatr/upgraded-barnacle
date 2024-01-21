package org.example.utils;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class Hooks {
    public static Page page;

    @Before
    public void setPageBrowser() {
        // create playwright and browser instances
        try (Playwright playwright = Playwright.create()){
            Properties properties = new Properties();
            FileInputStream propertiesFile = new FileInputStream("src/main/java/org/example/config/config.properties");
            properties.load(propertiesFile);

            page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                    .setArgs(List.of("--start-maximized")))
                    .newContext(new Browser.NewContextOptions().setViewportSize(null))
                    .newPage();
            page.navigate(properties.getProperty("baseUrl"));

            System.out.println("Starting the test....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("End of the test.");
        // validate if scenario has failed
        if (scenario.isFailed()) {
            byte[] screenshotBytes = page.screenshot();
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        } else {
            byte[] screenshotBytes = page.screenshot();
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
        page.close();
    }
}
