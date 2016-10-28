//
//               SERGEY N. MALININ PROPRIETARY INFORMATION
//  This software is supplied under the terms of a license agreement or
//  nondisclosure agreement with Sergey Malinin and may not be copied
//  or disclosed except in accordance with the terms of that agreement.
//        Copyright (c) 2016 Intel Corporation. All Rights Reserved.
//

package ru.smalinin.snim.wiley;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

class WebDriverFactoryChrome implements IAbstractObjectFactory {

    private static final File driverExecutableFile = new File("C:\\Selenium\\chromedriver.exe");
    private static final String driverAbsolutePath =
            System.setProperty(
                "webdriver.chrome.driver",
                driverExecutableFile.getAbsolutePath());

    // Используемая имплементация WebDriver
    private static String driverName =
            System.getProperty(
                    "test.driver",
                    "org.openqa.selenium.chrome.ChromeDriver");

    @Override
    public RemoteWebDriver createWebDriver() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (RemoteWebDriver) Class.forName(driverName).newInstance();


    }

}