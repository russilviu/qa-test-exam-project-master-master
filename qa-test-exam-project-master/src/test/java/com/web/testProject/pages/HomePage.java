package com.web.testProject.pages;

import com.web.testProject.utils.SpringLocomotive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RusS on 4/25/2017.
 */
@Component
public class HomePage {

    @Autowired
    private SpringLocomotive locomotive;

    public void clickVisionAndValuesLinkButton() {
        locomotive.waitForElement(By.cssSelector("article#post-8 div.column.dt-sc-one-third.first div h3 a")).click();
    }

    public List<WebElement> getEmployeePictures() {
        return locomotive.waitForElements(By.cssSelector("img[class=\"attachment-full size-full wp-post-image\"]"));
    }

    public void clickClassesLinkButton() {
        locomotive.waitForElement(By.cssSelector("a[href=\"http://fasttrackit.org/cursuri\"]")).click();
    }

    public List<WebElement> getTypeOfClasses() {
        return locomotive.waitForElements(By.cssSelector("div.dt-sc-buy-now"));
    }

    public void clickRegistrationLinkButton() {
        locomotive.waitForElement(By.cssSelector("a[href=\"http://fasttrackit.org/inscriere\"]")).click();
    }

    public void hoverAndClickITClassesLinkButton() {
        locomotive.waitForElement(By.cssSelector("a[href=\"http://www.fasttrackit.org/cursuri/\"]"));
        locomotive.hoverOver(By.cssSelector("a[href=\"http://www.fasttrackit.org/cursuri/\"]")).click("a[href=\"http://www.fasttrackit.org/curs-de-programare-web/\"]");
    }

    public String getClassName() {
        locomotive.waitForElement(By.cssSelector("div[class=\"content\"] article div div h2")).isDisplayed();
        return locomotive.waitForElement(By.cssSelector("div[class=\"content\"] article div div h2")).getText();
    }

    public String getDescription() {
        return locomotive.waitForElement(By.cssSelector("div[class=\"content\"] article div[class=\"fullwidth-section  \"] div div p:nth-child(1)")).getText();
    }

    public String getTrainerName() {
        return locomotive.waitForElement(By.cssSelector("p strong em")).getText();
    }
}
