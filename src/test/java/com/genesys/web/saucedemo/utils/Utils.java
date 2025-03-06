package com.genesys.web.saucedemo.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.genesys.web.common.WebdriverEnum;

public class Utils {

    public static User readUser(String credentialsJson) throws FileNotFoundException {
        String credentialDataFile = credentialsJson;
        JSONObject credentialsJsonObj= (JSONObject) JSONValue.parse(new FileReader(credentialDataFile));

        var firstName = credentialsJsonObj.get("first-name");
        var lastName = credentialsJsonObj.get("last-name");
        var postalCode = credentialsJsonObj.get("postalcode");
        var username = credentialsJsonObj.get("username");
        var password = credentialsJsonObj.get("password");

        User user = new User();
        user.firstName = firstName != null ? firstName.toString() : "";
        user.lastName = lastName != null ? lastName.toString() : "";
        user.postalCode = postalCode != null ? postalCode.toString() : "";
        user.username = username != null ? username.toString() : "";
        user.password = password != null ? password.toString() : "";

        return user;
    }

    public static WebDriver getDriver(WebdriverEnum driver) {
        switch (driver) {
            case CHROME:
                return new ChromeDriver();
            case EDGE:
                return new EdgeDriver();
            case FIREFOX:
            default:
                return new FirefoxDriver();
        }
    }
}
