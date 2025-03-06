package com.genesys.web.guru99.e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.genesys.web.common.BaseWebTest;
import com.genesys.web.guru99.utils.Defaults;

public class IFrameTest extends BaseWebTest {
    protected static final Logger LOGGER = LogManager.getLogger(); // TODO Add logging to test steps

    public IFrameTest() {
        super(Defaults.DEFAULT_WEBDRIVER, Defaults.DEMO_GURU99_URL);
    }

    @Test
    @DisplayName("TODO")
    public void iframeAndTabHandlingTest() {
        // TODO Write test
    }
}
