package com.sdirect.sports.network;


public class ApiUtils {
    public static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";
    public static final String NEWS_URL= "https://newsapi.org/v2/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(NEWS_URL).create(APIService.class);
    }

}

