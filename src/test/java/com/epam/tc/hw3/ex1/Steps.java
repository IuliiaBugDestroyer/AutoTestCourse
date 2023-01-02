package com.epam.tc.hw3.ex1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.epam.tc.hw3.ex1.pages.Frame;
import com.epam.tc.hw3.ex1.pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Steps {
    private WebDriver driver;
    private IndexPage indexPage;
    private Frame frame;

    public Steps(WebDriver driver) {
        this.driver = driver;

        this.indexPage = new IndexPage(this.driver);
        this.frame = new Frame(this.driver);
    }

    public Steps login() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.login("Roman", "Jdi1234");
        return this;
    }

    public Steps verifyBrowserTitle() {
        String getActualTitle = driver.getTitle();
        assertEquals(getActualTitle, "Home Page");
        return this;
    }

    public Steps verifyUsername(String correctUsername) {
        assertEquals(correctUsername, indexPage.getUsername().getText());
        return this;
    }

    public Steps verify4Items() {
        assertArrayEquals(indexPage.getTabs().stream().map(x -> x.getText()).toArray(),
                new String[]{"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"});
        return this;
    }

    public Steps verify4Pictures() {
        int count = indexPage.getPict().size();
        assertEquals(count, 4);
        return this;
    }

    public Steps verifyPictTexts() {
        assertEquals(indexPage.getPictText().stream().filter(x -> x.getText() != null).count(), 4);
        return this;
    }

    public Steps verifyLeftSect() {
        assertArrayEquals(indexPage.getLeftSect().stream().map(x -> x.getText())
                .toArray(), new String[]{"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"});
        return this;
    }

    public Steps verifyFrame() {
        assertNotNull(frame.getFrame());
        return this;
    }

    public Steps switchToFrame() {
        driver.switchTo().frame(frame.getFrame());

        return this;
    }

    public Steps switchToMain() {
        driver.switchTo().parentFrame();

        return this;
    }

    public Steps verifyFrameBtn() {
        assertNotNull(frame.getFrameBtn());
        return this;
    }
}
