package com.web.testProject.pages;

import com.web.testProject.utils.SpringLocomotive;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by RusS on 4/25/2017.
 */
@Component
public class AccreditationPage {

    @Autowired
    private SpringLocomotive locomotive;

    public boolean isAccreditationImageDisplayed() {
        return locomotive.waitForElement(By.cssSelector("img[class=\" wp-image-9457 aligncenter dt-sc-entry-thumb\"]")).isDisplayed();
    }
}
