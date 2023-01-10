package com.epam.tc.hw4.ex1.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver setupDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().getImplicitWaitTimeout();
        }
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
