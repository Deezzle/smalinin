//
//               SERGEY N. MALININ PROPRIETARY INFORMATION
//  This software is supplied under the terms of a license agreement or
//  nondisclosure agreement with Sergey Malinin and may not be copied
//  or disclosed except in accordance with the terms of that agreement.
//        Copyright (c) 2016 Intel Corporation. All Rights Reserved.
//

package ru.smalinin.snim.wiley;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class PMPCourseFreeTrial {

    By userFirstName = By.id("firstName");
    By userLastName = By.id("lastName");
    By userEmail = By.id("email");
    By userEmployerSchool = By.id("employerOrSchool");
    By userCountry = By.id("country");
    By userPassword = By.id("pwd");
    By userConfirmPassword = By.id("checkPwd");
    //By buttonLaunchFreeTrial = By.xpath("/html/body[@class='page-freeTrialPage pageType-ProductPage template-pages-product-freeTrialPage  language-en']/main/div[@class='dummy-class-instead-of-absence-of-any-classes']/div[@class='cfa-free-trial']/div[@class='container']/div[@class='row']/div[@class='col-sm-6 col-xs-12'][2]/form[@id='wileyFreeTrialForm']/div[@class='form-buttons']/span[@class='btn-control']/button[@class='button form-button']");
    By buttonLaunchFreeTrial = By.className("button");

    private static RemoteWebDriver _driver;
    private IAbstractObjectFactory factory;

    // Folder to save screenshots
    private String screenshotDir =
            System.getProperty("test.screenshotDir", "");


    public PMPCourseFreeTrial(RemoteWebDriver driver){
        this._driver = driver;
    }


    /**
     * This POM method will be exposed in test case to fill in the form
     * @param strFirstName
     * @param strLastName
     * @param strEmail
     * @param strEmployerSchool
     * @param strCountry
     * @param strEnterPassword
     * @param strConfirmPassword
     * @return
     */
    public void fillForm(String strFirstName,
                           String strLastName,
                           String strEmail,
                           String strEmployerSchool,
                           String strCountry,
                           String strEnterPassword,
                           String strConfirmPassword){

        //Fill user first name
        this.setFirstName(strFirstName);
        //Fill user last name
        this.setLastName(strLastName);
        //Fill user email
        this.setEmail(strEmail);
        //Fill user employer school
        this.setEmployerSchool(strEmployerSchool);
        //Fill user country
        this.setCountry(strCountry);
        //Fill user password
        this.setEnterPassword(strEnterPassword);
        //Fill password confirmation
        this.setConfirmPassword(strConfirmPassword);
    }

    private void setConfirmPassword(String strConfirmPassword) {
        _driver.findElement(userConfirmPassword).sendKeys(strConfirmPassword);
    }

    private void setEnterPassword(String strEnterPassword) {
        _driver.findElement(userPassword).sendKeys(strEnterPassword);
    }

    private void setCountry(String strCountry) {
        _driver.findElement(userCountry).sendKeys(strCountry);
    }

    private void setEmployerSchool(String strEmployerSchool) {
        _driver.findElement(userEmployerSchool).sendKeys(strEmployerSchool);
    }

    private void setEmail(String strEmail) {
        _driver.findElement(userEmail).sendKeys(strEmail);
    }

    private void setLastName(String strLastName) {
        _driver.findElement(userLastName).sendKeys(strLastName);
    }

    private void setFirstName(String strFirstName) {
        _driver.findElement(userFirstName).sendKeys(strFirstName);
    }

    /**
     * This POM method will be exposed in test case to press the Launch Free Trial button
     * @return
     */
    public void clickLaunchFreeTrial() {
        _driver.findElement(buttonLaunchFreeTrial).click();
    };
}