//
//               SERGEY N. MALININ PROPRIETARY INFORMATION
//  This software is supplied under the terms of a license agreement or
//  nondisclosure agreement with Sergey Malinin and may not be copied
//  or disclosed except in accordance with the terms of that agreement.
//        Copyright (c) 2016 Intel Corporation. All Rights Reserved.
//

package ru.smalinin.snim.wiley;

import org.junit.*;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TestPMPCourseFreeTrial {

    // Constants
    public static final String TEST_PAGE_ADDRESS = "https://www.efficientlearning.com/pmp/products/course-free-trial/";

    private static RemoteWebDriver _driver;
    private IAbstractObjectFactory factory;

    private PMPCourseFreeTrial objPMPCourseFreeTrial;

    // Папка для скриншотов
    private String screenshotDir =
            System.getProperty("test.screenshotDir", "");

    /**
     * Chrome
     */
    @Test
    public void testFillingInFormChrome()
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {


        // Create Web Driver
        factory = new WebDriverFactoryChrome();
        _driver = new CommonWebDriver(factory).get_driver();
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        _driver.get(TEST_PAGE_ADDRESS);

        //Create PMP Course Free Trial Page object
        objPMPCourseFreeTrial = new PMPCourseFreeTrial(_driver);

        // waiting for 500 ms
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fill in the form
        objPMPCourseFreeTrial.fillForm("Sergey",
                "Malinin",
                "sergey.n.malinin@gmail.com",
                "Intel",
                "",
                "Qwerty123",
                ""
        );


        // waiting for 3 s
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Press the Launch Free Trial button
        objPMPCourseFreeTrial.clickLaunchFreeTrial();



        // waiting for 10 s
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public MethodRule watchman = new TestWatchman() {

        /**
         * Будет вызван при каждом "проваленном" тесте
         * @param e Брошенное тестом исключение
         * @param method Тест-метод
         */
        @Override
        public void failed(Throwable e, FrameworkMethod method) {
            if(_driver instanceof TakesScreenshot && !screenshotDir.equals("")) {
                String browserName = _driver.getClass().getName();
                String testSuiteName = method.getMethod().getDeclaringClass().getName();
                browserName =
                        browserName.substring(browserName.lastIndexOf('.') + 1);
                testSuiteName =
                        testSuiteName.substring(testSuiteName.lastIndexOf('.') + 1);

                byte[] screenshot =
                        ((TakesScreenshot)_driver).getScreenshotAs(OutputType.BYTES);
                try {
                    FileOutputStream stream =
                            new FileOutputStream(
                                    new File(
                                            String.format("%s/screenshot_%s_%s_%s.png",
                                                    screenshotDir,
                                                    browserName,
                                                    testSuiteName,
                                                    method.getName())));
                    stream.write(screenshot);
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace(System.out);
                }
            }
        }
    };

    @AfterClass
    public static void tearDown() {
        _driver.quit();
    }
}