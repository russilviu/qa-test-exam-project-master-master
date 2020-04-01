package com.web.testProject.tests;

import com.web.testProject.pages.ContactUsPage;
import com.web.testProject.utils.AbstractTest;
import com.web.testProject.utils.SpringLocomotive;
import com.web.testProject.utils.TestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by RusS on 4/25/2017.
 */
public class ContactUsPageTest extends AbstractTest {

    private static final String SUCCESS_MESSAGE = "Mesajul dvs. a fost trimis. Vă mulțumim.";

    @Autowired
    private SpringLocomotive locomotive;

    @Autowired
    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void beforeMethod() {
        getContactUsPage();
    }

    @AfterClass
    private void afterClass() {
        locomotive.getDriver().quit();
    }


    @Test(groups = {TestType.REGRESSION, TestType.SANITY})
    public void contactFTITStaffViaContactUsPageTest() throws InterruptedException {
        contactUsPage.completeContactUsForm();
        contactUsPage.submitChanges();
        assertEquals(contactUsPage.getSuccessMessage(), SUCCESS_MESSAGE);
    }

    private void getContactUsPage() {
        locomotive.getDriver().get(urlFactory.getContactUsUrl());
    }

}
