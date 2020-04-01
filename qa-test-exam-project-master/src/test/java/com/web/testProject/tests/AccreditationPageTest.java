package com.web.testProject.tests;

import com.web.testProject.pages.AccreditationPage;
import com.web.testProject.utils.AbstractTest;
import com.web.testProject.utils.TestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by RusS on 4/25/2017.
 */
public class AccreditationPageTest extends AbstractTest {

    @Autowired
    private AccreditationPage accreditationPage;

    @AfterClass
    private void afterClass() {
        locomotive.getDriver().quit();
    }

    @Test(groups = {TestType.REGRESSION, TestType.SANITY})
    public void verifyAccreditationImageIsDisplayed() {
        getAccreditationPage();
        Assert.assertTrue(accreditationPage.isAccreditationImageDisplayed(), "Accreditation image is not displayed");
    }

    private void getAccreditationPage() {
        locomotive.getDriver().get(urlFactory.getAccreditationUrl());
    }

}
