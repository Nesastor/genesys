package com.genesys.api;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestApiTest {
    protected static final Logger LOGGER = LogManager.getLogger(); // TODO Add logging to test steps

    private String url = "https://jsonplaceholder.typicode.com";
    private String endpoint = "/users";

    @Test
    @DisplayName("Get useres, list names and emails, then validate the existence of '@' in the first email")
    public void getUsersTest() throws ClientProtocolException, IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray responseArray = sendGetRequest(String.format("%s%s", url, endpoint));
        ArrayList<String[]> nameAndEmail = extractNameAndEmailList(responseArray);
        logNamesAndEmails(nameAndEmail);
        Assert.assertTrue(
            "First email doesn't contain '@'",
            nameAndEmail.get(0)[1].contains("@")
        );
    }

    private JSONArray sendGetRequest(String getRequest) throws ClientProtocolException, IOException, org.json.simple.parser.ParseException {
        HttpUriRequest request = new HttpGet(getRequest);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String respoString = String.format("{\"response\":%s}", EntityUtils.toString(response.getEntity()));
        JSONObject responseJson = (JSONObject) new JSONParser().parse(respoString);
        return(JSONArray) responseJson.get("response");
    }

    private ArrayList<String[]> extractNameAndEmailList(JSONArray jsonArray) {
        ArrayList<String[]> nameAndEmail = new ArrayList<>();
        for (Object entry : jsonArray) {
            if (entry instanceof JSONObject) {
                String name = ((JSONObject) entry).get("name").toString();
                String email = ((JSONObject) entry).get("email").toString();
                nameAndEmail.add(new String[]{name, email});
            }
        }
        return nameAndEmail;
    }

    private void logNamesAndEmails(ArrayList<String[]> nameAndEmail) {
        nameAndEmail.forEach(entry -> {
            LOGGER.info("{} : {}", entry[0], entry[1]);
        });
    }
}
