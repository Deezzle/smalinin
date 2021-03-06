//
//               SERGEY N. MALININ PROPRIETARY INFORMATION
//  This software is supplied under the terms of a license agreement or
//  nondisclosure agreement with Sergey Malinin and may not be copied
//  or disclosed except in accordance with the terms of that agreement.
//        Copyright (c) 2016 Intel Corporation. All Rights Reserved.
//

package ru.smalinin.snim.wiley;

import org.openqa.selenium.remote.RemoteWebDriver;

class CommonWebDriver {
    private RemoteWebDriver _driver;

    CommonWebDriver(IAbstractObjectFactory factory)
            throws IllegalAccessException,
            InstantiationException,
            ClassNotFoundException {

        _driver = factory.createWebDriver();

    }

    RemoteWebDriver get_driver() {
        return _driver;
    }
}