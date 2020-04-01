package com.web.testProject.pages;

import com.web.testProject.utils.SpringLocomotive;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by RusS on 4/25/2017.
 */
@Component
public class ContactUsPage {

    @Autowired
    private SpringLocomotive locomotive;


    public void completeContactUsForm() {
        fillNameField().sendKeys("Just and automated test.");
        fillEmailField().sendKeys(RandomStringUtils.randomAlphabetic(4) + "@gmail.com");
        fillSubjectField().sendKeys("Accreditation automated test");
        filldMessageField().sendKeys("This is just a simple test for accreditation exam.");
    }

    public void submitChanges() {
        locomotive.waitForElement(By.cssSelector("input[class=\"wpcf7-form-control wpcf7-submit\"]")).click();
    }

    public String getSuccessMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return locomotive.waitForElement(By.cssSelector("div.wpcf7-response-output")).getText();
    }

    private WebElement fillNameField() {
        return locomotive.waitForElement(By.cssSelector("input[name=\"your-name\"]"));
    }

    private WebElement fillEmailField() {
        return locomotive.waitForElement(By.cssSelector("input[name=\"your-email\"]"));
    }

    private WebElement fillSubjectField() {
        return locomotive.waitForElement(By.cssSelector("input[name=\"your-subject\"]"));
    }

    private WebElement filldMessageField() {
        return locomotive.waitForElement(By.cssSelector("textarea[name=\"your-message\"]"));
    }
}
