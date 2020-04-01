package com.web.testProject.tests;

import com.web.testProject.pages.HomePage;
import com.web.testProject.utils.AbstractTest;
import com.web.testProject.utils.Classes;
import com.web.testProject.utils.DBUtils;
import com.web.testProject.utils.TestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by RusS on 4/25/2017.
 */
public class HomePageTest extends AbstractTest {

    @Autowired
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        goToHomePage();
    }

    @AfterClass
    private void afterClass() {
        locomotive.getDriver().quit();
    }


    @DataProvider
    public Object[][] classes() {
        try {
            List<Classes> classesData = DBUtils.dbRead();

            Object[][] objArray = new Object[classesData.size()][];

            for (int i = 0; i < classesData.size(); i++) {
                objArray[i] = new Object[1];
                objArray[i][0] = classesData.get(i);
            }

            return objArray;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test(groups = {TestType.REGRESSION, TestType.SANITY}, priority = 2)
    public void verifyVisionAndValuesLinkButtonFunctionalityTest() {
        homePage.clickVisionAndValuesLinkButton();

        assertTrue(locomotive.getDriver().getCurrentUrl().contains(("despre")), "Current URL does not contains 'despre'");
        assertEquals(homePage.getEmployeePictures().size(), 8, "Invalid count of employee images!");
    }

    @Test(groups = {TestType.REGRESSION, TestType.SANITY}, priority = 3)
    public void verifyClassesLinkButtonFunctionalityTest() {
        homePage.clickClassesLinkButton();

        assertTrue(locomotive.getDriver().getCurrentUrl().contains("cursuri"), "Current URL does not contains 'cursuri'");
        assertEquals(homePage.getTypeOfClasses().size(), 7, "There are displayed more/less type of classes!");
    }

    @Test(groups = {TestType.REGRESSION, TestType.SANITY}, priority = 4)
    public void verifyRegistrationLinkButtonFunctionalityTest() {
        homePage.clickRegistrationLinkButton();

        assertTrue(locomotive.getDriver().getCurrentUrl().contains("inscriere"), "Current URL does not contains 'inscriere'");
        assertEquals(homePage.getTypeOfClasses().size(), 7, "There are displayed more/less type of classes!");
    }

    @Test(groups = {TestType.REGRESSION, TestType.SANITY}, priority = 1, dataProvider = "classes")
    public void verifyITClassesInfoContentTest(Classes classes) {
        homePage.hoverAndClickITClassesLinkButton();
        assertEquals(homePage.getClassName(), classes.getName(), String.format("Invalid Class name displayed: '%s'!", homePage.getClassName()));
        assertEquals(homePage.getDescription(), classes.getDescription(), String.format("Invalid Description displayed '%s'!", homePage.getDescription()));
        assertEquals(homePage.getTrainerName(), classes.getTrainer(), String.format("Invalid trainer name displayed: '%s'!", homePage.getTrainerName()));
        //todo: this test should be shown at the accreditation exam.
    }

    private void goToHomePage() {
        locomotive.getDriver().get(urlFactory.getHomeUrl());
    }


}
