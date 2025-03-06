package com.genesys.web.saucedemo.utils;

import com.genesys.web.common.WebdriverEnum;

public final class Defaults {
    private Defaults(){}

    public final static WebdriverEnum DEFAULT_WEBDRIVER = WebdriverEnum.FIREFOX;
    public final static String SAUCE_URL = "https://www.saucedemo.com/inventory.html";
    public final static String PERF_GLICH_USER_CREDENTIAL_PATH = "src/test/testdata/saucedemo/userprofiles/credential.json";
    public final static String STANDARD_USER_CREDENTIAL_PATH = "src/test/testdata/saucedemo/userprofiles/standard.json";
}
